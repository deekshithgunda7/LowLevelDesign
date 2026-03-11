interface pizza {
    String getDescription();
    double getCost();
}

class margheritaPizza implements pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 8.0;
    }
}

abstract class pizzaDecorator implements pizza {
    protected pizza decoratedPizza;

    public pizzaDecorator(pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost();
    }
}

class extraCheese extends pizzaDecorator {
    public extraCheese(pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 1.5;
    }
}

class pepperoni extends pizzaDecorator {
    public pepperoni(pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 2.0;
    }
}

class stuffedCrust extends pizzaDecorator {
    public stuffedCrust(pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " + Stuffed Crust";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 3.0;
    }
}

 class PizzaExample {
    public static void main(String[] args) {
        pizza myPizza = new margheritaPizza();
        System.out.println(myPizza.getDescription() + " costs $" + myPizza.getCost());

        myPizza = new extraCheese(myPizza);
        System.out.println(myPizza.getDescription() + " costs $" + myPizza.getCost());

        myPizza = new pepperoni(myPizza);
        System.out.println(myPizza.getDescription() + " costs $" + myPizza.getCost());

        myPizza = new stuffedCrust(myPizza);
        System.out.println(myPizza.getDescription() + " costs $" + myPizza.getCost());
    }
}