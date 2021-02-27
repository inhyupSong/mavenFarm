package ch.stfw.hfit18.oldmacdonaldsfarm.controller;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.stfw.hfit18.oldmacdonaldsfarm.model.Cow;
import ch.stfw.hfit18.oldmacdonaldsfarm.repo.CowRepository;

@Controller
@RequestMapping("/cows/")
public class CowController {

	@Autowired // ML: @Autowired initialisiert das Repository als Attribut im Controller
	private CowRepository cowRepository;

	// ML: Mapping für Listendarstellung, Referenz auf index.thml
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("cows", cowRepository.findAll());
		return "index";
	}

	// ML: Mapping für Add-Formular
	@GetMapping("add")
	public String addCow(Cow cow) {
		return "add-cow";
	}

	// ML: Mapping für's Abschicken des Add-Formulars
	@PostMapping("add")
	public String addCow(Cow cow, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-cow";
		}

		cowRepository.save(cow);
		return "redirect:list";
	}

	// ML: Mapping für Edit-Formular
	@GetMapping("edit/{id}")
	public String editCow(@PathVariable("id") long id, Model model) {
		Cow cow = cowRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cow Id:" + id));
		model.addAttribute("cow", cow);
		return "update-cow";
	}

	// ML: Mapping für's Abschicken des Edit-Formulars
	@PostMapping("edit/{id}")
	public String editCow(@PathVariable("id") long id, Cow cow, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			cow.setId(id);
			return "update-cow";
		}

		cowRepository.save(cow);
		model.addAttribute("cows", cowRepository.findAll());
		return "index";
	}

	// ML: Mapping für die Löschen-Funktionalität
	@GetMapping("delete/{id}")
	public String deleteCow(@PathVariable("id") long id, Model model) {
		Cow cow = cowRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cow Id:" + id));
		cowRepository.delete(cow);
		model.addAttribute("cows", cowRepository.findAll());
		return "index";
	}
}