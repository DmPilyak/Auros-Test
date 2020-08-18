package com.aurostest.aurostest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aurostest.aurostest.dao.impl.KPacDaoImpl;
import com.aurostest.aurostest.model.KPacModel;

@Controller
public class KPacController {

	@Autowired
	KPacDaoImpl jdbc;

	@GetMapping("/kpacs")
	public String listKPac(Model model) {
		model.addAttribute("kpac", new KPacModel());
		model.addAttribute("listKPacs", this.jdbc.getAllKPacs());

		return "kpacs";
	}
	
	@PostMapping("/kpac/add")
	public String addKPac(@ModelAttribute("kpac") KPacModel kpac) {
		if(kpac.getId() == 0){
            this.jdbc.addKPac(kpac);
        }
        return "redirect:/kpacs";
	}
	
	@GetMapping("/remove/{id}")
	public String removeKPac(@PathVariable("id") int id) {
		this.jdbc.removeKPac(id);
        return "redirect:/kpacs";
	}
}
