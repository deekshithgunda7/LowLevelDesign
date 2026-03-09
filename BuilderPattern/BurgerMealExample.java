import java.util.Arrays;
import java.util.List;

class BurgerMeal{

    //Required parameters
    private final String bunType;
    private final String patty;

    //Optional parameters
    private final boolean hasCheese;
    private final String sides;
    private final String drink;
    private final List<String> toppings;


    private BurgerMeal(BurgerMealBuilder builder) {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.sides = builder.sides;
        this.drink = builder.drink;
        this.toppings = builder.toppings;
    }

    public static class BurgerMealBuilder {
        //Required parameters
        private final String bunType;
        private final String patty;

        //Optional parameters
        private boolean hasCheese;
        private String sides;
        private String drink;
        private List<String> toppings;

        public BurgerMealBuilder(String bunType, String patty) {
            this.bunType = bunType;
            this.patty = patty;
        }

        public BurgerMealBuilder withCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        public BurgerMealBuilder withSides(String sides) {
            this.sides = sides;
            return this;
        }

        public BurgerMealBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public BurgerMealBuilder withToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }
    }

    @Override
    public String toString() {
        return "BurgerMeal{" +
                "bunType='" + bunType + '\'' +
                ", patty='" + patty + '\'' +
                ", hasCheese=" + hasCheese +
                ", sides='" + sides + '\'' +
                ", drink='" + drink + '\'' +
                ", toppings=" + toppings +
                '}';
    }

}

public class BurgerMealExample {
    public static void main(String[] args) {
        BurgerMeal burgerMeal = new BurgerMeal.BurgerMealBuilder("Whole Wheat", "Chicken")
                .withCheese(true)
                .withSides("Fries")
                .withDrink("Coke")
                .withToppings(Arrays.asList("Lettuce", "Tomato", "Onion"))
                .build();

        BurgerMeal plainBurgerMeal = new BurgerMeal.BurgerMealBuilder("White", "Beef").build();

        System.out.println(burgerMeal);
        System.out.println(plainBurgerMeal);
    }
}