package com.apihrutadelvalle.security.service;

import java.util.List;

import com.apihrutadelvalle.security.dto.UserInformation;

public interface UserInformationService {
	
	public List<UserInformation> listarUsuarios();
	
	public UserInformation obtenerUsuarioId(long id_user);
	
	public UserInformation actualizarUsuario(long id_user,UserInformation usuario);
	
	public void eliminarUsuario(long id_user);
	
	

}
