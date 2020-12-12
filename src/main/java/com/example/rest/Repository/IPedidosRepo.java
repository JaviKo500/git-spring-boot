package com.example.rest.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.Models.Pedidos;

@Repository

public interface IPedidosRepo extends JpaRepository<Pedidos, Integer>{
	
	@Query(value = "SELECT * FROM pedidos  WHERE ped_id=?1",nativeQuery = true)
	public Pedidos BuscarPorIdPedidios(int ped_id);
	
	@Query(value = "SELECT * FROM pedidos  WHERE per_id_fk=?1 and ped_est_cocinado='no cocinado' and ped_estado='no facturado'",nativeQuery = true)
	public Pedidos BuscarPorIdFkPedidios(int per_id_fk);
	
	@Query(value = "SELECT * FROM pedidos  WHERE per_id_fk=?1 and ped_est_cocinado='cocinado' and ped_estado='no facturado'",nativeQuery = true)
	public Pedidos BuscarPorIdFkPedidiosNoFactorados(int per_id_fk);
	
	//para scar todo los pedidos cuando no esten cocinados
	@Query(value="SELECT * FROM pedidos WHERE ped_est_cocinado='no cocinado' AND ped_estado='no facturado'", nativeQuery = true)
	public List<Pedidos> findbyPedidoEstadoNoCocinado();
	
	
	//para scar los pedidos que no esten facturados
	@Query(value="SELECT * FROM pedidos WHERE ped_est_cocinado='cocinado' AND ped_estado='no facturado'", nativeQuery = true)
	public List<Pedidos> findbyPedidoEstadoNoFacturado();
	//eliminar pedidos 
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM pedidos WHERE ped_id=:ped_id",nativeQuery = true)
	void EliminarPorIdPedidos(@Param("ped_id") int  ped_id);
	
	

}
