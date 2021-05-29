package com.example.software.modelo;

import java.util.ArrayList;

public class Empresa extends Usuario implements Agrupacion {
	private String nombre;
	private String direccion;
	private String NIT;
	private String padre;
	private ArrayList<Agrupacion> agrupaciones = new ArrayList<Agrupacion>();

	public Empresa(String login, String password, String NIT, String nombre, String direccion) {
		super(login, password);
		this.padre=null;
		this.direccion = direccion;
		this.nombre = nombre;
		this.NIT = NIT;
	}
	

	public String getPadre() {
		return padre;
	}


	public boolean setPadre(String padre) {
		this.padre = padre;
		return true;
	}


	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;

	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String verDatos() {
		String datos = "La empresa " + nombre + " de NIT " + NIT + " y direccion " + direccion + " tiene:";
		for (Agrupacion a : agrupaciones) {
			datos += "\n" + a.verDatos();
		}
		return datos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String NIT) {
		this.NIT = NIT;
	}

	public void addAgrupacion(Agrupacion a) {
		agrupaciones.add(a);
	}

	public ArrayList<Agrupacion> getAgrupaciones() {
		return agrupaciones;
	}

	public Oferta getOfertaIndividual(String codigo) {
		Oferta oferta = null;

		for (int i = 0; i < agrupaciones.size(); i++) {
			Agrupacion agrupacionTemp = agrupaciones.get(i);
			if (agrupacionTemp.getClass().equals(new Oferta("", "", "").getClass())) {
				Oferta ofertaTemp = (Oferta) agrupacionTemp;
				if (ofertaTemp.getCodigo().equals(codigo)) {
					oferta = ofertaTemp;
				}
			}
		}
		return oferta;
	}

	public void setAgrupaciones(ArrayList<Agrupacion> agrupaciones) {
		this.agrupaciones = agrupaciones;
	}

	public void deleteOferta(String codigo) {
		for (int i = 0; i < agrupaciones.size(); i++) {
			Agrupacion agrupacionTemp = agrupaciones.get(i);
			if (agrupacionTemp.getClass().equals(new Oferta("", "", "").getClass())) {
				Oferta ofertaTemp = (Oferta) agrupacionTemp;
				if (ofertaTemp.getCodigo().equals(codigo)) {
					this.agrupaciones.remove(i);
				}
			}
		}
	}

	@Override
	public boolean checkLogin(String loginTry, String passwordTry) {
		if (loginTry.equals(login) && passwordTry.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getTipoUsuario() {
		return "Empresa";
	}

}
