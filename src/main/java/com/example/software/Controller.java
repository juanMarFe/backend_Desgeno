package com.example.software;

import com.example.software.controlador.Facade;
import com.example.software.controlador.FolderProxy;
import com.example.software.modelo.Empresa;
import com.example.software.modelo.PsicologoAdapter;
import com.example.software.modelo.Trabajador;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class Controller {
	private Facade facade=Facade.crearInstaSingleton();
	private FolderProxy fp;


	//////////////Login////////////////////////////////////////

	@GetMapping("/login/{usuario}/{contrasena}")
	public String login(@PathVariable String usuario,@PathVariable String contrasena) {
			this.fp=new FolderProxy(usuario, contrasena);
		String temp = fp.performOperation();
		String f = temp.replaceAll("/","_");
		return f;
	}



	@GetMapping("/test/{key}")
	public byte[] test(@PathVariable String key) {
		byte[] bt= new byte[2];
		bt[0]='a';
		bt[1]='b';
		return bt;
	}

	//////////////////////////Crud Trabajador///////////////////////////////////////////////////////

	@GetMapping("/crearTrabajador/{usuario}/{contrasena}/{nombre}/{documento}")
	public String createTrabajador(@PathVariable String usuario, @PathVariable String contrasena, @PathVariable String nombre, @PathVariable String documento) {
		return facade.C_Trabajador(usuario, contrasena, nombre, documento);
	}

	@GetMapping("/verTrabajador/{key}")
	public String verTrabajador(@PathVariable String key) {
		String f = key.replaceAll("_","/");
		Trabajador temp = facade.BuscarTrabajadorKey(f);
		if (temp==null){
			return "No existe el trabajador";
		}else{
			return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDocumento();
		}
	}
	@GetMapping("/verTrabajadorLogin/login")
	public String verTrabajadorLogin(@PathVariable String login) {
		Trabajador temp = facade.BuscarTrabajadores(login);
		if (temp==null){
			return "No existe el trabajador";
		}else{
			return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDocumento();
		}
	}
	@GetMapping("/updateTrabajador/{viejoPointer}/{login}/{password}/{nombre}/{documento}/{key}")
	public String updateTrabajador(@PathVariable String viejoPointer, @PathVariable String login, @PathVariable String password, @PathVariable String nombre, @PathVariable String documento,@PathVariable String key) {
		String f = key.replaceAll("_","/");
		return facade.U_Trabajador(viejoPointer,login,password,nombre,documento,f);
	}

	@GetMapping("/deleteTrabajador/{index}/{key}")
	public String deleteTrabajador(@PathVariable String index,@PathVariable String key) {
		String f = key.replaceAll("_","/");
		return facade.D_Trabajador(index,f);
	}


	/////////////////////////////Crud Empresa//////////////////////////////////////////
	@GetMapping("/createEmpresa/{login}/{password}/{nit}/{nombre}/{direccion}/{key}")
	public String createEmpresa(@PathVariable String login, @PathVariable String password, @PathVariable String nit, @PathVariable String nombre, @PathVariable String direccion, @PathVariable String key){
		String f = key.replaceAll("_","/");
		return facade.C_Empresa(login,password,nit,nombre,direccion,f);
	}

	@GetMapping("/readEmpresa/{key}")
	public  String readEmpresa(@PathVariable String key){
		String f = key.replaceAll("_","/");
		Empresa temp=facade.R_Empresa(f);
		return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDireccion()+","+temp.getNIT();
	}
	@GetMapping("/readEmpresalogin/{login}")
	public  String readEmpresaLogin(@PathVariable String login){
		Empresa temp=facade.R_Empresa(login);
		return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDireccion()+","+temp.getNIT();
	}

	@GetMapping("/updateEmpresa/{viejoPointer}/{login}/{password}/{nit}/{nombre}/{direccion}/{key}")
	public String updateTrabajador(@PathVariable String viejoPointer, @PathVariable String login, @PathVariable String password,@PathVariable String nit, @PathVariable String nombre, @PathVariable String direccion,@PathVariable String key) {
		String f = key.replaceAll("_","/");
		return facade.U_Empresa(viejoPointer, login, password, nit, nombre, direccion, f);
	}

	@GetMapping("/deleteEmpresa/{index}/{key}")
	public String deleteEmpresa(@PathVariable String index, @PathVariable String key){
		String f = key.replaceAll("_","/");
		return facade.D_Empresa(index, f);
	}


	/////////////////////////////Crud Psicologo//////////////////////////////////////////
	@GetMapping("/createPsico/{login}/{password}/{nombre}/{documento}")
	public String createPsico(@PathVariable String login, @PathVariable String password, @PathVariable String nombre, @PathVariable String documento){
		return facade.C_Psicologo(login, password, nombre, documento);
	}


	@GetMapping("/readPsico/{key}")
	public String readPsico(@PathVariable String key) {
		String f = key.replaceAll("_","/");
		PsicologoAdapter temp= facade.R_Psicologo(f);
		return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDocumento();
	}

	@GetMapping("/readPsicoLogin/{key}")
	public String readPsicoLogin(@PathVariable String login) {
		PsicologoAdapter temp= facade.R_Psicologo(login);
		return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDocumento();
	}


}
