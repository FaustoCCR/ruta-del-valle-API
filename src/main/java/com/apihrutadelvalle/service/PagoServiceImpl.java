package com.apihrutadelvalle.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDto;
import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.Pago;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.DetalleConsumoRepository;
import com.apihrutadelvalle.repository.PagoRepository;
import com.apihrutadelvalle.repository.ReservaRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class PagoServiceImpl implements PagoService{
	
	@Autowired
	private PagoRepository pagoRepository;
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private DetalleConsumoRepository detalleConsumoRepository;
	
	
	private PagoDto mapToPagoDTO(Pago pago) {
		
		PagoDto dto = new PagoDto();
		dto.setId_pago(pago.getId_pago());
		dto.setId_reserva(pago.getReserva().getId_reserva());
		dto.setFecha_emision(pago.getFecha_emision());
		dto.setSubtotal(pago.getSubtotal());
		dto.setTotal(pago.getTotal_pago());
		
		return dto;
	}
	
	private PagoDetalleDTO mapToPagoDetalleDTO(Pago pago) {
		
		PagoDetalleDTO detalleDTO = new PagoDetalleDTO();
		
		detalleDTO.setId_pago(pago.getId_pago());
		detalleDTO.setId_reserva(pago.getReserva().getId_reserva());
		detalleDTO.setCliente(pago.getReserva().getUsuario().getNombre());
		detalleDTO.setNum_habitacion(pago.getReserva().getHabitacion().getNum_habitacion());
		detalleDTO.setTipo_habitacion(pago.getReserva().getHabitacion().getTipo_Habitacion().getNombre());
		detalleDTO.setPlanta(pago.getReserva().getHabitacion().getPlanta().getNombre());
		detalleDTO.setFecha_emision(pago.getFecha_emision());

		
		Consumo consumo = consumoRepository.findByReserva(pago.getReserva())
				.orElse(null);
				
		double pagoConsumo;
		if (consumo!=null) {
			pagoConsumo = consumo.getListaDetalle().stream()
					.map(c -> c.getPrecio_total())
					.reduce((t,u) ->{
						return Double.sum(t, u);
					}).orElse(0.0);
		}else {
			pagoConsumo = 0;
		}
		

		
		detalleDTO.setPago_consumo(pagoConsumo);
		detalleDTO.setPago_alojamiento(pago.getReserva().getCosto_alojamiento());
		detalleDTO.setSubtotal(pago.getSubtotal());
		detalleDTO.setTotal(pago.getTotal_pago());
		
		return detalleDTO;
	}
	
	/*private Pago mapToEntity(PagoDto dto, Pago pago) {
		Pago paga = modelMapper.map(dto,pago.getClass());
		return paga;
	
	}*/
	

	@Override
	@Transactional
	public PagoDto crearPago(PagoDto pagoDto) {
		
		
		Reserva reserva = reservaRepository.findById(pagoDto.getId_reserva())
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", pagoDto.getId_reserva()));
		
		
		Consumo consumo = consumoRepository.findByReserva(reserva).orElse(null);
		
		double pagoconsumo;
		if (consumo!=null) {
			pagoconsumo = consumo.getListaDetalle().stream()
					.map(c -> c.getPrecio_total())
					.reduce((t,u) ->{
						return Double.sum(t, u);
					}).orElse(0.0);
		}else {
			pagoconsumo = 0;
		}
		
		
		Pago pago = new Pago();
		
		double pago_alojamiento = reserva.getCosto_alojamiento();
		
		double subtotal = pagoconsumo + pago_alojamiento;
		
		final Double IVA = 0.12;
		
		double total = subtotal + (subtotal * IVA);
		
		double total_redondeado = Math.round(total*100.00)/100.0;
		
		pago.setReserva(reserva);
		pago.setSubtotal(subtotal);
		pago.setTotal_pago(total_redondeado);
		
		
		return mapToPagoDTO(pagoRepository.save(pago));
		
	
	}

	@Override
	@Transactional
	public List<PagoDetalleDTO> pagos() {
		List<PagoDetalleDTO> pagos = pagoRepository.findAll().stream()
				.map(pago-> mapToPagoDetalleDTO(pago)).collect(Collectors.toList());
		return pagos;
	}

	@Override
	public ResponseEntity<Resource> exportPDF(long id_reserva) {
		
		/*Reserva reserva = reservaRepository.findById(id_reserva)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id_reserva));*/
		
		Optional<Pago> optpago = pagoRepository.findByIdReserva(id_reserva);

		
		if (optpago.isPresent()) {
			
			Pago pago = optpago.get();
			
			Optional<Consumo> optconsumo = consumoRepository.findByIdReserva(id_reserva);
			
			double totalconsumo = detalleConsumoRepository.totalByReserva(id_reserva).orElse(0.0);
			
			
			
			
			try {
				
				final File file =  ResourceUtils.getFile("classpath:reports/Pago.jasper");
				final File imgLogo = ResourceUtils.getFile("classpath:images/hotel_icon.png");
				final JasperReport report = (JasperReport) JRLoader.loadObject(file);
				
				//JRBeanArrayDataSource dsconsumo = new JRBeanArrayDataSource(consumo.getListaDetalle().toArray());
				JRBeanArrayDataSource dsalojamiento = new JRBeanArrayDataSource(pago.getinfoReserva().toArray());
				
				
				
				final HashMap<String, Object> parameters = new HashMap<>();
				//parameters.put("p_idreserva",pago.getReserva().getId_reserva());
				parameters.put("p_logo", new FileInputStream(imgLogo));
				parameters.put("p_cliente", pago.getReserva().getUsuario().getNombre());
				
				/*Tables*/
				
				if (optconsumo.isPresent()) {
					Consumo consumo = optconsumo.get();
					JRBeanArrayDataSource dsconsumo = new JRBeanArrayDataSource(consumo.getListaDetalle().toArray());
					parameters.put("dsconsumo", dsconsumo);
				}
				//parameters.put("dsconsumo", dsconsumo);
				parameters.put("dsalojamiento",dsalojamiento);
				
				/*Summary*/
				parameters.put("p_totalconsumo", totalconsumo);
				parameters.put("p_alojamiento", pago.getReserva().getCosto_alojamiento());
				parameters.put("p_subtotal", pago.getSubtotal());
				parameters.put("p_total", pago.getTotal_pago());
				
				
				
				
				JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
				byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
				String sdf = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
				StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
				
				ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
						.filename(stringBuilder.append(pago.getReserva().getId_reserva())
								.append("generateDate:").append(sdf).append(".pdf").toString()).build();
				
				
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDisposition(contentDisposition);
				
				return ResponseEntity.ok().contentLength((long) reporte.length)
						.contentType(MediaType.APPLICATION_PDF)
						.headers(headers).body(new ByteArrayResource(reporte));
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		
		
		return null;
	}

}
