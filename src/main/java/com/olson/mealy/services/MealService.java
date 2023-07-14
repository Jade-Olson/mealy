package com.olson.mealy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olson.mealy.models.Meal;
import com.olson.mealy.models.User;
import com.olson.mealy.repositories.MealRepository;

@Service
public class MealService {
	@Autowired
	private MealRepository mealRepo;
	
	public Meal create(Meal newMeal) {
		return mealRepo.save(newMeal);
	}
	
	public Meal findMeal(Long id) {
		Optional<Meal> optMeal = mealRepo.findById(id);
		if(optMeal.isPresent()) {
			return optMeal.get();
		} else {
			return null;
		}
	}
	
	public List<Meal> allMeals(){
		return mealRepo.findAll();
	}
	
	public void update(Meal newMeal) {
		mealRepo.save(newMeal);
	}
	
	public void delete(Long id) {
		mealRepo.deleteById(id);
	}
	
	public List<Meal> allWithUser(User user){
		return mealRepo.findAllByUser(user);
	}
}
