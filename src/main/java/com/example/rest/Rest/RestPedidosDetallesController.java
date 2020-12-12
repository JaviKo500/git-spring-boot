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

import com.example.rest.Models.PedidosDetalles;
import com.example.rest.Models.Personas;
import com.example.rest.Models.Platos;
import com.example.rest.Repository.IPedidosDetallesRepo;
import com.example.rest.Service.PedidosDetallesService;
import com.example.rest.Service.PersonasService;
import com.example.rest.Service.PlatosService;

@CrossOrigin
@RestController
@RequestMapping(path = "/pedidosdetalles")

public class RestPedidosDetallesController {
	
	@Autowired
	private PedidosDetallesService pedidosDetallesService;
	@Autowired
	private PersonasService personasService;
	@Autowired
	private PlatosService platosService;
	@Autowired
	private IPedidosDetallesRepo pedidosDetallesRepo;
	
	@PostMapping(path = "/crear")
	public PedidosDetalles crearPedidosDetalles(@Valid @RequestBody PedidosDetalles pedidosDetalles) {
		Personas datosPersonas=personasService.buscarPersonasPorUsuario(pedidosDetalles.getPer_id_fk().getPer_usu());
		Platos datosPlatos=platosService.buscarPlatosPorNombre(pedidosDetalles.getPla_id_fk().getPla_nom());
		pedidosDetalles.setPer_id_fk(datosPersonas);
		pedidosDetalles.setPla_id_fk(datosPlatos);
		return pedidosDetallesService.crearPedidosDetalles(pedidosDetalles);
	}
	@GetMapping(path = "/listar")
    public List<PedidosDetalles> listarPedidosDetalles() {
		pedidosDetallesService.eliminarNulos("null");
        return pedidosDetallesService.listarPedidosDetalles();
    }
	
	//para listar los pedidosdetalles no cocinados
	@GetMapping(path = "/listanococinados")
	public List<PedidosDetalles> listarPedidosNoCocinados(){
		return pedidosDetallesService.listaPedidosDetallesNoCocinados();
	}
		
	//para listar los pedidos facturados
	@GetMapping(path = "/listanofacturado")
	public List<PedidosDetalles> listarPedidosNoFacturados(){
		
		return pedidosDetallesService.listaPedidosDetallesNoFacturados();
	}
	
	@GetMapping(path = "buscar/{pdt_id}")
	public PedidosDetalles buscarPorIdPedidosDetalles(@PathVariable("pdt_id") int pdt_id){
		return pedidosDetallesService.buscarPedidosDetallesPorId(pdt_id);
	}
	@GetMapping(path = "/buscarfk/{pla_id_fk}")
	public PedidosDetalles buscarPorIdFkPedidosDetalles(@PathVariable("pla_id_fk") int pla_id_fk){
		return pedidosDetallesService.buscarPedidosDetallesPorIdFkPlato(pla_id_fk);
	}
	
	@DeleteMapping(path = "/eliminar/{pdt_id}")
    public ResponseEntity<String> eliminarPorIdPedidosDetalles(@PathVariable("pdt_id") int pdt_id) {
		pedidosDetallesService.eliminarPedidosDetalles(pdt_id);
		return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
	
	@PostMapping(path = "/editar/{pdt_id}")
    public ResponseEntity<PedidosDetalles> editarPorIdPedidosDetalles(@PathVariable int pdt_id, @RequestBody PedidosDetalles pedidosDetalles) {
        PedidosDetalles  editar=pedidosDetallesService.buscarPedidosDetallesPorId(pdt_id);
        Personas datosPersonas=personasService.bucarPersonasPorCedula(pedidosDetalles.getPer_id_fk().getPer_ced());
		Platos datosPlatos=platosService.buscarPlatosPorNombre(pedidosDetalles.getPla_id_fk().getPla_nom());
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
       
        editar.setPdt_cantidad(pedidosDetalles.getPdt_cantidad());
        editar.setPdt_total(pedidosDetalles.getPdt_total());
        editar.setPdt_estado(pedidosDetalles.getPdt_estado());
        editar.setPer_id_fk(datosPersonas);
        editar.setPla_id_fk(datosPlatos);
        return ResponseEntity.ok(pedidosDetallesService.crearPedidosDetalles(editar));
    }
	
	@PostMapping(path = "/pededitestcos/{pdt_id}") 
	public ResponseEntity<PedidosDetalles> editarPorIdPersona(@PathVariable int pdt_id,@RequestBody PedidosDetalles pedidosDetalles){
		//listarPedidosDetalles();
		PedidosDetalles  editarEstado1=pedidosDetallesService.buscarPedidosDetallesPorId(pdt_id);
	    //Personas datosPersona= personasService.buscarPersonasPorUsuario(pedidosDetalles.getPer_id_fk().getPer_usu());
        //Platos datosPlatos=platosService.buscarPlatosPorNombre(pedidosDetalles.getPla_id_fk().getPla_nom());
        if (editarEstado1 == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        editarEstado1.setPdt_est_cocinado(pedidosDetalles.getPdt_est_cocinado());
        //editarEstado1.setPer_id_fk(datosPersona);
        //editarEstado1.setPla_id_fk(datosPlatos);
        return ResponseEntity.ok(pedidosDetallesRepo.save(editarEstado1));
	}
	
	@PostMapping(path = "/pededitestfac/{pdt_id}") 
	public ResponseEntity<PedidosDetalles> editarPorIdPersonaEstado(@PathVariable int pdt_id,@RequestBody PedidosDetalles pedidosDetalles){
		PedidosDetalles  editarEstado=pedidosDetallesService.buscarPedidosDetallesPorId(pdt_id);
        //Personas datosPersona= personasService.buscarPersonasPorUsuario(pedidosDetalles.getPer_id_fk().getPer_usu());
        //Platos datosPlatos=platosService.buscarPlatosPorNombre(pedidosDetalles.getPla_id_fk().getPla_nom());
        if (editarEstado == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        editarEstado.setPdt_estado(pedidosDetalles.getPdt_estado());;
        //editarEstado.setPer_id_fk(datosPersona);
        //editarEstado.setPla_id_fk(datosPlatos);
        return ResponseEntity.ok(pedidosDetallesRepo.save(editarEstado)); 
	}

}
