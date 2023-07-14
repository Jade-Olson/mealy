package com.olson.mealy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.olson.mealy.models.Ingredient;
import com.olson.mealy.models.Meal;
import com.olson.mealy.models.MealPlan;
import com.olson.mealy.models.User;
import com.olson.mealy.services.IngredientService;
import com.olson.mealy.services.MealPlanService;
import com.olson.mealy.services.MealService;
import com.olson.mealy.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MealController {
	@Autowired
	private MealService mealServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private IngredientService ingServ;
	@Autowired
	private MealPlanService mpServ;
	
	// Meals List
	@GetMapping("/meals")
	public String mealsList(Model model, HttpSession session) {
		model.addAttribute("meals", mealServ.allWithUser((User) session.getAttribute("user")));
		return "mealList.jsp";
	}
	
	// New Meal Page
	@GetMapping("/meals/new")
	public String newMeal(@ModelAttribute("meal") Meal meal, Model model, HttpSession session) {
		model.addAttribute("ingredients", ingServ.allIngredientsByUser((User) session.getAttribute("user")));
		return "newMeal.jsp";
	}
	
	// New Meal Post Handling
	@PostMapping("/meals/new")
	public String createMeal(@Valid @ModelAttribute("meal") Meal meal, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("ingredients", ingServ.allIngredientsByUser((User) session.getAttribute("user")));
			return "newMeal.jsp";
		} else {
			meal.setUser(userServ.findById((Long) session.getAttribute("userId")));
			mealServ.create(meal);
			return "redirect:/meals";
		}
	}
	
	// View Meal
	@GetMapping("/meals/{id}")
	public String viewMeal(@PathVariable("id") Long id, HttpSession session, Model model) {
		model.addAttribute("meal", mealServ.findMeal(id));
		return "viewMeal.jsp";
	}
	
	// Edit Meal
	@GetMapping("/meals/{id}/edit")
	public String editMeal(@PathVariable("id") Long id, HttpSession session, Model model) {
		model.addAttribute("ingredients", ingServ.allIngredientsByUser((User) session.getAttribute("user")));
		model.addAttribute("meal", mealServ.findMeal(id));
		return "editMeal.jsp";
	}
	
	// Edit Meal Post Handling
	@PostMapping("/meals/{id}/edit")
	public String updateMeal(@Valid @ModelAttribute("meal") Meal meal, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("ingredients", ingServ.allIngredientsByUser((User) session.getAttribute("user")));
			return "editMeal.jsp";
		} else {
			meal.setUser(userServ.findById((Long) session.getAttribute("userId")));
			mealServ.update(meal);
			return "redirect:/meals";
		}
	}
	
	//Delete
	@DeleteMapping("/meals/{id}")
	public String deleteMeal(@PathVariable("id") Long id) {
		Meal meal = mealServ.findMeal(id);
		for(Ingredient ingredient : meal.getIngredients()) {
			ingredient.getMeals().remove(meal);
		}
		for(MealPlan mealPlan : meal.getMealPlans()) {
			mpServ.deleteByMealPlan(mealPlan);
		}
		mealServ.delete(id);
		return "redirect:/meals";
	}
}
