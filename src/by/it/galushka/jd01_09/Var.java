package by.it.galushka.jd01_09;

abstract class Var implements Operation {

    static Var createVar(String inputLine) {
        inputLine = inputLine.trim();
        if (inputLine.matches(Patterns.SCALAR)) {
            return new Scalar(inputLine);
        }
        if (inputLine.matches(Patterns.VECTOR)) {
            return new Vector(inputLine);
        }
        if (inputLine.matches(Patterns.MATRIX)) {
            return new Matrix(inputLine);
        }
        else
            return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+" + "+other+" невозможна!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычетания "+this+" - "+other+" невозможна!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this+" * "+other+" невозможна!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+" / "+other+" невозможна!");
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
