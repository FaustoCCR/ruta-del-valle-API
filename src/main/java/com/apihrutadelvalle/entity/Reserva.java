package com.apihrutadelvalle.entity;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.*;

import com.apihrutadelvalle.security.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reserva",uniqueConstraints = {@UniqueConstraint(columnNames = {"id_reserva","id_usuario"})})

public class Reserva {

	/*se generara automaticamente el id*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_reserva;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario",nullable = false)
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.LAZY)/*relacion uno a uno*/
	@JoinColumn(name="id_habitacion",nullable = false)
	private Habitacion habitacion;
	
	@Column(name="fecha_ingreso",nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_ingreso;

	@Column(name="fecha_salida",nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_salida;
	
	@Column(name="adultos",nullable = false)
	private int adultos;
	
	@Column(name="ninos",nullable = false)
	private int ninos;
	
	@Column(name="observaciones")
	private String observaciones;
	
	@Column(name="costo_alojamiento",nullable = false)
	private double costo_alojamiento;
	
	@Column(name="esatado",nullable = false)
	private String estado;

	//cuando el cliente desea ir
	@Column(name="fecha_reserva")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_reserva;
	
	@PrePersist 
	public void prePersist() {
		//para adicionar la fecha de creacion
		fecha_reserva=new Date();
	}
	
	/*GETTERS Y SETTERS*/
	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public int getAdultos() {
		return adultos;
	}

	public void setAdultos(int adultos) {
		this.adultos = adultos;
	}

	public int getNinos() {
		return ninos;
	}

	public void setNinos(int ninos) {
		this.ninos = ninos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getCosto_alojamiento() {
		return costo_alojamiento;
	}

	public void setCosto_alojamiento(double costo_alojamiento) {
		this.costo_alojamiento = costo_alojamiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	/*JASPER REPORT*/
	
	public int getNum_habitacion() {
		
		return habitacion.getNum_habitacion();
	}
	
	public String getTipo_habitacion() {
		return habitacion.getTipo_Habitacion().getNombre();
	}
	
	public String getPlanta() {
		return habitacion.getPlanta().getNombre();
	}
	
	public double getCosto_noche(){
		
		return habitacion.getCosto_noche();
	}
	
	public long getEstancia() {
		
		long diff = fecha_salida.getTime() - fecha_ingreso.getTime();
		
		TimeUnit time = TimeUnit.DAYS;
		
		long difference = time.convert(diff,TimeUnit.MILLISECONDS);
		
		
		return difference;
	}
	
	
	

}
