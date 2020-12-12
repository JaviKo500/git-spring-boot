package com.example.rest.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.Models.Perfiles;

@Repository

public interface IPerfilesRepo extends JpaRepository<Perfiles, Integer>{
	//BUSCAR POR ID
	@Query(value = "SELECT * FROM perfiles  WHERE pfl_id=?1",nativeQuery = true)
	public Perfiles BuscarPorIdPerfil(int pfl_id);
	
	//BUSCAR POR nombre
	@Query(value = "SELECT * FROM perfiles WHERE pfl_nom=?1",nativeQuery = true)
	public Perfiles BuscarPorNombrePerfil(String pfl_nom);
	
	//eliminar perfiles
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM perfiles WHERE pfl_id=:pfl_id",nativeQuery = true)
	void EliminarPorIdPerfil(@Param("pfl_id") int pfl_id);

}
