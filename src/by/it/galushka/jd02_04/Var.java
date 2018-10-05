package by.it.galushka.jd02_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Var implements Operation {

    private static Res res = Res.INSTANCE;

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static String printVar() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Var>> entries = Var.vars.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    static Var createVar(String inputLine) throws CalcException {
        inputLine = inputLine.trim();
        if (inputLine.matches(Patterns.SCALAR)) {
            return new Scalar(inputLine);
        } else if (inputLine.matches(Patterns.VECTOR)) {
            return new Vector(inputLine);
        } else if (inputLine.matches(Patterns.MATRIX)) {
            return new Matrix(inputLine);
        } else if (vars.containsKey(inputLine))
            return vars.get(inputLine);
        throw new CalcException(res.get(Messages.MSG_ERROR_UN_TO_CREATE) + " " + inputLine);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.MSG_ERROR_IMPOSSIBLE) + " " + this + " + " + other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.MSG_ERROR_IMPOSSIBLE) + " " + this + " + " + other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.MSG_ERROR_IMPOSSIBLE) + " " + this + " + " + other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.MSG_ERROR_IMPOSSIBLE) + " " + this + " + " + other);
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
