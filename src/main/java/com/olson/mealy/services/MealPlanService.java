package com.olson.mealy.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olson.mealy.models.MealPlan;
import com.olson.mealy.models.User;
import com.olson.mealy.repositories.MealPlanRepository;

@Service
public class MealPlanService {
	@Autowired
	private MealPlanRepository mpRepo;
	
	public MealPlan create(MealPlan mealPlan) {
		return mpRepo.save(mealPlan);
	}
	
	public MealPlan findMealPlan(Long id) {
		Optional<MealPlan> opMealPlan = mpRepo.findById(id);
		if(opMealPlan.isPresent()) {
			return opMealPlan.get();
		} else {
			return null;
		}
	}
	
	public List<MealPlan> allMealPlans(){
		return mpRepo.findAll();
	}
	
	public void update(MealPlan mp) {
		mpRepo.save(mp);
	}
	
	public void delete(Long id) {
		mpRepo.deleteById(id);
	}
	
	public MealPlan findByDate(LocalDate date) {
		Optional<MealPlan> opMealPlan = mpRepo.findByDate(date);
		if(opMealPlan.isPresent()) {
			return opMealPlan.get();
		} else {
			return null;
		}
	}
	
	public void deleteByMealPlan(MealPlan mp){
		mpRepo.delete(mp);
	}
	
	public List<MealPlan> findWithUser(User user){
		return mpRepo.findAllByUser(user);
	}
}
