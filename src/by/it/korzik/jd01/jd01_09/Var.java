package by.it.korzik.jd01.jd01_09;

public abstract class Var implements Operation{

    static Var createVar(String operand){
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }
        return null;
    }
    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s-%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s*%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s/%s невозможна!\n",this,other);
        return null;
    }
}
