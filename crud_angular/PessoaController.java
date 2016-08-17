package eisa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eisa.MontaId;
import eisa.model.Pessoa;
import eisa.repository.PessoaRepository;

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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PessoaController {
	

	@Autowired
	PessoaRepository pessoaRepository;
	
	@RequestMapping(value="/pessoas",method=RequestMethod.GET)
	public List<Pessoa> pessoas(HttpServletResponse response){
		return pessoaRepository.findAll();
	}
	@RequestMapping("pessoa/{id}")
	public @ResponseBody Pessoa pessoa(HttpServletResponse response,@PathVariable String id){
		return pessoaRepository.findById(id);
	}
	
	@RequestMapping(value="/pessoa",method={RequestMethod.POST})
	public ResponseEntity<Pessoa> put(HttpServletResponse response,@RequestBody Pessoa pessoa,HttpServletRequest request){
		
		String CdChamada = "";
		CdChamada = pessoaRepository.pegaUltimoCodigo("Pessoa","CdChamada")+"";
		if(CdChamada.length()<6){
			int tamanhosobra = 6 - CdChamada.length();
			for(int i=0;i<tamanhosobra;i++){
				CdChamada = "0"+CdChamada;
			}
		}
		int valorId = pessoaRepository.pegaUltimoCodigo("Pessoa","IdPessoa");
		String idgerado = pessoaRepository.converteB36(valorId);
		System.out.println("CDChamada: "+CdChamada);
		System.out.println("IdGerado Antes : "+idgerado);
		idgerado = MontaId.montaId(idgerado);
		System.out.println("IdGerado: "+idgerado);
		
		System.out.println("METHOD: "+request.getMethod());
		System.out.println("Nome: "+pessoa.getNome());
		pessoa.setCodigo(CdChamada);
		pessoa.setId(idgerado);
		pessoa.setEndereco(null);
		pessoaRepository.save(pessoa);
		
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
	}
	
		@RequestMapping(value="/pessoas",method=RequestMethod.PUT)
	public ResponseEntity<Pessoa> put(HttpServletResponse response,@RequestBody Pessoa pessoa){
		System.out.println("Nome: "+pessoa.getNome());
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
}
