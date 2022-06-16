package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Piatto;
import it.uniroma3.siw.service.IngredienteService;
import it.uniroma3.siw.service.PiattoService;

@Controller
public class PiattoController {

	@Autowired
	private PiattoService ps;
	
	@Autowired
	private IngredienteService is;

	
	@RequestMapping(value = "/piatti", method = RequestMethod.GET)
	public String mostraListaPiatti (Model model) {
		model.addAttribute("piatti", this.ps.listaPiatti());
		return "piatti.html";
	}
	
	@RequestMapping(value = "/piatti/ascN", method = RequestMethod.GET)
	public String mostraListaPiattiAscN (Model model) {
		model.addAttribute("piatti", this.ps.listaPiattiPerNomeAsc());
		return "piatti.html";
	}
	
	@RequestMapping(value = "/piatti/descN", method = RequestMethod.GET)
	public String mostraListaBuffetsDescN (Model model) {
		model.addAttribute("piatti", this.ps.listaPiattiPerNomeDesc());
		return "piatti.html";
	}
	
	@RequestMapping(value = "/piatti/{id}", method = RequestMethod.GET)
	public String getPiatto (@PathVariable("id") Long id, Model model) {
		model.addAttribute("piatto", this.ps.cercaId(id));
		return "piatto.html";
	}
	
	@RequestMapping(value = "/nuovoPiatto", method = RequestMethod.GET)
	public String formPiatto (Model model) {
		model.addAttribute("piatto", new Piatto());
		model.addAttribute("ings", this.is.listaIngredienti());
		return "nuovoPiatto.html";
	}
	
	@RequestMapping(value = "/nuovoPiatto", method = RequestMethod.POST)
	public String addPiatto (@ModelAttribute("piatto") Piatto b, Model model) {
		this.ps.salva(b);
		model.addAttribute("piatti", this.ps.listaPiatti());
		return "piatti.html";
	}
}
