package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.service.IngredienteService;

@Controller
public class IngredienteController {

	@Autowired
	IngredienteService is;
	
	@RequestMapping(value = "/ingredienti", method = RequestMethod.GET)
	public String mostraListaIngredientes (Model model) {
		model.addAttribute("ingredienti", this.is.listaIngredienti());
		return "ingredienti.html";
	}
	
	@RequestMapping(value = "/ingredienti/ascN", method = RequestMethod.GET)
	public String mostraListaIngredientiAscN (Model model) {
		model.addAttribute("ingredienti", this.is.listaPerNomeAsc());
		return "ingredienti.html";
	}
	
	@RequestMapping(value = "/ingredienti/descN", method = RequestMethod.GET)
	public String mostraListaIngredientiDescN (Model model) {
		model.addAttribute("ingredienti", this.is.listaPerNomeDesc());
		return "ingredienti.html";
	}
	
	@RequestMapping(value = "/ingredienti/ascO", method = RequestMethod.GET)
	public String mostraListaIngredientiAscO (Model model) {
		model.addAttribute("ingredienti", this.is.listaPerOrigineAsc());
		return "ingredienti.html";
	}
	
	@RequestMapping(value = "/ingredienti/descO", method = RequestMethod.GET)
	public String mostraListaIngredientiDescO (Model model) {
		model.addAttribute("ingredienti", this.is.listaPerOrigineDesc());
		return "ingredienti.html";
	}
	
	@RequestMapping(value = "/ingredienti/{id}", method = RequestMethod.GET)
	public String getIngrediente (@PathVariable("id") Long id, Model model) {
		model.addAttribute("ingrediente", this.is.cercaId(id));
		return "ingrediente.html";
	}
	
	@RequestMapping(value = "/nuovoIngrediente", method = RequestMethod.GET)
	public String formIngrediente (Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "nuovoIngrediente.html";
	}
	
	@RequestMapping(value = "/nuovoIngrediente", method = RequestMethod.POST)
	public String addIngrediente (@ModelAttribute("ingrediente") Ingrediente c, Model model) {
		this.is.salva(c);
		model.addAttribute("ingredienti", this.is.listaIngredienti());
		return "ingredienti.html";
	}
}
