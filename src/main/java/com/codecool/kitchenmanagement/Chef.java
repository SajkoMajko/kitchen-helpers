package com.codecool.kitchenmanagement;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public class Chef extends CookerEmployee {
    private IngredientStore store;
    private Random random = new Random();

    public Chef(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public Optional<Ingredient> requestIngredient(Ingredient ingredient) {
        return null;
    }

    public void setStore(IngredientStore store) {
        this.store = store;
    }
    public void yell(){
        System.out.println("bad helpers!");
    }


    @Override
    void cookWithKnives() {
        var shouldAskForIngredient = random.nextBoolean();
        shouldAskForIngredient = true;
        if(!shouldAskForIngredient || store == null){
            return;
        }

        Ingredient randomIngredient = Ingredient.randomIngredient();
        System.out.format("I need %s"+System.lineSeparator(), randomIngredient);
        Optional<Ingredient> received = store.requestIngredient(randomIngredient);
        String ingredientName = received.map(Ingredient::toString).orElse("NOTHING");
        System.out.println("I got " + ingredientName);
    }
}
