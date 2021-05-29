package com.example.software.modelo;

public class Trabajador extends Usuario {

        private String nombre;
        private String documento;
        
	public Trabajador(String login, String password, String nombre, String documento) {
		super(login, password);
                this.nombre = nombre;
                this.documento = documento;
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
	public boolean checkLogin(String loginTry, String passwordTry) {
		if (loginTry.equals(login) && passwordTry.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getTipoUsuario() {
		return "Trabajador";
	}
        
        public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
        
        public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento=documento;
	}
}
