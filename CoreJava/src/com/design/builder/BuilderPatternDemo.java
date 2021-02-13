package com.design.builder;

public class BuilderPatternDemo {

	public static void main(String args[])
	{
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\n\nNon-veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: "+nonVegMeal.getCost());
	}
}
