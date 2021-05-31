package com.example.software;

import com.example.software.controlador.FolderProxy;
import com.example.software.modelo.Trabajador;
import com.example.software.modelo.Usuario;
import org.junit.jupiter.api.*;

import com.example.software.modelo.Empresa;
import static org.junit.jupiter.api.Assertions.*;
//import modelo.FolderProxy;
//import modelo.Trabajador;
//import modelo.Usuario;

public class FolderProxyTest {

	Usuario rightTrabajador = new Trabajador("arpit", "arpit", "1","123");
	Usuario wrongLoginTrabajador = new Trabajador("arpi", "arpit","1","123");
	Usuario wrongPasswordTrabajador = new Trabajador("arpit", "123","1","123");
	
	FolderProxy rightFolder = new FolderProxy(rightTrabajador.getLogin(),rightTrabajador.getPassword());
	FolderProxy wrongFolder1 = new FolderProxy(wrongLoginTrabajador.getLogin(), wrongLoginTrabajador.getPassword());
	FolderProxy wrongFolder2 = new FolderProxy(wrongPasswordTrabajador.getLogin(), wrongPasswordTrabajador.getPassword());

	@Test
	public void testSuccess() {
		String response = rightFolder.performOperation();
		assertEquals(response, null);
	}
	
	@Test
	public void testWrongLogin() {
		String response = wrongFolder1.performOperation();
		assertEquals(response, null);
	}
	
	@Test
	public void testWrongPassword() {
		String response = wrongFolder2.performOperation();
		assertEquals(response, null);
	}

}
