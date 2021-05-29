package com.example.software.modelo;

public class SueldoMensual extends OfertaDecorator {
	private float sueldo;

	public SueldoMensual(Agrupacion specialOferta, float sueldo) {
		super(specialOferta);
		this.sueldo = sueldo;
	}

	public String verDatos() {
		return specialOferta.verDatos() + addSueldo();
	}

	private String addSueldo() {
		return " Sueldo mensual: " + this.sueldo;
	}

}
