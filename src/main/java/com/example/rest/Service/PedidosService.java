package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Models.Pedidos;
import com.example.rest.Repository.IPedidosRepo;

@Service

public class PedidosService {
	
	@Autowired
	private IPedidosRepo pedidosRepo;
	
	//guardar Pedidos
	public Pedidos crearPedidos(Pedidos pedidos){
		return pedidosRepo.save(pedidos);
	}
		
	//listar pedidos 
	public List<Pedidos> listarPedidos(){
		return pedidosRepo.findAll();
	}
		
	//eliminar Pedidos
	public void eliminarPedidos(int ped_id) {
		pedidosRepo.EliminarPorIdPedidos(ped_id);
	}
	//buscar por id Pedidos
				
	public Pedidos buscarPedidosPorId(int ped_id) {
		return pedidosRepo.BuscarPorIdPedidios(ped_id);
	}	
	//buscar por id fk pesona Pedidos
	
	public Pedidos buscarPedidosPorIdFkPer(int per_id_fk) {
		return pedidosRepo.BuscarPorIdFkPedidios(per_id_fk);
	}
	public Pedidos buscarPedidosNoFacturados(int per_id_fk) {
		return pedidosRepo.BuscarPorIdFkPedidiosNoFactorados(per_id_fk);
	}
	
	//lista de pedidos no cocinados
	public List<Pedidos> listaPedidosNoCocinados(){
		return pedidosRepo.findbyPedidoEstadoNoCocinado();
	}
	//lista de pedidos cocinados
	public List<Pedidos> listaPedidosNoFacturados(){
		return pedidosRepo.findbyPedidoEstadoNoFacturado();
	}
	

}
