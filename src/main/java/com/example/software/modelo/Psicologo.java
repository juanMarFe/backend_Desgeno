package com.example.software.modelo;

public class Psicologo {

	private String nombre;
	private String documento;

	public Psicologo(String nombre, String documento) {
		this.nombre = nombre;
		this.documento = documento;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public String getDoc() {
		return documento;
	}

	public void setDoc(String documento) {
		this.documento = documento;
	}

	public String getTipoUser() {
		return "Psicologo";
	}

}
