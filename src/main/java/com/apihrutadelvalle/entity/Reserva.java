package com.apihrutadelvalle.entity;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "reserva",uniqueConstraints = {@UniqueConstraint(columnNames = {"id_reserva","id_usuario"})})

public class Reserva {

	/*se generara automaticamente el id*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_reserva;
	
	@JoinColumn(name="id_usuario")
	private long id_usuario;
	
	@JoinColumn(name="id_habitacion")
	private long id_habitacion;
	
	@Column(name="fecha_ingreso",nullable = false)
	private Date fecha_ingreso;

	@Column(name="fecha_salida",nullable = false)
	private Date fecha_salida;
	
	@Column(name="adultos",nullable = false)
	private int adultos;
	
	@Column(name="ninos",nullable = false)
	private int ninos;
	
	@Column(name="observaciones",nullable = false)
	private String observaciones;
	
	@Column(name="costo_alojamiento",nullable = false)
	private double costo_alojamiento;
	
	@Column(name="esatado",nullable = false)
	private String estado;

	//cuando el cliente desea ir
	@Column(name="fecha_reserva")
	@Temporal(TemporalType.DATE)
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

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public long getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(long habitacion) {
		this.id_habitacion = habitacion;
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
	
	
	

}
