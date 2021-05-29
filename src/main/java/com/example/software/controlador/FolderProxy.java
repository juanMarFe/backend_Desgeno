package com.example.software.controlador;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import com.example.software.modelo.UsuarioFactory;

public class FolderProxy implements IFolder {

	Facade s = Facade.crearInstaSingleton();
	UsuarioFactory uf = s.getUsuarioFactory();
	HashMap map = uf.getList();
	private String password;
	private String usuario;

	public FolderProxy(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	@Override
	public String performOperation() {
		boolean b = false;
		String usuario = null;
		String contrasena=null;
		for (Object key : map.keySet()) {
			if ((uf.getUsuario(key.toString()).checkLogin(this.usuario, this.password))) {
				usuario = uf.getUsuario(key.toString()).getLogin();
				contrasena=uf.getUsuario(key.toString()).getPassword();
				b = true;
				break;
			}
		}
		if (b) {
			
			String p=s.performOperation();
			return generateEncryption(usuario+","+contrasena, p);
		} else {
			return null;
		}
	}

	private String generateEncryption(String text, String myKey) {
		byte[] key;
		SecretKeySpec secretKey = null;
		MessageDigest sha = null;
		try {
			/////////////////////////////////////////////////////////////////
			try {
				key = myKey.getBytes("UTF-8");
				sha = MessageDigest.getInstance("SHA-1");
				key = sha.digest(key);
				key = Arrays.copyOf(key, 16);
				secretKey = new SecretKeySpec(key, "AES");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			/////////////////////////////////////////////////////////////////////
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
			return null;
		}
	}
	


}


