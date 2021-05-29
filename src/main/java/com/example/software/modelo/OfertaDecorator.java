package com.example.software.modelo;

abstract class OfertaDecorator implements Agrupacion {
		protected Agrupacion specialOferta;
		
		public OfertaDecorator(Agrupacion specialDecorator) {
			this.specialOferta=specialDecorator;
		}
		
		public String verDatos() {
			return specialOferta.verDatos();
		}
}
