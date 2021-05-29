package com.example.software.modelo;

public class Oferta implements Agrupacion {

	private String codigo;
	private String cargo;
	private String descripcion;

	public Oferta(String codigo, String cargo, String descripcion) {
		this.codigo = codigo;
		this.cargo = cargo;
		this.descripcion = descripcion;
	}

	@Override
	public String verDatos() {
            return "Oferta de codigo " + codigo + " Se busca " + cargo + ". Descripcion: " + descripcion + ".";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
