package com.olson.mealy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olson.mealy.models.Ingredient;
import com.olson.mealy.models.User;
import com.olson.mealy.repositories.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepo;
	
	public Ingredient create(Ingredient newIngredient) {
		return ingredientRepo.save(newIngredient);
	}
	
	public Ingredient findIngredient(Long id) {
		Optional<Ingredient> optIngredient = ingredientRepo.findById(id);
		if(optIngredient.isPresent()) {
			return optIngredient.get();
		} else {
			return null;
		}
	}
	
	public List<Ingredient> allIngredients(){
		return ingredientRepo.findAll();
	}
	
	public void update(Ingredient newIngredient) {
		ingredientRepo.save(newIngredient);
	}
	
	public void delete(Long id) {
		ingredientRepo.deleteById(id);
	}
	
	public List<Ingredient> allIngredientsByUser(User user){
		return ingredientRepo.findAllByUser(user);
	}
}
