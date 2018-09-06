package by.it.basumatarau.jd01_08;

public class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.printf("sum operation: %s + %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("sub operation: %s - %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("mul operation: %s * %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("div operation: %s / %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Var";
    }
}
