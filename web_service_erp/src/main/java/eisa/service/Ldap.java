/*$Id$**/
package eisa.service;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.stereotype.Component;

@Component
public class Ldap {
	
	private String usuario,senha;

	@SuppressWarnings({ "unchecked", "unused", "finally" })
	public boolean autentica(String user,String password){
		usuario = user;
		senha = password;
		boolean verifica = false;
		@SuppressWarnings("rawtypes")
		Hashtable env = new Hashtable();
		String dominio ="@eisa.corp.com" ;
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://172.22.0.5:389");
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		env.put(Context.SECURITY_PRINCIPAL,user+dominio);
		env.put(Context.SECURITY_CREDENTIALS,password);        
		try  
		{  
			DirContext ctx = new InitialDirContext(env);
			if(ctx !=null){
			System.out.println("Autenticado!");  
			verifica = true;
			}
			
		}   
		catch (AuthenticationException authEx)   
		{  
			
			System.out.println("Erro na autenticação! ");  
			authEx.getCause().printStackTrace();  
			
		}  
		catch (NamingException namEx)   
		{  
			System.out.println("Problemas na conexão! ");  
			namEx.getCause().printStackTrace();  
			
		}  
		finally{
			return verifica;
		}
		
	} 
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
}

