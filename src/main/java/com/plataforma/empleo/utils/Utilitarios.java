package com.plataforma.empleo.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Utilitarios {
	
	 public static String extraerHash(String inputpassword) {
	    	
	    	return BCrypt.hashpw(inputpassword, BCrypt.gensalt());
	    	
	    }
	    
	    
	    public static boolean verificarContrasenia(String inputpassword, String hashPassword) {
	    	return BCrypt.checkpw(inputpassword, hashPassword);
	    }

}
