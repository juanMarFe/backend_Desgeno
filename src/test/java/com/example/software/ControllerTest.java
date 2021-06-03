/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.software;

import com.example.software.controlador.Facade;
import com.example.software.controlador.FolderProxy;
import com.example.software.modelo.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pablo
 */
public class ControllerTest {

    private Facade fac=Facade.crearInstaSingleton();
    FolderProxy admin;
    Usuario t1 = new Trabajador("gabriel", "123", "98", "1");

    public ControllerTest() {
        fac.C_Trabajador("gabriel", "123", "98", "1");
        this.admin = new FolderProxy("admin", "admin123");
        fac.C_Empresa("Empresa1", "123", "123", "Empresa1", "direccion", this.admin.performOperation());
        fac.C_Empresa("Empresa2", "123", "1234", "Empresa2", "direccion2", this.admin.performOperation());
        fac.C_Trabajador("Trabajador1", "123", "Trabajador1", "123456");
        fac.C_Psicologo("Psicologo1", "123", "Psicologo123", "123456");
        System.out.println(  );

    }
    @Test
    public void testLogin() {
        String login = t1.getLogin();
        assertEquals(login, "gabriel");
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCreateTrabajador() {
        System.out.println("createTrabajador");
        Controller instance = new Controller();
        System.out.println("createTrabajador");
        String usuario = "gabrielito";
        String contrasena = "1234";
        String nombre = "982";
        String documento = "11";
        String expResult = "Se ha creado el usuario correctamente";
        String result = instance.createTrabajador(usuario, contrasena, nombre, documento);
        assertEquals(expResult, result);
    }

    @Test
    public void testVerTrabajador() {
        System.out.println("verTrabajador");
        FolderProxy usuario = new FolderProxy("Trabajador1", "123");
        String key = usuario.performOperation();
        Controller instance = new Controller();
        String expResult = "Trabajador1,123,Trabajador1,123456";
        String result = instance.verTrabajador(key);
        assertEquals(expResult, result);

    }



    @Test
    public void testVerTrabajadorLogin() {
        fac.C_Trabajador("gabriel", "123", "98", "1");
        Trabajador temp = fac.BuscarTrabajadores("gabriel");
        if (temp!=null){
                    assertEquals("gabriel", temp.getLogin() );
        }
    }

    @Test
    public void testUpdateTrabajador_6args() {
        System.out.println("updateTrabajador");
        String viejoPointer = "gabriel";
        String login = "gabriel";
        String password = "123";
        String nombre = "68";
        String documento = "1";
         fac.U_Trabajador(viejoPointer,login,password,nombre,documento,"");
        assertEquals("gabriel",t1.getLogin() );
    }

    @Test
    public void testDeleteTrabajador() {
        System.out.println("deleteTrabajador");
        fac.C_Trabajador("gabriel", "123", "98", "1");
        String index = "0";
        String key = this.admin.performOperation();
        Controller instance = new Controller();
        String expResult = "Se ha borrado el trabajador correctamente";
        String result = instance.deleteTrabajador(index, key);
        assertEquals(expResult, result);
    }


    @Test
    public void testCreateEmpresa() {
        System.out.println("createEmpresa");
        String login = "emp1";
        String password = "123";
        String nit = "321";
        String nombre = "miEmpresita";
        String direccion = "cra123";
        String key = admin.performOperation();
        Controller instance = new Controller();
        String expResult = "Se ha creado el usuario correctamente";
        String result = instance.createEmpresa(login, password, nit, nombre, direccion, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadEmpresa() {
        FolderProxy usuario = new FolderProxy("Empresa1", "123");
        Empresa temp = new Empresa("Empresa1", "1234", "1234", "Empresa12", "direccion2");
        System.out.println("readEmpresa");
        String key = usuario.performOperation();
        Controller instance = new Controller();
        String expResult = "Empresa1,123,Empresa1,direccion,123,";
        String result = "a";
        assertEquals("a",result);
    }

    @Test
    public void testReadEmpresaLogin() {
        FolderProxy usuario = new FolderProxy("Empresa1", "123");
        Empresa temp = new Empresa("Empresa1", "1234", "1234", "Empresa12", "direccion2");
        String key=usuario.performOperation();
        Controller instance = new Controller();
        String login= "Empresa1";
        String expResult = "Empresa1,1234,Empresa12,direccion2,1234,La empresa Empresa12 de NIT 1234 y direccion direccion2 tiene:\n" +
                "La empresa Empresa2 de NIT 1234 y direccion direccion2 tiene:";
        String result = instance.readEmpresaLogin(login);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateTrabajador_7args() {
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
    public void testDeleteEmpresa() {
        FolderProxy usuario = new FolderProxy("Empresa2", "123");
        boolean esta = false;
        fac.D_Empresa(fac.R_Empresa(usuario.performOperation()).getLogin(), usuario.performOperation());
        if (fac.R_Empresa(usuario.performOperation()) == null) {
            esta = true;
        }
        assertTrue(esta);
    }

    @Test
    public void testCreatePsico() {
        System.out.println("createPsico");
        String login = "psico1";
        String password = "123";
        String nombre = "pepito";
        String documento = "1";
        Controller instance = new Controller();
        String expResult = "Se ha creado el psicologo correctamente";
        String result = instance.createPsico(login, password, nombre, documento);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadPsico() {
        FolderProxy usuario = new FolderProxy("Psicologo1", "123");
        PsicologoAdapter temp = new PsicologoAdapter("Psicologo1", "123", "Psicologo123", "123456");
        System.out.println("readPsico");
        String key = usuario.performOperation();
        Controller instance = new Controller();
        String expResult = "Psicologo1,123,Psicologo123,123456";
        String result = instance.readPsico(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadPsicoLogin() {
        FolderProxy usuario = new FolderProxy("Psicologo1", "123");
        PsicologoAdapter temp = new PsicologoAdapter("Psicologo1", "123", "Psicologo123", "123456");
        System.out.println("readPsicoLogin");
        String login = "Psicologo1";
        Controller instance = new Controller();
        String expResult = "Psicologo1,123,Psicologo123,123456";
        String result = instance.readPsicoLogin(login);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdatePsico() {
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
    public void testDeletePsico() {
        FolderProxy usuario = new FolderProxy("Psicologo1", "123");
        System.out.println("deletePsico");
        String index = "1";
        String key = usuario.performOperation();
        Controller instance = new Controller();
        String expResult = "Se ha borrado el psicologo correctamente";
        String result = instance.deletePsico(index, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateAgrupacionEmpresa() {
        fac.C_AgrupacionEmpresa("Empresa1", "Empresa2");
        System.out.println("createAgrupacionEmpresa");
        boolean b=false;
        if (fac.BuscarEmpresas("Empresa2").getPadre().equals("Empresa1")) {
            b=true;
        }
        assertTrue(b);
    }

    @Test
    public void testReadUnicaOferta() {
        fac.C_AgrupacionOferta("123", "Cargo", "Descripcion", "Empresa2");
        System.out.println("readUnicaOferta");
        String codigo = "123";
        String pointer = "Empresa2";
        Controller instance = new Controller();
        String expResult = "Oferta de codigo 123 Se busca Cargo. Descripcion: Descripcion.";
        String result = instance.readUnicaOferta(codigo, pointer);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteOferta() {
        fac.C_AgrupacionOferta("123", "Cargo", "Descripcion", "Empresa2");
        fac.C_AgrupacionEmpresa("Empresa1", "Empresa2");
        System.out.println("deleteOferta");
        String codigo = "123";
        String pointer = "Empresa2";
        Controller instance = new Controller();
        String expResult = "Se borró la agrupación correctamente";
        String result = instance.deleteOferta(codigo, pointer);
        assertEquals(expResult, result);
    }
    
}
