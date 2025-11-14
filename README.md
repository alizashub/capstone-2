# 🥪 Aliza's Deli App

A simple, menu-driven **Java console application** that lets users build a complete deli order — sandwiches, toppings, sauces, drinks, chips, and sides — and automatically saves an **itemized receipt** as a `.txt` file.

---

## ✨ Features

### 🥙 Custom Sandwich Builder
- Choose sandwich size:
    - **4"**, **8"**, **12"**
- Select bread type
- Toasted or not toasted
- Add toppings grouped into:
    1. **Regular Toppings** (free)
    2. **Premium Toppings**
        - **Meat**
        - **Cheese**
- Optional **extra portion** for premium toppings
- Add unlimited **sauces**
- Add unlimited **sides**

---

### 🥤 Drinks
- Choose **size** (Small, Medium, Large)
- Choose **flavour**

---

### 🍟 Chips
- Select chip type (Lays, Doritos, etc.)

---

### 🍜 Sides
- Choose from available sides (Au Jus, Sauce)

---

## 💰 Pricing Rules
- Sandwich base price comes from selected **size**
- Meat & cheese toppings have size-based pricing:
    - 4"
    - 8"
    - 12"
- **Extra portion** adds additional cost
- Drinks have fixed prices per size
- Regular toppings, sauces, and sides are free

---

## 🧾 Receipt Generation
Each order generates a detailed receipt including:

- Itemized list of every menu item
- Full sandwich breakdown:
    - toppings (categorized)
    - sauces
    - extra portions
    - per-topping cost
- Total order price
- Automatically saved to: src/main/resources/receipts/<timestamp>.txt

## 🧩 Interesting Code Example

```java

// using enumeration
public enum ToppingType {

    // Meats Option with addtional cost
    STEAK("Steak", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    HAM("Ham", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    SALAMI("Salami", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    ROAST_BEEF("Roast Beef", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    CHICKEN("Chicken", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    BACON("Bacon", ToppingCategory.MEAT, 1.00, 2.00, 3.00,0.50,1.00,1.50),

    // Cheeses Options with addtional cost
    AMERICAN("America Cheese", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    PROVOLONE("Provolone Cheese", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    CHEDDAR("Cheddar Cheese", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

    SWISS("Swiss Cheese", ToppingCategory.CHEESE, 0.75, 1.50, 2.25,0.30,0.60,0.90),

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
         switch (size) {
            case FOUR :
                return price4;
             case EIGHT :
                 return price8;
             case TWELVE :
                 return price12;
             default :
                 return 0;
        }
    }

    public double getExtraPrice(SandwichSize size){
         switch (size) {
             case FOUR :
                 return extra4;
             case EIGHT :
                 return extra8;
             case TWELVE :
                 return extra12;
             default:
                 return 0;
        }
    }
    
```java
   
   
   
# 📂 Project Structure
src/
 └── main/
     ├── java/
     │    ├── com.pluralsight.models/     # All data models
     │    ├── com.pluralsight.ui/         # UserInterface class
     │    └── com.pluralsight.util/       # ReceiptWriter
     └── resources/
          └── receipts/                   # Auto-generated receipt files