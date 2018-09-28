package by.it.voinilo.jd01.jd01_08;

abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("операция сложения"+this + "+" +other +"невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("операция вычитания"+this + "-" +other +"невозможна");

        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("операция умножения"+this + "*" +other +"невозможна");

        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("операция деления"+this + "/" +other +"невозможна");

        return null;
    }

    @Override
    public String toString() {

        return "'это класс AbstractVar{}";


    }
}
