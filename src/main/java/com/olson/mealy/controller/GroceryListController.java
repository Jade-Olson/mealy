package com.olson.mealy.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.olson.mealy.models.GroceryItem;
import com.olson.mealy.models.Ingredient;
import com.olson.mealy.models.MealPlan;
import com.olson.mealy.models.User;
import com.olson.mealy.services.MealPlanService;

import jakarta.servlet.http.HttpSession;

@Controller
public class GroceryListController {
	@Autowired
	private MealPlanService mpServ;
	
	@GetMapping("/groceries")
	public String groceryList(HttpSession session, Model model) {
		List<MealPlan> MPs = mpServ.findWithUser((User) session.getAttribute("user"));
		List<GroceryItem> allGroceries = new ArrayList<GroceryItem>();
		for(MealPlan mp : MPs) {
			for(Ingredient ingredient : mp.getMeal().getIngredients()) {
				GroceryItem groceryItem = new GroceryItem();
				groceryItem.setIngredient(ingredient);
				groceryItem.setUser(mp.getUser());
				groceryItem.setIsChecked(false);
				if(!allGroceries.contains(groceryItem)) {
					allGroceries.add(groceryItem);
				}
			}
		}
		HashSet<Object> seen = new HashSet<>();
		allGroceries.removeIf(e -> !seen.add(e.getIngredient()));
		model.addAttribute("groceries", allGroceries);
		
		return "groceryList.jsp";
	}
}
