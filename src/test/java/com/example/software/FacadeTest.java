package com.example.software;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.software.controlador.Facade;
import com.example.software.controlador.FolderProxy;
import com.example.software.modelo.*;

class FacadeTest {
	FolderProxy admin;
	Facade fac;

	public FacadeTest() {
		this.admin = new FolderProxy("admin", "admin123");
		this.fac = Facade.crearInstaSingleton();
		fac.C_Empresa("Empresa1", "123", "123", "Empresa1", "direccion", this.admin.performOperation());
		fac.C_Empresa("Empresa2", "123", "1234", "Empresa2", "direccion2", this.admin.performOperation());
		fac.C_Trabajador("Trabajador1", "123", "Trabajador1", "123456");
		fac.C_Psicologo("Psicologo1", "123", "Psicologo123", "123456");
	}

	@Test
	void testC_Empresa() {
		FolderProxy usuario = new FolderProxy("Empresa1", "123");
		boolean esta = false;
		if (fac.R_Empresa(usuario.performOperation()) != null) {
			esta = true;
		}
		assertTrue(esta);
	}

	@Test
	void testR_Empresa() {
		FolderProxy usuario = new FolderProxy("Empresa1", "123");
		Empresa temp = new Empresa("Empresa1", "123", "123", "Empresa1", "direccion");
		boolean igual = false;
		if ((temp.getLogin().equals(fac.R_Empresa(usuario.performOperation()).getLogin()))
				&& (temp.getPassword().equals(fac.R_Empresa(usuario.performOperation()).getPassword()))
				&& (temp.getNIT().equals(fac.R_Empresa(usuario.performOperation()).getNIT()))
				&& (temp.getNombre().equals(fac.R_Empresa(usuario.performOperation()).getNombre()))
				&& (temp.getDireccion().equals(fac.R_Empresa(usuario.performOperation()).getDireccion()))) {
			igual = true;
		}
		assertTrue(igual);
	}

	@Test
	void testU_Empresa() {
		FolderProxy usuario = new FolderProxy("Empresa1", "123");
		Empresa temp = new Empresa("Empresa1", "1234", "1234", "Empresa12", "direccion2");
		fac.U_Empresa("Empresa1", "Empresa1", "1234", "1234", "Empresa12", "direccion2", usuario.performOperation());
		boolean temp_A = false;
		if (temp.getLogin().equals(this.fac.BuscarEmpresas("Empresa1").getLogin())
				&& temp.getPassword().equals(this.fac.BuscarEmpresas("Empresa1").getPassword())
				&& temp.getNIT().equals(this.fac.BuscarEmpresas("Empresa1").getNIT())
				&& temp.getNombre().equals(this.fac.BuscarEmpresas("Empresa1").getNombre())) {
			temp_A = true;
		}
		assertTrue(temp_A);
	}

	@Test
	void testD_Empresa() {
		FolderProxy usuario = new FolderProxy("Empresa1", "123");
		boolean esta = false;
		fac.D_Empresa(fac.R_Empresa(usuario.performOperation()).getLogin(), usuario.performOperation());
		if (fac.R_Empresa(usuario.performOperation()) == null) {
			esta = true;
		}
		assertTrue(esta);
	}

	@Test
	void testC_Trabajador() {
		FolderProxy usuario = new FolderProxy("Trabajador1", "123");
		boolean esta = false;
		if (fac.R_Trabajador(usuario.performOperation()) != null) {
			esta = true;
		}
		assertTrue(esta);
	}

	@Test
	void testR_Trabajador() {
		FolderProxy usuario = new FolderProxy("Trabajador1", "123");
		Trabajador temp = new Trabajador("Trabajador1", "123", "Trabajador1", "123456");
		boolean igual = false;
		if ((temp.getLogin().equals(fac.R_Trabajador(usuario.performOperation()).getLogin()))
				&& (temp.getPassword().equals(fac.R_Trabajador(usuario.performOperation()).getPassword()))
				&& (temp.getNombre().equals(fac.R_Trabajador(usuario.performOperation()).getNombre()))
				&& (temp.getDocumento().equals(fac.R_Trabajador(usuario.performOperation()).getDocumento()))) {
			igual = true;
		}
		assertTrue(igual);
	}

	@Test
	void testU_Trabajador() {
		FolderProxy usuario = new FolderProxy("Trabajador1", "123");
		Trabajador temp = new Trabajador("Trabajador1", "1234", "Trabajador1", "123456");
		String g = fac.U_Trabajador("Trabajador1", "Trabajador1", "1234", "Trabajador1", "123456",
				usuario.performOperation());
		boolean temp_A = false;
		if ((temp.getLogin().equals(fac.BuscarTrabajadores("Trabajador1").getLogin()))
				&& (temp.getPassword().equals(fac.BuscarTrabajadores("Trabajador1").getPassword()))
				&& (temp.getNombre().equals(fac.BuscarTrabajadores("Trabajador1").getNombre()))
				&& (temp.getDocumento().equals(fac.BuscarTrabajadores("Trabajador1").getDocumento()))) {
			temp_A = true;
		}
		assertTrue(temp_A);
	}

	@Test
	void testD_Trabajador() {

		FolderProxy usuario = new FolderProxy("Trabajador1", "123");
		boolean esta = false;
		fac.D_Trabajador(fac.R_Trabajador(usuario.performOperation()).getLogin(), usuario.performOperation());
		if (fac.R_Empresa(usuario.performOperation()) == null) {
			esta = true;
		}
		assertTrue(esta);
	}

	@Test
	void testC_Psicologo() {
		FolderProxy usuario = new FolderProxy("Psicologo1", "123");
		boolean esta = false;
		if (fac.R_Psicologo(usuario.performOperation()) != null) {
			esta = true;
		}
		assertTrue(esta);
	}

	@Test
	void testR_Psicologo() {
		FolderProxy usuario = new FolderProxy("Psicologo1", "123");
		PsicologoAdapter temp = new PsicologoAdapter("Psicologo1", "123", "Psicologo123", "123456");
		boolean igual = false;
		if ((temp.getLogin().equals(fac.R_Psicologo(usuario.performOperation()).getLogin()))
				&& (temp.getPassword().equals(fac.R_Psicologo(usuario.performOperation()).getPassword()))
				&& (temp.getNombre().equals(fac.R_Psicologo(usuario.performOperation()).getNombre()))
				&& (temp.getDocumento().equals(fac.R_Psicologo(usuario.performOperation()).getDocumento()))) {
			igual = true;
		}
		assertTrue(igual);
	}

	@Test
	void testU_Psicologo() {
		FolderProxy usuario = new FolderProxy("Psicologo1", "123");
		String key = usuario.performOperation();
		PsicologoAdapter temp = new PsicologoAdapter("Psicologo1", "123", "Psicologo123", "123456");
		fac.U_Psicologo("Psicologo1", "Psicologo1", "123", "Psicologo123", "123456", key);
		boolean igual = false;

		if ((temp.getLogin().equals(fac.R_Psicologo(key).getLogin()))
				&& (temp.getPassword().equals(fac.R_Psicologo(key).getPassword()))
				&& (temp.getNombre().equals(fac.R_Psicologo(key).getNombre()))
				&& (temp.getDocumento().equals(fac.R_Psicologo(key).getDocumento()))) {
			igual = true;
		}
		assertTrue(igual);
	}

	@Test
	void testD_Psicologo() {
		FolderProxy usuario = new FolderProxy("Psicologo1", "123");
		boolean esta = false;
		fac.D_Psicologo(fac.R_Psicologo(usuario.performOperation()).getLogin(), usuario.performOperation());
		if (fac.R_Empresa(usuario.performOperation()) == null) {
			esta = true;
		}
		assertTrue(esta);
	}

	@Test
	void testC_AgrupacionOferta() {
		Oferta of= new Oferta("123", "Cargo", "Descripcion");
		fac.C_AgrupacionOferta("123", "Cargo", "Descripcion", "Empresa1");
		boolean b=false;
		if (fac.BuscarEmpresas("Empresa1").getOfertaIndividual(of.getCodigo()).getCodigo().equals(of.getCodigo())) {
			b=true;
		}
		assertTrue(b);
	}

	@Test
	void testC_AgrupacionEmpresa() {
		fac.C_AgrupacionEmpresa("Empresa1", "Empresa2");
		boolean b=false;
		if (fac.BuscarEmpresas("Empresa2").getPadre().equals("Empresa1")) {
			b=true;
		}
		assertTrue(b);
	}

	@Test
	void testD_Oferta() {
		Oferta of= new Oferta("123", "Cargo", "Descripcion");
		fac.D_Oferta(of.getCodigo(), "Empresa1");
		boolean b=false;
		if (fac.BuscarEmpresas("Empresa1").getOfertaIndividual(of.getCodigo()) == null) {
			b=true;
		}
		assertTrue(b);
	}

}
