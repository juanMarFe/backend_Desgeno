package com.example.software.modelo;

public class Administrador extends Usuario {

	public Administrador(String login, String password) {
		super(login, password);

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
		return "Admin";
	}
	//hola 

}
