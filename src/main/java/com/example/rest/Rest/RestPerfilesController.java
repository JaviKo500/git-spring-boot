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

import com.example.rest.Models.Perfiles;
import com.example.rest.Service.PerfilesService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfiles")
public class RestPerfilesController {
	
	@Autowired
	PerfilesService perfilesService;
	
	@PostMapping(path = "/crear")
	public Perfiles crearPerfil(@Valid @RequestBody Perfiles perfil) {
		return perfilesService.crearPerfiles(perfil);
	}
	@GetMapping(path = "/listar")
    public List<Perfiles> listarPerfil() {
        return perfilesService.listarPerfiles();
    }
	
	@GetMapping(path = "buscar/{pfl_id}")
	public Perfiles buscarPorIdPerfiles(@PathVariable("pfl_id") int pfl_id){
		return perfilesService.buscarPerfilPorId(pfl_id);
	}
	
	@GetMapping(path = "buscarperfil/{pfl_nom}")
	public Perfiles buscarPorNombrePerfiles(@PathVariable("pfl_nom") String pfl_nom){
		return perfilesService.buscarPerfilPorNombre(pfl_nom);
	}
	
	@DeleteMapping(path = "/eliminar/{pfl_id}")
    public ResponseEntity<String> eliminarPorIdPerfil(@PathVariable("pfl_id") int pfl_id) {
		perfilesService.eliminarPerfil(pfl_id);
		return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
	
	@PostMapping(path = "/editar/{pfl_id}")
    public ResponseEntity<Perfiles> editarPorIdPerfil(@PathVariable int pfl_id, @RequestBody Perfiles perfiles) {
        Perfiles editar = perfilesService.buscarPerfilPorId(pfl_id);
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        editar.setPfl_nom(perfiles.getPfl_nom());
        editar.setPfl_des(perfiles.getPfl_des());
        editar.setPfl_estado(perfiles.getPfl_estado());
        return ResponseEntity.ok(perfilesService.crearPerfiles(editar));
    }

}
