/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.software;

import com.example.software.controlador.Facade;
import com.example.software.modelo.Trabajador;
import com.example.software.modelo.Usuario;
import org.junit.jupiter.api.*;

import com.example.software.modelo.Empresa;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pablo
 */
public class ControllerTest {

    private Facade facade=Facade.crearInstaSingleton();
    Usuario t1 = new Trabajador("gabriel", "123", "98", "1");

    public ControllerTest() {
        facade.C_Trabajador("gabriel", "123", "98", "1");
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
        String usuario = "gabriel";
        String contrasena = "123";
        String nombre = "98";
        String documento = "1";
        Usuario t2 = new Trabajador(usuario, contrasena,nombre, documento);
        assertEquals(t1.getLogin(), t2.getLogin());
    }

    /**
     * Test of verTrabajador method, of class Controller.
     */
    @Test
    public void testVerTrabajador() {
        String key="gabriel";

        Trabajador temp = facade.R_Trabajador(key);
        if (temp==null){
            assertEquals(null, temp);
        }else{
            assertEquals(temp.getLogin(), t1.getLogin());
        }

    }



    @Test
    public void testVerTrabajadorLogin() {
        facade.C_Trabajador("gabriel", "123", "98", "1");
        Trabajador temp = facade.BuscarTrabajadores("gabriel");
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
         facade.U_Trabajador(viejoPointer,login,password,nombre,documento,"");
        assertEquals("gabriel",t1.getLogin() );
    }

    @Test
    public void testDeleteTrabajador() {
        System.out.println("deleteTrabajador");
        facade.C_Trabajador("gabriel", "123", "98", "1");
        String index = "0";
        String key = "123";
        Controller instance = new Controller();
        String expResult = null;
        String result = instance.deleteTrabajador(index, key);
        assertEquals(expResult, result);
    }


    @Test
    public void testCreateEmpresa() {

        System.out.println("createEmpresa");
        String login = "empi";
        String password = "123";
        String nit = "1";
        String nombre = "e";
        String direccion = "123";
        String key = null;
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.createEmpresa(login, password, nit, nombre, direccion, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadEmpresa() {
        System.out.println("readEmpresa");
        String key = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.readEmpresa(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadEmpresaLogin() {
        String key="123";

        Empresa temp = facade.R_Empresa(key);
        if (temp==null){
            assertEquals(null, temp);
        }else{
            assertEquals(temp.getLogin(), t1.getLogin());
        }
    }

    @Test
    public void testUpdateTrabajador_7args() {
        System.out.println("updateTrabajador");
        String viejoPointer = "gabriel";
        String login = "gabriel";
        String password = "123";
        String nit = "1";
        String nombre = "12";
        String direccion = "2";
        String key = "123";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.updateTrabajador(viejoPointer, login, password, nit, nombre, direccion, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteEmpresa() {
        System.out.println("deleteEmpresa");
        String index = "";
        String key = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.deleteEmpresa(index, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreatePsico() {
        System.out.println("createPsico");
        String login = "";
        String password = "";
        String nombre = "";
        String documento = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.createPsico(login, password, nombre, documento);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadPsico() {
        System.out.println("readPsico");
        String key = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.readPsico(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadPsicoLogin() {
        System.out.println("readPsicoLogin");
        String login = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.readPsicoLogin(login);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdatePsico() {
        System.out.println("updatePsico");
        String viejoPointer = "";
        String login = "";
        String password = "";
        String nombre = "";
        String documento = "";
        String key = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.updatePsico(viejoPointer, login, password, nombre, documento, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeletePsico() {
        System.out.println("deletePsico");
        String index = "";
        String key = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.deletePsico(index, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateAgrupacionEmpresa() {
        System.out.println("createAgrupacionEmpresa");
        String pointer = "";
        String pointer2 = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.createAgrupacionEmpresa(pointer, pointer2);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadUnicaOferta() {
        System.out.println("readUnicaOferta");
        String codigo = "";
        String pointer = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.readUnicaOferta(codigo, pointer);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteOferta() {
        System.out.println("deleteOferta");
        String codigo = "";
        String pointer = "";
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.deleteOferta(codigo, pointer);
        assertEquals(expResult, result);
    }
    
}
