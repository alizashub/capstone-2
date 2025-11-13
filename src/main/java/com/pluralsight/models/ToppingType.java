package com.pluralsight.models;

public enum ToppingType {

    // Meats Option with addtional cost
    STEAK("Steak", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    HAM("Ham", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    SALAMI("Salami", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    ROAST_BEEF("Roast Beef", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    CHICKEN("Chicken", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    BACON("Bacon", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    // Cheeses Options with addtional cost
    AMERICAN("America", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    PROVOLONE("Provolone", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    CHEDDAR("Cheddar", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    SWISS("Swiss", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    // Regular
    LETTUCE("Lettuce", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    PEPPERS("Peppers", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    ONIONS("Onions", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    TOMATOES("Tomatoes", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    JALAPENOS("Jalapeños", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    CUCUMBERS("Cucumbers", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    PICKLES("Pickles", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    GUACAMOLE("Guacamole", ToppingCategory.REGULAR, 0, 0, 0,0,0,0),

    MUSHROOMS("Mushrooms", ToppingCategory.REGULAR, 0, 0, 0,0,0,0);

    private final String displayName;
    private final ToppingCategory category;

    // base prices for portion
    private final double price4;
    private final double price8;
    private final double price12;

    // extra portion price
    private final double extra4;
    private final double extra8;
    private final double extra12;


    ToppingType(String displayName, ToppingCategory category, double price4, double price8, double price12, double extra4, double extra8, double extra12) {
        this.displayName = displayName;
        this.category = category;
        this.price4 = price4;
        this.price8 = price8;
        this.price12 = price12;
        this.extra4 = extra4;
        this.extra8 = extra8;
        this.extra12 = extra12;
    }

    public double getBasePrice(SandwichSize size) {
        return switch (size) {
            case FOUR -> price4;
            case EIGHT -> price8;
            case TWELVE -> price12;
        };
    }

    public double getExtraPrice(SandwichSize size){
        return switch (size) {
            case FOUR -> extra4;
            case EIGHT -> extra8;
            case TWELVE -> extra12;
        };
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isMeat() {
        return category == ToppingCategory.MEAT;
    }

    public boolean isCheese() {
        return category == ToppingCategory.CHEESE;
    }

    public boolean isRegular() {
        return category == ToppingCategory.REGULAR;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
