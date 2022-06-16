package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.service.ChefService;
import it.uniroma3.siw.service.BuffetService;

@Controller
public class BuffetController {
	
	@Autowired
	BuffetService bs;
	
	@Autowired
	ChefService cs;
	
	@RequestMapping(value = "/buffets", method = RequestMethod.GET)
	public String mostraListaBuffets (Model model) {
		model.addAttribute("buffets", this.bs.listaBuffets());
		return "buffets.html";
	}
	
	@RequestMapping(value = "/buffets/ascN", method = RequestMethod.GET)
	public String mostraListaBuffetsAscN (Model model) {
		model.addAttribute("buffets", this.bs.listaBuffetsPerNomeAsc());
		return "buffets.html";
	}
	
	@RequestMapping(value = "/buffets/descN", method = RequestMethod.GET)
	public String mostraListaBuffetsDescN (Model model) {
		model.addAttribute("buffets", this.bs.listaBuffetsPerNomeDesc());
		return "buffets.html";
	}
	
	@RequestMapping(value = "/buffets/{id}", method = RequestMethod.GET)
	public String getBuffet (@PathVariable("id") Long id, Model model) {
		model.addAttribute("buffet", this.bs.cercaId(id));
		return "buffet.html";
	}
	
	@RequestMapping(value = "/nuovoBuffet", method = RequestMethod.GET)
	public String formBuffet (Model model) {
		model.addAttribute("buffet", new Buffet());
		model.addAttribute("chefs", this.cs.listaChefs());
		return "nuovoBuffet.html";
	}
	
	@RequestMapping(value = "/nuovoBuffet", method = RequestMethod.POST)
	public String addBuffet (@ModelAttribute("buffet") Buffet b, Model model) {
		this.bs.salva(b);
		model.addAttribute("buffets", this.bs.listaBuffets());
		return "buffets.html";
	}
}
