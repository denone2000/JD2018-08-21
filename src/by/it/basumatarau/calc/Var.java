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

    public static Var createVar(String strOperand) {
        if (strOperand.trim().matches(RegExPatterns.SCALAR)) return new Scalar(strOperand);
        if (strOperand.trim().matches(RegExPatterns.VECTOR)) return new Vector(strOperand);
        if (strOperand.trim().matches(RegExPatterns.MATRIX)) return new Matrix(strOperand);
        if (varHashMap.containsKey(strOperand)){return varHashMap.get(strOperand);}

        System.out.println("operand didn't fall under set of parsing patterns...");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("sum operation: %s + %s is not allowed\n", this, other);
        return null;
    }
    public abstract Var addTo(Scalar scalar);
    public abstract Var addTo(Vector vector);
    public abstract Var addTo(Matrix matrix);

    @Override
    public Var sub(Var other) {
        System.out.printf("sub operation: %s - %s is not allowed\n", this, other);
        return null;
    }
    public abstract Var subAnother(Scalar scalar);
    public abstract Var subAnother(Vector vector);
    public abstract Var subAnother(Matrix matrix);

    @Override
    public Var mul(Var other) {
        System.out.printf("mul operation: %s * %s is not allowed\n", this, other);
        return null;
    }
    public abstract Var mulBy(Scalar scalar);
    public abstract Var mulBy(Vector vector);
    public abstract Var mulBy(Matrix matrix);
    @Override
    public Var div(Var other) {
        System.out.printf("div operation: %s / %s is not allowed\n", this, other);
        return null;
    }
    public abstract Var divBy(Scalar scalar);
    public abstract Var divBy(Vector vector);
    public abstract Var divBy(Matrix matrix);

    @Override
    public String toString() {
        return "Var";
    }
}
