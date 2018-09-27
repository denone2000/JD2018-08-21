package by.it.voinilo.jd01.jd01_09;

class Var implements Operation{

    public static Var createVar(String strVar) {

        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        //TODO add exception create vars
        return  null;
    }

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
