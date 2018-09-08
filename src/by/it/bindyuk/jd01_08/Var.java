package by.it.bindyuk.jd01_08;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления невозможна");
        return null;
    }
}