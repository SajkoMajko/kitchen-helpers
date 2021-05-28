package com.codecool.kitchenmanagement;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Kitchen implements IngredientStore {
    private Chef chef;
    private Set<KitchenHelper> helpers = new HashSet<>();
    private Set<CookerEmployee> cookers = new HashSet<>();
    private Set<Employee> employees = new HashSet<>();

    public void hireEmployee(Employee employee) {
        employees.add(employee);

        if(employee instanceof Chef){
            hireChef((Chef) employee);
        }
        if(employee instanceof CookerEmployee){
            cookers.add((CookerEmployee) employee);
        }
        if(employee instanceof KitchenHelper){
            helpers.add((KitchenHelper) employee);
        }
    }

    public void conductAShift() {
        if (chef == null){
            throw new IllegalStateException("Can't start a shift without a chef.");
        }
        helpers.forEach(KitchenHelper::refillIngredients);

        for(var cooker : cookers){
            try{
                cooker.cook();
            } catch (IllegalStateException e){
                System.out.println("Error "+e.getMessage());
            }
        }
    }

    public void hireChef(Chef chef) {
        if(this.chef != null){
            fireChef();
        }
        this.chef = chef;
        this.chef.setStore(this);
    }

    private void fireChef() {
        chef.setStore(null);
        employees.remove(chef);
    }

    @Override
    public Optional<Ingredient> requestIngredient(Ingredient ingredient) {
        for(KitchenHelper helper : helpers){
            Optional<Ingredient> received = helper.giveUpIngredient(ingredient);
            if(!received.isEmpty()){
                return received;
            }
        }
        helpers.forEach(KitchenHelper::yell);
        chef.yell();
        return Optional.empty();
    }
}
