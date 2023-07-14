package com.olson.mealy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.olson.mealy.models.Ingredient;
import com.olson.mealy.services.IngredientService;
import com.olson.mealy.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class IngredientController {
	@Autowired
	private IngredientService ingredientServ;
	@Autowired
	private UserService userServ;
	
	//Ingredient Create Page
	@GetMapping("/ingredients/new")
	public String ingredientForm(@ModelAttribute("ingredient") Ingredient ingredient, HttpSession session) {
		return "newIngredient.jsp";
	}
	
	// New Ingredient
	@PostMapping("/ingredients/new")
	public String newIngredient(@Valid @ModelAttribute("ingredient") Ingredient ingredient, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "newIngredient.jsp";
		} else {
			ingredient.setUser(userServ.findById((Long) session.getAttribute("userId")));
			ingredientServ.create(ingredient);
			return "redirect:/meals/new";
		}
	}
}
