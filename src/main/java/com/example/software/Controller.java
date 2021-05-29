package com.example.software;

import com.example.software.controlador.Facade;
import com.example.software.controlador.FolderProxy;
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
		String f = encode(temp);
		return f;
	}



	@GetMapping("/test/{key}")
	public Byte[] test(@PathVariable String key) {
		Byte[] bt= new Byte[2];
		bt[0]='a';
		bt[1]=0;
		return bt;
	}

	//////////////////////////Crud Trabajador///////////////////////////////////////////////////////

	@PostMapping("/crearTrabajador/{usuario}/{contrasena}/{nombre}/{documento}")
	public String createTrabajador(@PathVariable String usuario, @PathVariable String contrasena, @PathVariable String nombre, @PathVariable String documento) {
		return facade.C_Trabajador(usuario, contrasena, nombre, documento);
	}

	@GetMapping("/verTrabajador/{key}")
	public String verTrabajador(@PathVariable String key) {
		String f = decode(key);
		Trabajador temp = facade.BuscarTrabajadorKey(f);
		if (temp==null){
			return f;
		}else{
			return temp.getLogin()+","+temp.getPassword()+","+temp.getNombre()+","+temp.getDocumento();
		}
	}
	@PostMapping("/updateTrabajador/{viejoPointer}/{login}/{password}/{nombre}/{documento}/{key}")
	public String updateTrabajador(@PathVariable String viejoPointer, @PathVariable String login, @PathVariable String password, @PathVariable String nombre, @PathVariable String documento,@PathVariable String key) {
		return facade.U_Trabajador(viejoPointer,login,password,nombre,documento,key);
	}
	@PostMapping("/deleteTrabajador/{index}/{key}")
	public String updateTrabajador(@PathVariable String index,@PathVariable String key) {
		return facade.D_Trabajador(index,key);
	}

	/////////////////////////////Crud Empresa//////////////////////////////////////////




	/////////////////////////////Otros////////////////////////////////////////////////

	private String decode(String temp) {
		String f="";
		for (int i = 0; i< temp.length(); i++) {
			if (temp.charAt(i) == '_') {
				f += '/';
			} else {
				f += temp.charAt(i);
			}
		}
		return f;
	}
	private String encode(String temp) {
		String f="";
		for (int i = 0; i< temp.length(); i++){
			if (temp.charAt(i)=='/'){
				f+='_';
			}else{
				f+= temp.charAt(i);
			}
		}
		return f;
	}


}
