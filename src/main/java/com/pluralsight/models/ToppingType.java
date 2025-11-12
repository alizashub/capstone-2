package com.pluralsight.models;

public enum ToppingType {
    // Meats
    STEAK("Steak", "MEAT", 1.00, 2.00, 3.00),

    HAM("Ham", "MEAT", 1.00, 2.00, 3.00),

    SALAMI("Salami", "MEAT", 1.00, 2.00, 3.00),

    ROAST_BEEF("Roast Beef", "MEAT", 1.00, 2.00, 3.00),

    CHICKEN("Chicken", "MEAT", 1.00, 2.00, 3.00),

    BACON("Bacon", "MEAT", 1.00, 2.00, 3.00),

    // Cheeses
    AMERICAN("America", "CHEESE", 0.75, 1.50, 2.25),

    PROVOLONE("Provolone", "CHEESE", 0.75, 1.50, 2.25),

    CHEDDAR("Cheddar", "CHEESE", 0.75, 1.50, 2.25),

    SWISS("Swiss", "CHEESE", 0.75, 1.50, 2.25),

    // Regular
    LETTUCE("Lettuce", "Regular", 0, 0, 0),

    PEPPERS("Peppers", "Regular", 0, 0, 0),

    ONIONS("Onions", "Regular", 0, 0, 0),

    TOMATOES("Tomatoes", "Regular", 0, 0, 0),

    JALAPENOS("Jalapeños", "Regular", 0, 0, 0),

    CUCUMBERS("Cucumbers", "Regular", 0, 0, 0),

    PICKLES("Pickles", "Regular", 0, 0, 0),

    GUACAMOLE("Guacamole", "Regular", 0, 0, 0),

    MUSHROOMS("Mushrooms", "Regular", 0, 0, 0);

    private final String displayName;
    private final String category;
    private final double price4;
    private final double price8;
    private final double price12;


    ToppingType(String displayName, String category, double price4, double price8, double price12) {
        this.displayName = displayName;
        this.category = category;
        this.price4 = price4;
        this.price8 = price8;
        this.price12 = price12;
    }

    public double getBasePrice(SandwichSize size) {
        return switch (size) {
            case FOUR -> price4;
            case EIGHT -> price8;
            case TWELVE -> price12;
        };
    }

    public String getCategory() {
        return category;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
