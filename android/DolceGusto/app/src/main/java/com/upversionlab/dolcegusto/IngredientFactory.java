package com.upversionlab.dolcegusto;

/**
 * Created by rborcat on 7/12/2016.
 */
public class IngredientFactory {
    private static final String CAPUCCINO_FLAVOR = "Leite";
    private static final int CAPUCCINO_QUANTITY = 100;
    private static final String LUNGO_FLAVOR = "Lungo";
    private static final int LUNGO_QUANTITY = 120;
    private static final String ESPRESSO_FLAVOR = "Espresso";
    private static final int ESPRESSO_QUANTITY = 20;

    public static Ingredient createIngredient(IngredientType ingredientType) {
        switch (ingredientType) {
            case CAPPUCINO:
                return createCapuccino();
            case LUNGO:
                return createLungo();
            case ESPRESSO:
            default:
                return createEspresso();
        }
    }

    private static Ingredient createCapuccino() {
        return new Ingredient(CAPUCCINO_FLAVOR, CAPUCCINO_QUANTITY);
    }

    private static Ingredient createLungo() {
        return new Ingredient(LUNGO_FLAVOR, LUNGO_QUANTITY);
    }

    private static Ingredient createEspresso() {
        return new Ingredient(ESPRESSO_FLAVOR, ESPRESSO_QUANTITY);
    }
}
