package com.example.rest.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.Models.Categorias;

@Repository

public interface ICategoriasRepo extends JpaRepository<Categorias, Integer>{
	//buscar por id categorias
	@Query(value = "SELECT * FROM categorias WHERE cat_id=?1",nativeQuery = true)
	public Categorias BuscarPorIdCategoria(int cat_id);
	
	//buscar por nombre categoria
	@Query(value = "SELECT * FROM categorias WHERE cat_nom=?1",nativeQuery = true)
	public Categorias BuscarPorNombreCategoria(String cat_nom);
	
	//eliminar categorias
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM categorias WHERE cat_id=:cat_id",nativeQuery = true)
	void EliminarPorIdCategoria(@Param("cat_id") int cat_di);
}
