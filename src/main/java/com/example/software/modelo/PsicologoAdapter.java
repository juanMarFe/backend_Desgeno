package com.example.software.modelo;

public class PsicologoAdapter extends Usuario {
	
	private Psicologo psicologo;
	
	public PsicologoAdapter(String login, String password, String nombre, String documento) {
		super(login, password);
		this.psicologo = new Psicologo(nombre, documento);
	}

	@Override
	public String getLogin() {
		return this.login;
	}

	@Override
	public void setLogin(String login) {
		this.login=login;	
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		this.password=password;
		
	}

	@Override
	public boolean checkLogin(String loginTry, String passwordTry) {
		if (loginTry.equals(this.login) && passwordTry.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getTipoUsuario() {
		return this.psicologo.getTipoUser();
	}
        
        public String getNombre() {
		return this.psicologo.getName();
	}
	
	public void setNombre(String nombre) {
		this.psicologo.setName(nombre);
	}
        
        public String getDocumento() {
		return this.psicologo.getDoc();
	}
	
	public void setDoc(String documento) {
		this.psicologo.setDoc(documento);
	}
        
        
}
