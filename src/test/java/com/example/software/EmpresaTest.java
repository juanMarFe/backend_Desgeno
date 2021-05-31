package com.example.software;

import org.junit.jupiter.api.*;

import com.example.software.modelo.Empresa;
import static org.junit.jupiter.api.Assertions.*;

//import modelo.Agrupacion;
//import modelo.Empresa;

public class EmpresaTest {

		Empresa empresa1 = new Empresa ("empresa1", "1234","22.33.22","Empresa 1","Cra 1");
		
		@Test
		public void testLogin() {
			String login = empresa1.getLogin();
			assertEquals(login, "empresa1");
		}
		
		@Test
		public void testPassword() {
			String password = empresa1.getPassword();
			assertEquals(password, "1234");
		}
		
		@Test
		public void testWrongLogin() {
			boolean wrongLogin = empresa1.checkLogin("empresa11", "123");
			assertFalse(wrongLogin);
		}
		
		@Test
		public void testWrongPassword() {
			boolean wrongPassword = empresa1.checkLogin("empresa1", "123");
			assertFalse(wrongPassword);
		}
		
		@Test
		public void testSuccess() {
			boolean success = empresa1.checkLogin("empresa1", "1234");
			assertTrue(success);
		}

		@Test
		public void testType() {
			String type = empresa1.getTipoUsuario();
			assertEquals(type, "Empresa");
		}
		
		@Test
		public void testNombre() {
			String name = empresa1.getNombre();
			assertEquals(name, "Empresa 1");
		}
		
		@Test
		public void testDireccion() {
			String address = empresa1.getDireccion();
			assertEquals(address, "Cra 1");
		}
		
		@Test
		public void testNIT() {
			String nit = empresa1.getNIT();
			assertEquals(nit, "22.33.22");
		}
		
		@Test
		public void testVerDatos() {
			String datos = "La empresa "+ empresa1.getNombre() + " de NIT "+empresa1.getNIT()+ " y direccion "+empresa1.getDireccion()+" tiene:";
			assertEquals(datos, "La empresa Empresa 1 de NIT 22.33.22 y direccion Cra 1 tiene:");
		}
		
		
		
}
