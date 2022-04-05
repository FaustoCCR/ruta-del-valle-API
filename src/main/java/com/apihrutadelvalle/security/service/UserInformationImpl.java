package com.apihrutadelvalle.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.security.dto.UserInformation;
import com.apihrutadelvalle.security.entity.Rol;
import com.apihrutadelvalle.security.entity.Usuario;
import com.apihrutadelvalle.security.enums.RolNombre;
import com.apihrutadelvalle.security.repository.RolRepository;
import com.apihrutadelvalle.security.repository.UsuarioRepository;

@Service
public class UserInformationImpl implements UserInformationService{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolRepository rolRepository;
	
	
	/*Convertir Entidad a DTO*/
	private UserInformation mapToDTOInformation(Usuario usuario) {
		
		UserInformation userinfo = new UserInformation();
		userinfo.setId_user(usuario.getId_usuario());
		userinfo.setDni(usuario.getDni());
		userinfo.setNombre(usuario.getNombre());
		userinfo.setEmail(usuario.getEmail());
		userinfo.setTelefono(usuario.getTelefono());
		userinfo.setUsername(usuario.getUsername());
		userinfo.setEstado(usuario.isEstado());
		userinfo.setRol(usuario.getRol().getNombre().name());
		
		return userinfo;
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserInformation> listarUsuarios() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return usuarios.stream().map(usuario -> mapToDTOInformation(usuario)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public UserInformation obtenerUsuarioId(long id_user) {
		
		Usuario usuario = usuarioRepository.findById(id_user)
				.orElseThrow(()-> new ResourceNotFoundException("Usuario", "", id_user));
		
		return mapToDTOInformation(usuario);
	}

	@Override
	@Transactional
	public UserInformation actualizarUsuario(long id_user, UserInformation userInformation) {
		
		/*Extraemos el usuario a modificar*/
		
		Usuario user =  usuarioRepository.findById(id_user)
				.orElseThrow(()-> new ResourceNotFoundException("Usuario", "", id_user));
		
		user.setDni(userInformation.getDni());
		user.setNombre(user.getNombre());
		user.setEmail(userInformation.getEmail());
		user.setTelefono(user.getTelefono());
		user.setUsername(userInformation.getUsername());
		user.setPassword(passwordEncoder.encode(userInformation.getPassword()));
		user.setEstado(userInformation.isEstado());
		
		Rol rol;
		if (userInformation.getRol().equals("admin")) {
			
			rol = rolRepository.findByNombre(RolNombre.ROLE_ADMIN).get();
		}else {
			rol = rolRepository.findByNombre(RolNombre.ROLE_USER).get();
		}
		
		user.setRol(rol);
		
		Usuario userActualizado = usuarioRepository.save(user);
		return mapToDTOInformation(userActualizado);

	}

	@Override
	@Transactional
	public void eliminarUsuario(long id_user) {
		
		/*Extraemos el usuario a eliminar*/
		
		Usuario user =  usuarioRepository.findById(id_user)
				.orElseThrow(()-> new ResourceNotFoundException("Usuario", "", id_user));
		
		usuarioRepository.delete(user);
	}

}
