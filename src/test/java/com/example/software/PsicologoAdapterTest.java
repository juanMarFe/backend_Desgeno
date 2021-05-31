package com.example.software;

import com.example.software.modelo.PsicologoAdapter;
import com.example.software.modelo.Usuario;
import org.junit.jupiter.api.*;

import com.example.software.modelo.Empresa;
import static org.junit.jupiter.api.Assertions.*;

//import modelo.PsicologoAdapter;
//import modelo.Usuario;

public class PsicologoAdapterTest {
	
	Usuario psicologo1 = new PsicologoAdapter("psicologo1", "123", "98", "1");
	
	@Test
	public void testLogin() {
		String login = psicologo1.getLogin();
		assertEquals(login, "psicologo1");
	}
	
	@Test
	public void testPassword() {
		String password = psicologo1.getPassword();
		assertEquals(password, "123");
	}
	
	@Test
	public void testWrongLogin() {
		boolean wrongLogin = psicologo1.checkLogin("sicologo1", "123");
		assertFalse(wrongLogin);
	}
	
	@Test
	public void testWrongPassword() {
		boolean wrongPassword = psicologo1.checkLogin("psicologo1", "1234");
		assertFalse(wrongPassword);
	}
	
	@Test
	public void testSuccess() {
		boolean success = psicologo1.checkLogin("psicologo1", "123");
		assertTrue(success);
	}

	@Test
	public void testType() {
		String type = psicologo1.getTipoUsuario();
		assertEquals(type, "Psicologo");
	}
	

}
