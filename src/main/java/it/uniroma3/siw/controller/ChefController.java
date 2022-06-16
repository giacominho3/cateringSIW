package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.service.ChefService;

@Controller
public class ChefController {
	
	@Autowired
	ChefService cs;
	
	@RequestMapping(value = "/chefs", method = RequestMethod.GET)
	public String mostraListaChefs (Model model) {
		model.addAttribute("chefs", this.cs.listaChefs());
		return "chefs.html";
	}
	
	@RequestMapping(value = "/chefs/ascC", method = RequestMethod.GET)
	public String mostraListaChefsAscC (Model model) {
		model.addAttribute("chefs", this.cs.listaPerCognomeAsc());
		return "chefs.html";
	}
	
	@RequestMapping(value = "/chefs/descC", method = RequestMethod.GET)
	public String mostraListaChefsDescC (Model model) {
		model.addAttribute("chefs", this.cs.listaPerCognomeDesc());
		return "chefs.html";
	}
	
	@RequestMapping(value = "/chefs/ascN", method = RequestMethod.GET)
	public String mostraListaChefsAsN (Model model) {
		model.addAttribute("chefs", this.cs.listaPerNazionalitaAsc());
		return "chefs.html";
	}
	
	@RequestMapping(value = "/chefs/descN", method = RequestMethod.GET)
	public String mostraListaChefsDescN (Model model) {
		model.addAttribute("chefs", this.cs.listaPerNazionalitaDesc());
		return "chefs.html";
	}
	
	@RequestMapping(value = "/chefs/{id}", method = RequestMethod.GET)
	public String getChef (@PathVariable("id") Long id, Model model) {
		model.addAttribute("chef", this.cs.cercaId(id));
		return "chef.html";
	}
	
	@RequestMapping(value = "/admin/nuovoChef", method = RequestMethod.GET)
	public String formChef (Model model) {
		model.addAttribute("chef", new Chef());
		return "nuovoChef.html";
	}
	
	@RequestMapping(value = "/admin/nuovoChef", method = RequestMethod.POST)
	public String addChef (@ModelAttribute("chef") Chef c, Model model) {
		this.cs.salva(c);
		model.addAttribute("chefs", this.cs.listaChefs());
		return "chefs.html";
	}
}