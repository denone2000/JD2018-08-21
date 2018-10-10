package by.it.galushka.demo.patternBuilderDemo;

public class Pizza {

    private String dough = "";
    private String sauce = "";
    private String topping = "";

    void setDough(String dough){
        this.dough = dough;
    }

    void setSauce(String sauce){
        this.sauce = sauce;
    }

    void setTopping(String topping){
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
