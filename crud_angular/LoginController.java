package eisa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eisa.model.Pessoa;
import eisa.model.User;
import eisa.service.ValidaLoginERP;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {
	
	@Autowired
	ValidaLoginERP validaLoginERP;

	@RequestMapping(value="/login",method={RequestMethod.POST})
	public ResponseEntity<User> post(HttpServletResponse response,@RequestBody User user,HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException{
		System.out.println("Valida Login");
		System.out.println("LOGIN: "+user.getNome());
		System.out.println("SENHA: "+user.getSenha());
		System.out.println(validaLoginERP.login(user.getNome(), user.getSenha()));
		if(validaLoginERP.login(user.getNome(), user.getSenha())){
		return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value="/login/{id}",method=RequestMethod.GET)
	public ResponseEntity<User>  pessoa(HttpServletResponse response,User user, @PathVariable String id){
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
