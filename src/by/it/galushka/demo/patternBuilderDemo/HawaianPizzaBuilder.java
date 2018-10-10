package by.it.galushka.demo.patternBuilderDemo;

public class HawaianPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("bacon + pineapple");
    }
}
