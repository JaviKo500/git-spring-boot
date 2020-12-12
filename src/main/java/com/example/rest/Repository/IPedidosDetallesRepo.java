package com.example.rest.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.Models.PedidosDetalles;

@Repository

public interface IPedidosDetallesRepo extends JpaRepository<PedidosDetalles, Integer>{

	@Query(value = "SELECT * FROM pedidos_detalles  WHERE pdt_id=?1",nativeQuery = true)
	public PedidosDetalles BuscarPorIdPedidioDetalle(int pdt_id);
	
	@Query(value = "SELECT * FROM pedidos_detalles  WHERE pla_id_fk=?1 and pdt_est_cocinado='no cocinado' and pdt_estado='no facturado'",nativeQuery = true)
	public PedidosDetalles BuscarPorIdFkPedidiosDetalles(int pla_id_fk);
	
	@Query(value = "SELECT * FROM pedidos_detalles WHERE pdt_id=?1",nativeQuery = true)
	public PedidosDetalles buscarPedidoDetallesById(Integer pdt_id);
	
	//para scar todo los pedidos cuando no esten cocinados
	@Query(value="SELECT * FROM pedidos_detalles WHERE pdt_est_cocinado='no cocinado' AND pdt_estado='no facturado'", nativeQuery = true)
	public List<PedidosDetalles> findbyPedidoDetallesEstadoNoCocinado();
		
		
	//para scar los pedidos que no esten facturados
	@Query(value="SELECT * FROM pedidos_detalles WHERE pdt_est_cocinado='cocinado' AND pdt_estado='no facturado'", nativeQuery = true)
	public List<PedidosDetalles> findbyPedidoDetallesEstadoNoFacturado();
	
	
	//eliminar pedidos detalles
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM pedidos_detalles WHERE pdt_id=:pdt_id",nativeQuery = true)
	void EliminarPorIdPedidosDetalles(@Param("pdt_id") int  pdt_id);
	
	//eliminar pedidos detalles
		@Transactional
		@Modifying
		@Query(value = "DELETE FROM pedidos_detalles WHERE pdt_estado IS NULL",nativeQuery = true)
		void EliminarPorEstPedidosDetalles(@Param("pdt_estado") String pdt_estado);
		
		
		
		
}
