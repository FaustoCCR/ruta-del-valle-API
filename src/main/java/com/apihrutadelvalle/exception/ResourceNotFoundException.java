package com.apihrutadelvalle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//lo que responderá en el controlador
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreDelRecurso;
	private String nombreDelCampo;
	private Object valorDelCampo;
	
	public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, Object valorDelCampo) {
		super(String.format("%s no encontrada con : %s : '%s'",nombreDelRecurso,nombreDelCampo,valorDelCampo));
		//%S indica que rebibe un parámetro
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.valorDelCampo = valorDelCampo;
	}

	public String getNombreDelRecurso() {
		return nombreDelRecurso;
	}

	public void setNombreDelRecurso(String nombreDelRecurso) {
		this.nombreDelRecurso = nombreDelRecurso;
	}

	public String getNombreDelCampo() {
		return nombreDelCampo;
	}

	public void setNombreDelCampo(String nombreDelCampo) {
		this.nombreDelCampo = nombreDelCampo;
	}

	public Object getValorDelCampo() {
		return valorDelCampo;
	}

	public void setValorDelCampo(Object valorDelCampo) {
		this.valorDelCampo = valorDelCampo;
	}

	

}
