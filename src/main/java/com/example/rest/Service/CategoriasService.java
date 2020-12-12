package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Models.Categorias;
import com.example.rest.Repository.ICategoriasRepo;



@Service

public class CategoriasService {
	@Autowired
	private ICategoriasRepo categoriasRepo;;

	//guardar categorias
	public Categorias crearCategorias(Categorias categorias){
		return categoriasRepo.save(categorias);
	}
	
	//listar categorias
	public List<Categorias> listarCategorias(){
		return categoriasRepo.findAll();
	}
	
	//eliminar categorias
	public void eliminarCategorias(int cat_id) {
		categoriasRepo.EliminarPorIdCategoria(cat_id);
	}
	//buscar por id
			
	public Categorias buscarCategoriasPorId(int cat_id) {
		return categoriasRepo.BuscarPorIdCategoria(cat_id);
	}
	
	//buscar por nombre
	
	public Categorias buscarCategoriasPorNombre(String cat_nom) {
		return categoriasRepo.BuscarPorNombreCategoria(cat_nom);
	}

}
