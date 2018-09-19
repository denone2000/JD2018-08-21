package by.it.basumatarau.calc;

import java.util.*;

public abstract class Var implements Operation {
    private static HashMap<String, Var> varHashMap = new HashMap<>();
    static Var saveVar(String name, Var var){
        varHashMap.put(name, var);
        return var;
    }
    static String sortvar(){
        StringBuilder sb = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet<>(varHashMap.keySet());
        Iterator<String> entryIterator = treeSet.iterator();
        String key;
        while(entryIterator.hasNext()){
            sb.append(key=entryIterator.next()).append(varHashMap.get(key)).append("\n");
        }
        return sb.toString();
    }
    static String printVar(){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Var>> entries = Var.varHashMap.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = entries.iterator();
        while(iterator.hasNext()){
            sb.append(iterator.next().toString()).append("\n");
        }
        return sb.toString();
    }

    public static Var createVar(String strOperand) throws CalcException{
        if (strOperand.trim().matches(RegExPatterns.SCALAR)) return new Scalar(strOperand);
        if (strOperand.trim().matches(RegExPatterns.VECTOR)) return new Vector(strOperand);
        if (strOperand.trim().matches(RegExPatterns.MATRIX)) return new Matrix(strOperand);
        if (varHashMap.containsKey(strOperand)){return varHashMap.get(strOperand);}

        throw new CalcException("operand didn't fall under set of parsing patterns...");
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(String.format("sum operation: %s + %s is not allowed\n", this, other));
    }
    public abstract Var addTo(Scalar scalar) throws CalcException;
    public abstract Var addTo(Vector vector) throws CalcException;
    public abstract Var addTo(Matrix matrix) throws CalcException;

    @Override
    public Var sub(Var other)  throws CalcException{
        throw new CalcException(String.format("sub operation: %s - %s is not allowed\n", other, this));
    }
    public abstract Var subAnother(Scalar scalar) throws CalcException;
    public abstract Var subAnother(Vector vector) throws CalcException;
    public abstract Var subAnother(Matrix matrix) throws CalcException;

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(String.format("mul operation: %s * %s is not allowed\n", this, other));

    }
    public abstract Var mulBy(Scalar scalar) throws CalcException;
    public abstract Var mulBy(Vector vector) throws CalcException;
    public abstract Var mulBy(Matrix matrix) throws CalcException;
    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(String.format("div operation: %s / %s is not allowed\n",  other, this));
    }
    public abstract Var divBy(Scalar scalar) throws CalcException;
    public abstract Var divBy(Vector vector) throws CalcException;
    public abstract Var divBy(Matrix matrix) throws CalcException;

    @Override
    public String toString() {
        return "Var";
    }
}
