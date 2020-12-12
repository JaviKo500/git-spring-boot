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
import com.example.rest.Service.CategoriasService;

@CrossOrigin
@RestController
@RequestMapping(path = "/categorias")
public class RestCategoriasController {
	
	@Autowired
	 private CategoriasService categoriaService;
	
	@PostMapping(path = "/crear")
	public Categorias crearCategorias(@Valid @RequestBody Categorias categorias) {
		return categoriaService.crearCategorias(categorias);
	}
	@GetMapping(path = "/listar")
    public List<Categorias> listarCategorias() {
        return categoriaService.listarCategorias();
    }
	
	@GetMapping(path = "buscar/{cat_id}")
	public Categorias buscarPorIdCategorias(@PathVariable("cat_id") int cat_id){
		return categoriaService.buscarCategoriasPorId(cat_id);
	}
	@GetMapping(path = "/buscarcat/{cat_nom}")
	public Categorias bucarPorNombrePlato(@PathVariable("cat_nom") String cat_nom) {
		return categoriaService.buscarCategoriasPorNombre(cat_nom);
	}
	
	@DeleteMapping(path = "/eliminar/{cat_id}")
    public ResponseEntity<String> eliminarPorIdCategoria(@PathVariable("cat_id") int cat_id) {
		categoriaService.eliminarCategorias(cat_id);
		return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
	
	@PostMapping(path = "/editar/{cat_id}")
    public ResponseEntity<Categorias> editarPorIdCategorias(@PathVariable int cat_id, @RequestBody Categorias categorias) {
        Categorias editar=categoriaService.buscarCategoriasPorId(cat_id);
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        editar.setCat_nom(categorias.getCat_nom());
        editar.setCat_des(categorias.getCat_des());
        return ResponseEntity.ok(categoriaService.crearCategorias(editar));
    }

}
