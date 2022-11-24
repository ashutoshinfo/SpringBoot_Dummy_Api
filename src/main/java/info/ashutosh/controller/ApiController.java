package info.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import info.ashutosh.entity.API;
import info.ashutosh.exception.APINotFoundException;
import info.ashutosh.service.APIService;

@Controller
public class ApiController {

	@Autowired
	APIService aPIService;

	// 1. show Register page
	@GetMapping("/dummy/api/configure")
	public String showReg(Model model) {
		return "APIConfigure";
	}

	@GetMapping("/dummy/api")
	public String showAll(Model model, @RequestParam(required = false) String message) {
		List<API> list = aPIService.getAllAPIs();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "Apis";
	}

	@GetMapping("/dummy/api/edit")
	public String showEdit(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			API doc = aPIService.getOneAPI(id);
			model.addAttribute("API", doc);
			page = "APIEdit";
		} catch (APINotFoundException e) {
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:/dummy/api";

		}
		return page;
	}

	@PostMapping("/dummy/api/update")
	public String update(@ModelAttribute API api, RedirectAttributes redirectAttributes) {
		try {
			aPIService.updateDoctor(api);
			redirectAttributes.addAttribute("message", "API '" + api.getApiId() + "' Updated !");
		} catch (APINotFoundException e) {
			redirectAttributes.addAttribute("message", e.getMessage());
		}
		return "redirect:/dummy/api";
	}

	@GetMapping("/dummy/api/delete")
	public String delete(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			aPIService.deleteAPI(id);
			attributes.addAttribute("message", "API'" + id + "' deleted!");
		} catch (APINotFoundException e) {
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:/dummy/api";
	}

}
