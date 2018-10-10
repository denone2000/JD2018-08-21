package by.it.galushka.demo.patternBuilderDemo;

public class RunnerBuilder {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder pizzaBuilder = Math.random() > 0.5 ? new HawaianPizzaBuilder() : new SpicyPizzaBuilder();
        waiter.setPizzaBuilder(pizzaBuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println(pizza);
    }
}
