package by.it.galushka.demo.patternBuilderDemo;

abstract class PizzaBuilder {

    Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    void createNewPizzaProduct(){
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();

}
