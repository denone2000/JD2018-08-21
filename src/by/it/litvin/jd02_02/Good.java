package by.it.litvin.jd02_02;

public class Good {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    Good(String name) {
        this.name = name;
    }
}
