package com.example.rest.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.Models.Platos;

@Repository

public interface IPlatosRepo extends JpaRepository<Platos, Integer>{
	//buscar platos por id
	@Query(value = "SELECT * FROM platos  WHERE pla_id=?1",nativeQuery = true)
	public Platos BuscarPorIdPlatos(int pla_id);
	
	//buscar platos por nombre
	@Query(value = "SELECT * FROM platos WHERE pla_nom=?1",nativeQuery = true)
	public Platos BuscarPorNombrePlatos(String pla_nom);
	
	//eliminar platos
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM platos WHERE pla_id=:pla_id",nativeQuery = true)
	void EliminarPorIdPlatos(@Param("pla_id") int  pla_id);

}
