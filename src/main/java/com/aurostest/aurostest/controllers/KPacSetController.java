package com.aurostest.aurostest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aurostest.aurostest.dao.impl.KPacDaoImpl;
import com.aurostest.aurostest.dao.impl.KPacSetAndKPacDaoImpl;
import com.aurostest.aurostest.dao.impl.KPacSetDaoImpl;
import com.aurostest.aurostest.model.KPacModel;
import com.aurostest.aurostest.model.KPacSetModel;

@Controller
public class KPacSetController {

	@Autowired
	KPacSetDaoImpl jdbc;

	@Autowired
	KPacDaoImpl jdbc2;

	List<Integer> list = new ArrayList<>();

	@Autowired
	KPacSetAndKPacDaoImpl jdbc3;

	@GetMapping("/sets")
	public String listSetKPac(Model model) {
		model.addAttribute("kpacSet", new KPacSetModel());
		model.addAttribute("listSetKPacs", this.jdbc.getAllKPacSets());
		model.addAttribute("kpac", new KPacModel());
		model.addAttribute("listKPacs", this.jdbc2.getAllKPacs());

		return "sets";
	}

	@PostMapping("/set/add")
	public String addSetKPac(@ModelAttribute("kpacSet") KPacSetModel set) {
		if (set.getIdSet() == 0) {
			this.jdbc.addSet(set);
			List<KPacSetModel> sett = jdbc.getAllKPacSets();
			KPacSetModel last = sett.get(sett.size() - 1);
			for (int num : list) {
				this.jdbc3.insert(last.getIdSet(), num);
				System.out.println(last.getIdSet());
			}
		}
		list = new ArrayList<>();
		return "redirect:/sets";
	}

	@GetMapping("/removeSet/{id}")
	public String removeSetKPac(@PathVariable("id") int id) {
		this.jdbc.removeSet(id);
		return "redirect:/sets";
	}

	@GetMapping("/set/{id}")
	public String removseSetKPac(@PathVariable("id") int id, Model model) {
		this.jdbc.removeSet(id);
		model.addAttribute("kpac", new KPacModel());
		model.addAttribute("listKPacs", this.jdbc3.getAllKPacSetsAndKPac());
		return "set";
	}

	@GetMapping("/addToSet/{id}")
	public String addToSet(@PathVariable("id") int id) {
		this.list.add(id);
		return "redirect:/sets";
	}

}
