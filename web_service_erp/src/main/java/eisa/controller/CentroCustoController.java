package eisa.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eisa.model.CEP;
import eisa.model.CentroCusto;
import eisa.repository.CentroCustoRepository;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class CentroCustoController {

	@Autowired
	CentroCustoRepository centroCustoRepository;
	
	@RequestMapping("centros")
	public @ResponseBody List<CentroCusto> centros(HttpServletResponse response){
		return centroCustoRepository.findAll();
	}
	
}
