package by.it.ausiyevich.jd01_09;

class Var implements Operation {
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

    static Var createVar(String strVar) {
        //2 {1,2,3,4} {{1,2},{3,4}}
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        //TODO add exception create vars
        return null;

    }
}