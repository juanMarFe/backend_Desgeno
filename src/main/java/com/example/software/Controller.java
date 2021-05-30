package com.example.software;

import com.example.software.controlador.Facade;
import com.example.software.controlador.FolderProxy;
import com.example.software.modelo.Empresa;
import com.example.software.modelo.Oferta;
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
		Trabajador temp = facade.R_Trabajador(f);
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

	@GetMapping("/readPsicoLogin/{login}")
	public String readPsicoLogin(@PathVariable String login) {
		PsicologoAdapter temp= facade.BuscarPsicologos(login);
		return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDocumento();
	}

	@GetMapping("/updatePsico/{viejoPointer}/{login}/{password}/{nombre}/{documento}/{key}")
	public String updatePsico(@PathVariable String viejoPointer,@PathVariable String login, @PathVariable String password,@PathVariable String nombre,@PathVariable String documento, @PathVariable String key){
		return facade.U_Psicologo(viejoPointer, login, password, nombre, documento, key);
	}
	@GetMapping("/deletePsico/{index}/{key}")
	public String deletePsico(@PathVariable String index, @PathVariable String key){
		return facade.D_Psicologo(index, key);
	}
	////////////////////////////////////////Crud Agrupaciones/////////////////////////////

	@GetMapping("/createAgrupacionEmpresa/{pointer}/{pointer2}")
	public String createAgrupacionEmpresa(@PathVariable String pointer, @PathVariable String pointer2){
		try {
			facade.C_AgrupacionEmpresa(pointer, pointer2);
			return "Se creó la agrupación correctamente";
		}catch (Exception e){
			return "Hubo un error en la transacción";
		}
	}

	@GetMapping("/readUnicaOferta/{codigo}/{pointer}")
	public String readUnicaOferta(@PathVariable String codigo, @PathVariable String pointer){
		String temp = facade.R_UnicaOferta(codigo, pointer);
		if (temp==null){
			return "null";
		}
		return temp;
	}

	@GetMapping("/deleteOferta/{codigo}/{pointer}")
	public String deleteOferta(@PathVariable String codigo, @PathVariable String pointer){
		try {
			facade.D_Oferta(codigo,pointer);
			return "Se borró la agrupación correctamente";
		}catch (Exception e){
			return "Hubo un error en la transacción";
		}
	}
}
