package eisa.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import eisa.model.AjaxResponse;
import eisa.model.Bairro;
import eisa.model.CEP;
import eisa.model.Pessoa;
import eisa.repository.BairroRepository;
import eisa.repository.CepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class CepController {
	
	@Autowired
	CepRepository cepRepository;

	
	@RequestMapping("cep/{cep}")
	public @ResponseBody CEP pessoa(HttpServletResponse response,@PathVariable String cep){
		return cepRepository.findByCdCep(cep);
	}
}
