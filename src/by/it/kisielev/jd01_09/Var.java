package by.it.kisielev.jd01_09;

class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Днанный пример не возможен");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Днанный пример не возможен");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Днанный пример не возможен");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Днанный пример не возможен");
        return null;
    }

    static Var createVar(String operation) {
        operation=operation.trim().replace("\\s+","");
        if (operation.matches(Patterns.SCALAR)) return new Scalar(operation);
        if (operation.matches(Patterns.VECTOR)) return new Vector(operation);
        if (operation.matches(Patterns.MATRIX)) return new Matrix(operation);
        //TODO add exception
        return null;

    }
}
