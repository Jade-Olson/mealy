package com.olson.mealy.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.olson.mealy.models.Meal;
import com.olson.mealy.models.MealPlan;
import com.olson.mealy.models.User;
import com.olson.mealy.services.MealPlanService;
import com.olson.mealy.services.MealService;
import com.olson.mealy.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MealPlanController {
	@Autowired
	private UserService userService;
	@Autowired 
	private MealPlanService mpServ;
	@Autowired
	private MealService mealServ;
	
	// Home Page
	@GetMapping("/home")
    public String home(Principal principal, Model model, HttpSession session) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        session.setAttribute("userId", userService.findByUsername(username).getId());
        session.setAttribute("user", userService.findByUsername(username));
        List<LocalDate> mealDates = LocalDate.now().datesUntil(LocalDate.now().plusDays(12)).collect(Collectors.toList());
        model.addAttribute("mealDates", mealDates);
        model.addAttribute("meals", mealServ.allWithUser(userService.findByUsername(username)));
        List<LocalDate> mealPlanDates = new ArrayList<LocalDate>();
        for(MealPlan mp : mpServ.findWithUser(userService.findByUsername(username))) {
        	if(mp.getDate().isBefore(LocalDate.now())) {
        		mpServ.deleteByMealPlan(mp);
        	}
        	mealPlanDates.add(mp.getDate());
        }
        model.addAttribute("mealPlanDates", mealPlanDates);
        model.addAttribute("mealPlans", mpServ.findWithUser(userService.findByUsername(username)));
        
        return "homePage.jsp";
    }
	
	// Meal Select
	@PostMapping("/mp/{date}")
	public String select(@RequestParam("meal") Meal meal, @RequestParam("date") LocalDate date, HttpSession session) {
				MealPlan mealPlan = new MealPlan();
				mealPlan.setDate(date);
				mealPlan.setMeal(meal);
				mealPlan.setUser(userService.findById((Long) session.getAttribute("userId")));
				mpServ.create(mealPlan);
				return "redirect:/home";
	}
	
	@DeleteMapping("/mp/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		mpServ.delete(id);
		return "redirect:/home";
	}
}
