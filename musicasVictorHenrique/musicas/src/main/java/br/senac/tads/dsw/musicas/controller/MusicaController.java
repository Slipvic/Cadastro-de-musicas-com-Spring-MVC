package br.senac.tads.dsw.musicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.senac.tads.dsw.musicas.entities.Musicas;
import br.senac.tads.dsw.musicas.repositories.MusicaRepository;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController {
	
	@Autowired
	private MusicaRepository repository;

	
	@RequestMapping
	public ModelAndView ListaMusicas() {
		List<Musicas> result = repository.findAll();
		
		ModelAndView musicas = new ModelAndView("ListaMusicas");
		musicas.addObject("repository", result);
		
		return musicas;			
	}
	

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView musicas = new ModelAndView("cadastrarMusicas");
		musicas.addObject(new Musicas());
		return musicas;
	}
	
	@PostMapping("/enviar")
	public ModelAndView enviarDados(
	        @RequestParam("titulo") String titulo,
	        @RequestParam("artista") String artista,
	        @RequestParam("ano") int anoL) {

	    Musicas musica = new Musicas();
	    musica.setTitulo(titulo);
	    musica.setArtista(artista);
	    musica.setAnoL(anoL);

	    repository.save(musica);

	    ModelAndView modelAndView = new ModelAndView("redirect:/musicas");
	  //  modelAndView.addObject("mensagem", "Dados enviados com sucesso!");

	    return modelAndView;
	}


}
