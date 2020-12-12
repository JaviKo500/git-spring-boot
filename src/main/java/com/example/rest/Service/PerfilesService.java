package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Models.Perfiles;
import com.example.rest.Repository.IPerfilesRepo;

@Service

public class PerfilesService {
	
	@Autowired
	private IPerfilesRepo perfilRepo;

	//guardar perfiles
	public Perfiles crearPerfiles(Perfiles perfiles){
		return perfilRepo.save(perfiles);
	}
	
	//listar perfiles
	public List<Perfiles> listarPerfiles(){
		return perfilRepo.findAll();
	}
	
	//eliminar Perfiles
	public void eliminarPerfil(int pfl_id) {
		perfilRepo.EliminarPorIdPerfil(pfl_id);
	}
	//buscar por id perfil
			
	public Perfiles buscarPerfilPorId(int pfl_id) {
		return perfilRepo.BuscarPorIdPerfil(pfl_id);
	}
	
	//buscar por nombre perfil
	
	public Perfiles buscarPerfilPorNombre(String pfl_nom) {
		return perfilRepo.BuscarPorNombrePerfil(pfl_nom);
	}
}
