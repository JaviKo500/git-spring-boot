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

import com.example.rest.Models.Categorias;
import com.example.rest.Models.Platos;
import com.example.rest.Service.CategoriasService;
import com.example.rest.Service.PlatosService;

@CrossOrigin
@RestController
@RequestMapping(path = "/platos")
public class RestPlatosController {
	
	@Autowired
	private PlatosService platosService;
	
	@Autowired
	private CategoriasService categoriasService;
	
	@PostMapping(path = "/crear")
	public Platos crearPlatos(@Valid @RequestBody Platos platos) {
		Categorias datos=categoriasService.buscarCategoriasPorNombre(platos.getCat_id_fk().getCat_nom());
		platos.setCat_id_fk(datos);
		return platosService.crearPlatos(platos);
	}
	
	
	@GetMapping(path = "/listar")
    public List<Platos> listarPlatos() {
        return platosService.listarPlatos();
    }
	
	@GetMapping(path = "buscar/{pla_id}")
	public Platos buscarPorIdPlatos(@PathVariable("pla_id") int pla_id){
		return platosService.buscarPlatosPorId(pla_id);
	}
	@GetMapping(path = "buscarplato/{pla_nom}")
	public Platos buscarPorNombrePlato(@PathVariable("pla_nom") String pla_nom) {
		return platosService.buscarPlatosPorNombre(pla_nom);
	}
	
	@DeleteMapping(path = "/eliminar/{pla_id}")
    public ResponseEntity<String> eliminarPorIdPlatos(@PathVariable("pla_id") int pla_id) {
		platosService.eliminarPlatos(pla_id);
		return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
	
	@PostMapping(path = "/editar/{pla_id}")
    public ResponseEntity<Platos> editarPorIdPlatos(@PathVariable int pla_id, @RequestBody Platos platos) {
		Platos  editar=platosService.buscarPlatosPorId(pla_id);
		Categorias datos=categoriasService.buscarCategoriasPorNombre(platos.getCat_id_fk().getCat_nom());
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        
        
        editar.setPla_nom(platos.getPla_nom());
        editar.setPla_precio(platos.getPla_precio());
        editar.setPla_des(platos.getPla_des());
        editar.setCat_id_fk(datos);
        
        
        return ResponseEntity.ok(platosService.crearPlatos(editar));
    }

}
