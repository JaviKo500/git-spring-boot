package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Models.Platos;
import com.example.rest.Repository.IPlatosRepo;

@Service

public class PlatosService {
	
	@Autowired
	private IPlatosRepo platosRepo;
	
	//guardar Platos
		public Platos crearPlatos(Platos platos){
			return platosRepo.save(platos);
		}
				
		//listar Platos 
		public List<Platos> listarPlatos(){
			return platosRepo.findAll();
		}
				
		//eliminar Platos
		public void eliminarPlatos(int pla_id) {
			platosRepo.EliminarPorIdPlatos(pla_id);
		}
		//buscar por id Platos
						
		public Platos buscarPlatosPorId(int pla_id) {
			return platosRepo.BuscarPorIdPlatos(pla_id);
		}

		//buscar por nombre platos
		
		public Platos buscarPlatosPorNombre(String pla_nom) {
			return platosRepo.BuscarPorNombrePlatos(pla_nom);
		}
		
}
