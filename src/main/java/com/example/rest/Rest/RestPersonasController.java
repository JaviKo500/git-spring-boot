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
import com.example.rest.Models.Personas;
import com.example.rest.Service.EnviarEmailService;
import com.example.rest.Service.PerfilesService;
import com.example.rest.Service.PersonasService;

@CrossOrigin
@RestController
@RequestMapping(path = "/personas")

public class RestPersonasController {
	
	@Autowired
	private PersonasService personasService;
	@Autowired
	private PerfilesService perfilesService;
	@Autowired 
	private EnviarEmailService enviarMailService;
	
	@PostMapping(path = "/crear")
	public Personas crearPersonas(@Valid @RequestBody Personas personas) {
		Perfiles datos=perfilesService.buscarPerfilPorNombre(personas.getPfl_id_fk().getPfl_nom());
		personas.setPfl_id_fk(datos);
		return personasService.crearPersonas(personas);
	}
	@GetMapping(path = "/listar")
    public List<Personas> listarPersonas() {
        return personasService.listarPersonas();
    }
	
	@GetMapping(path = "buscarid/{per_id}")
	public Personas buscarPorIdPersonas(@PathVariable("per_id") int per_id){
		return personasService.buscarPersonasPorId(per_id);
	}
	
	@GetMapping(path = "buscarusuario/{per_usu}")
	public Personas buscarPorUsuarioPersonas(@PathVariable("per_usu") String per_usu){
		return personasService.buscarPersonasPorUsuario(per_usu);
	}
	
	@GetMapping(path = "buscarcedula/{per_ced}")
	public Personas buscarPorCedulaPersonas(@PathVariable("per_ced") String per_ced){
		return personasService.bucarPersonasPorCedula(per_ced);
	}
	
	
	///////////////////////verificar login
	@GetMapping(path = "verificarcedula/{per_ced}")
	public String verificarPorCedula(@PathVariable("per_ced") String per_ced){
		return personasService.verifivarPorCedula(per_ced);
	}
	@GetMapping(path = "verificarusu/{per_usu}")
	public String verificarUsuario(@PathVariable("per_usu") String per_usu){
		return personasService.verificarUsuario(per_usu);
		
	}
	@GetMapping(path = "verificarpass/{per_usu}")
	public String verificarContrasena(@PathVariable("per_usu") String per_usu){
		return personasService.verifivarContrasena(per_usu);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@DeleteMapping(path = "/eliminar/{per_id}")
    public ResponseEntity<String> eliminarPorIdPersonas(@PathVariable("per_id") int per_id) {
		personasService.eliminarPersonas(per_id);
		return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
	
	@PostMapping(path = "/editar/{per_id}")
    public ResponseEntity<Personas> editarPorIdPersonas(@PathVariable int per_id, @RequestBody Personas personas) {
		Personas  editar=personasService.buscarPersonasPorId(per_id);
		Perfiles datos=perfilesService.buscarPerfilPorNombre(personas.getPfl_id_fk().getPfl_nom());
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
       
        editar.setPer_nom(personas.getPer_nom());
        editar.setPer_ced(personas.getPer_ced());
        editar.setPer_mail(personas.getPer_mail());
        editar.setPer_usu(personas.getPer_usu());
        editar.setPer_pass(personas.getPer_pass());
        editar.setPer_estado(personas.getPer_estado());
        editar.setPer_dir(personas.getPer_dir());
        editar.setPfl_id_fk(datos);
        
        
        return ResponseEntity.ok(personasService.crearPersonas(editar));
    }
	
	//metodo para recuperar cuenta por email
	@PostMapping(path = "/recuperarcuenta/{per_id}")
    public ResponseEntity<Personas> recuperarCuenta(@PathVariable int per_id, @RequestBody Personas personas) {
		Personas  editar=personasService.buscarPersonasPorId(per_id);
		Perfiles datos=perfilesService.buscarPerfilPorNombre(personas.getPfl_id_fk().getPfl_nom());
        if (editar == null) {
            System.out.println("No se encontro el registro");
            ResponseEntity.badRequest().build();
        }
        String nueva_pass=enviarMailService.GenerarPalabra();
        String mensaje="Su nueva contraseña es: "+nueva_pass+"\n"+"\nEsta es una contraseña temporal, cambie su contraseña por mas seguridad";
        enviarMailService.enviarEmail("jjavikog@gmail.com", personas.getPer_mail(),"Recuperar su cuenta", mensaje);
        editar.setPer_nom(personas.getPer_nom());
        editar.setPer_ced(personas.getPer_ced());
        editar.setPer_mail(personas.getPer_mail());
        editar.setPer_usu(personas.getPer_usu());
        editar.setPer_pass(nueva_pass);
        editar.setPer_estado(personas.getPer_estado());
        editar.setPer_dir(personas.getPer_dir());
        editar.setPfl_id_fk(datos);
        
        
        return ResponseEntity.ok(personasService.crearPersonas(editar));
    }
	
	//metodo para editar cuenta por usuario
		@PostMapping(path = "/editarusuario/{per_usu}")
		public ResponseEntity<Personas> editarUsuario(@PathVariable String per_usu, @RequestBody Personas personas) {
			Personas  editar=personasService.buscarPersonasPorUsuario(per_usu);
			Perfiles datos=perfilesService.buscarPerfilPorNombre(personas.getPfl_id_fk().getPfl_nom());
	        if (editar == null) {
	            System.out.println("No se encontro el registro");
	            ResponseEntity.badRequest().build();
	        }
	        
	        editar.setPer_nom(personas.getPer_nom());
	        editar.setPer_ced(personas.getPer_ced());
	        editar.setPer_mail(personas.getPer_mail());
	        editar.setPer_usu(personas.getPer_usu());
	        editar.setPer_pass(personas.getPer_pass());
	        editar.setPer_estado(personas.getPer_estado());
	        editar.setPer_dir(personas.getPer_dir());
	        editar.setPfl_id_fk(datos);
	        
	        
	        return ResponseEntity.ok(personasService.crearPersonas(editar));
	    }

}
