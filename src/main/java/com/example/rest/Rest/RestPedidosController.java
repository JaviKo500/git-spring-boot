package com.example.rest.Rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.Models.Pedidos;
import com.example.rest.Models.Personas;
import com.example.rest.Service.PedidosService;
import com.example.rest.Service.PersonasService;

@CrossOrigin
@RestController
@RequestMapping(path = "/pedidos")

public class RestPedidosController {

	@Autowired 
	private PedidosService pedidosService;
	@Autowired
	private PersonasService personasService;
	
	@PostMapping(path = "/crear")
	public Pedidos crearPedidos(@Valid @RequestBody Pedidos pedidos) {
		Personas datos= personasService.buscarPersonasPorUsuario(pedidos.getPer_id_fk().getPer_usu());
		pedidos.setPer_id_fk(datos);
		return pedidosService.crearPedidos(pedidos);
	}
	
	
	@GetMapping(path = "/listar")
    public List<Pedidos> listarPedidos() {
        return pedidosService.listarPedidos();
    }
	
	@GetMapping(path = "/buscar/{ped_id}")
	public Pedidos buscarPorIdPedidos(@PathVariable("ped_id") int ped_id){
		return pedidosService.buscarPedidosPorId(ped_id);
	}
	@GetMapping(path = "/buscarfk/{per_id_fk}")
	public Pedidos buscarPorIdFkPedidos(@PathVariable("per_id_fk") int per_id_fk){
		return pedidosService.buscarPedidosPorIdFkPer(per_id_fk);
	}
	
	//para listar los pedidos no cocinados
	@GetMapping(path = "/listanococinados")
	public List<Pedidos> listarPedidosNoCocinados(){
		return pedidosService.listaPedidosNoCocinados();
	}
	
	//para listar los pedidos facturados
	@GetMapping(path = "/listanofacturado")
	public List<Pedidos> listarPedidosNoFacturados(){
		return pedidosService.listaPedidosNoFacturados();
	}
	@DeleteMapping(path = "/eliminar/{ped_id}")
    public ResponseEntity<String> eliminarPorIdPedidos(@PathVariable("ped_id") int ped_id) {
		pedidosService.eliminarPedidos(ped_id);
		return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
	
	@PostMapping(path = "/editar/{ped_id}")
    public ResponseEntity<Pedidos> editarPorIdPedidos(@PathVariable int ped_id, @RequestBody Pedidos pedidos) {
        Pedidos  editar=pedidosService.buscarPedidosPorId(ped_id);
        Personas datosPersona= personasService.bucarPersonasPorCedula(pedidos.getPer_id_fk().getPer_ced());
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
       
        editar.setPed_costo_final(pedidos.getPed_costo_final());
        editar.setPed_fecha(pedidos.getPed_fecha());
        editar.setPed_estado(pedidos.getPed_estado());
        editar.setPer_id_fk(datosPersona);
        return ResponseEntity.ok(pedidosService.crearPedidos(editar));
    }
	
	@PostMapping(path = "/editestcos/{per_id_fk}") 
	public ResponseEntity<Pedidos> editarPorIdPersona(@PathVariable int per_id_fk,@RequestBody Pedidos pedidos){
		Pedidos  editarEstado=pedidosService.buscarPedidosPorIdFkPer(per_id_fk);
        //Personas datosPersona= personasService.buscarPersonasPorUsuario(pedidos.getPer_id_fk().getPer_usu());
        if (editarEstado == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        editarEstado.setPed_est_cocinado(pedidos.getPed_est_cocinado());
        //editarEstado.setPer_id_fk(datosPersona);
        return ResponseEntity.ok(pedidosService.crearPedidos(editarEstado));
        
	}
	
	@PostMapping(path = "/editestfac/{per_id_fk}") 
	public ResponseEntity<Pedidos> editarPorIdPersonaEstado(@PathVariable int per_id_fk,@RequestBody Pedidos pedidos){
		Pedidos  editarEstado=pedidosService.buscarPedidosNoFacturados(per_id_fk);
        //Personas datosPersona= personasService.buscarPersonasPorUsuario(pedidos.getPer_id_fk().getPer_usu());
        if (editarEstado == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        editarEstado.setPed_estado(pedidos.getPed_estado());
        //editarEstado.setPer_id_fk(datosPersona);
        return ResponseEntity.ok(pedidosService.crearPedidos(editarEstado)); 
	}
	
	
	
}
