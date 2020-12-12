package com.example.rest.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.Models.Personas;

@Repository

public interface IPersonasRepo extends JpaRepository<Personas, Integer> {
	//buscar por id
	@Query(value = "SELECT * FROM personas  WHERE per_id=?1",nativeQuery = true)
	public Personas BuscarPorIdPersonas(int per_id);
	
	//buscar por cedula
	@Query(value = "SELECT * FROM personas WHERE per_ced=?1",nativeQuery = true)
	public Personas BuscarPorCedulaPersonas(String per_ced);
	
	//buscar por usuario
	@Query(value = "select * from personas WHERE per_usu=?1",nativeQuery = true)
	public  Personas BuscarPorUsuarioPersonas(String per_usu);
	
	
	
	////////////////////////////////////////////para verificar login
	@Query(value = "SELECT per_pass FROM Personas WHERE per_usu=?1 ")
	public String verificarPassword(String per_usu);
	
	@Query(value = "SELECT per_usu FROM Personas WHERE per_usu=?1")
	public String verificaUsuario(String per_usu);
	
	@Query(value = "SELECT per_ced FROM Personas WHERE per_ced=?1")
	public String verificarPorCedula(String per_ced);
	//////////////////////////////
	
	
	
	//eliminar personas
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM personas WHERE per_id=:per_id",nativeQuery = true)
	void EliminarPorIdPersonas(@Param("per_id") int  per_id);

}
