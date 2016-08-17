package eisa.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



import eisa.model.AjaxResponse;
import eisa.model.Bairro;
import eisa.repository.BairroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class BairroController {
	
	@Autowired
	BairroRepository bairroRepository;

	
	@ResponseBody
	@RequestMapping("/bairros.json")
	public List<AjaxResponse> list(HttpServletRequest  request, Principal principal){ 

		

		String termo = request.getParameter("termo");
		System.out.println("termo: "+termo);
		if (termo == null|| termo.length() < 2){
			return Collections.emptyList();
		} else {
			List<AjaxResponse> bairros = new ArrayList<>();
			for(Bairro b : bairroRepository.findByLike(termo)){
				bairros.add(new AjaxResponse(b.getId(), b.getNome()));
			}
			return bairros;
		}
	}
	@ResponseBody
	@RequestMapping("/bairros_all.json")
	public List<AjaxResponse> listAll(HttpServletRequest  request, Principal principal){ 

		

	
			List<AjaxResponse> bairros = new ArrayList<>();
			for(Bairro b : bairroRepository.findAll()){
				bairros.add(new AjaxResponse(b.getId(), b.getNome()));
			}
			return bairros;
		
	}
}
