package com.example.software.modelo;

import java.util.HashMap;

public class UsuarioFactory {

	private HashMap<String, Usuario> list = new HashMap();

	public UsuarioFactory() {
	}

	public void saveUsuario(String index, Usuario user) {
		list.put(index, user);
	}

	public Usuario getUsuario(String login) {
            return list.get(login);
	}
	
	
	public boolean deleteUsuario(String index) {
		try {
                    list.remove(index);
                    return true;
		}catch(Exception e){
                    return false;
		}
	}
	
	public boolean updateUsuarioA(String pointer,String index, Usuario user) {
		try {
			list.remove(pointer);
			list.put(index, user);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean updateUsuario(String index, Usuario user) {
		try {
			list.replace(index, user);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public HashMap<String, Usuario> getList() {
		return list;
	}
        
        public String getAllTrabajadores() {
            String trabajadores = "";
            for(Usuario user:list.values()) {
                if(user.getTipoUsuario().equals("Trabajador")){
                    Trabajador trabajador = (Trabajador)user;
                    trabajadores += "Nombre: "+trabajador.getNombre() +". Documento: "+ trabajador.getDocumento()+"\n";
                }
            }
            return trabajadores;
	}

}
