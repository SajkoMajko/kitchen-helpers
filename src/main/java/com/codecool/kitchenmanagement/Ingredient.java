package com.codecool.kitchenmanagement;

import java.util.Random;

public enum Ingredient {
    POTATO, MEAT, CARROT;
    private static final Random RANDOM = new Random();

    public static Ingredient randomIngredient(){
        var allIngredients = Ingredient.values();
        var maxIndex = allIngredients.length;
        return allIngredients[RANDOM.nextInt(maxIndex)];
    }
}
