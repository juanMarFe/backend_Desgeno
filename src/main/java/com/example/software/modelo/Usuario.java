package com.example.software.modelo;

public abstract class Usuario {
	protected String login;
	protected String password;

	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}

	abstract public String getLogin();

	public abstract void setLogin(String login);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract boolean checkLogin(String loginTry, String passwordTry);

	public abstract String getTipoUsuario();

}
