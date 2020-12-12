package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Models.PedidosDetalles;
import com.example.rest.Repository.IPedidosDetallesRepo;

@Service

public class PedidosDetallesService {
	
	@Autowired
	private IPedidosDetallesRepo pedidosDetallesRepo;
	
	//guardar PedidosDetalles
	public PedidosDetalles crearPedidosDetalles(PedidosDetalles pedidosDetalles){
		return pedidosDetallesRepo.save(pedidosDetalles);
	}
	
	//listar pedidos detalles
	public List<PedidosDetalles> listarPedidosDetalles(){
		return pedidosDetallesRepo.findAll();
	}
	
	//eliminar PedidosDetalles
	public void eliminarPedidosDetalles(int pdt_id) {
	pedidosDetallesRepo.EliminarPorIdPedidosDetalles(pdt_id);
	}
	public void eliminarNulos(String pdt_estado) {
		pedidosDetallesRepo.EliminarPorEstPedidosDetalles(pdt_estado);;
	}
	//buscar por id PedidosDetalles
			
	public PedidosDetalles buscarPedidosDetallesPorId(int pdt_id) {
		return pedidosDetallesRepo.BuscarPorIdPedidioDetalle(pdt_id);
	}
	
	//buscar por id fk pesona Pedidos
	
	public PedidosDetalles buscarPedidosDetallesPorIdFkPlato(int pla_id_fk) {
		return pedidosDetallesRepo.BuscarPorIdFkPedidiosDetalles(pla_id_fk);
	}
	
	
	//lista de pedidos no cocinados
	public List<PedidosDetalles> listaPedidosDetallesNoCocinados(){
		return pedidosDetallesRepo.findbyPedidoDetallesEstadoNoCocinado();
	}
	//lista de pedidos cocinados
	public List<PedidosDetalles> listaPedidosDetallesNoFacturados(){
		return pedidosDetallesRepo.findbyPedidoDetallesEstadoNoFacturado();
	}
	
	
	
	

}
