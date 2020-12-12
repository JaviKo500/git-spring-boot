package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Models.Personas;
import com.example.rest.Repository.IPersonasRepo;

@Service

public class PersonasService {
	
	@Autowired
	private IPersonasRepo personasRepo;
	
	//guardar Personas
	public Personas crearPersonas(Personas personas){
		return personasRepo.save(personas);
	}
			
	//listar Personas 
	public List<Personas> listarPersonas(){
		return personasRepo.findAll();
	}
			
	//eliminar Personas
	public void eliminarPersonas(int per_id) {
		personasRepo.EliminarPorIdPersonas(per_id);
	}
	//buscar por id Personas
					
	public Personas buscarPersonasPorId(int per_id) {
		return personasRepo.BuscarPorIdPersonas(per_id);
	}	

	//buscar por cedula personas
	
	public Personas bucarPersonasPorCedula(String per_ced) {
		return personasRepo.BuscarPorCedulaPersonas(per_ced);
	}
	
	//buscar por usuario
	
	public Personas buscarPersonasPorUsuario(String per_usu) {
		return personasRepo.BuscarPorUsuarioPersonas(per_usu);
	}
	//verificar por cedula login
	public String verifivarPorCedula(String per_ced) {
		return personasRepo.verificarPorCedula(per_ced);
	}
	//verificar por password
	public String verifivarContrasena(String per_usu) {
		return personasRepo.verificarPassword(per_usu);
	}
	//verificar por usuario login
	public String verificarUsuario(String per_usu) {
		return personasRepo.verificaUsuario(per_usu);
	}
	
}
