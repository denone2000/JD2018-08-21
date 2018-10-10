package by.it.galushka.demo.patternBuilderDemo;

class Waiter {

    private PizzaBuilder pizzaBuilder;

    void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
