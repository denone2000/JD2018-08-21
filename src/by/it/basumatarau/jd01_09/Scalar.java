package by.it.basumatarau.jd01_09;

public class Scalar extends Var {
    private double value;

    public double getVal(){
        return this.value;
    }
    @Override
    public void accept(Dispatcher dispatcher) {
        dispatcher.dispatch(this);
    }

    @Override
    public Var add(Var other) {
        Dispatcher dispatcher = new TypeLister();
        other.accept(dispatcher);
        if(((TypeLister) dispatcher).wasAtInstanceOfScalar){
            return new Scalar(this.getVal()+((Scalar)other).getVal());
        }else{
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        Dispatcher dispatcher = new TypeLister();
        other.accept(dispatcher);
        if (((TypeLister) dispatcher).wasAtInstanceOfScalar){
            return new Scalar(this.value - ((Scalar) other).value);
        }else{
            Scalar negScalar = new Scalar(-1);
            return negScalar.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        Dispatcher dispatcher = new TypeLister();
        other.accept(dispatcher);
        if (((TypeLister) dispatcher).wasAtInstanceOfScalar){
            return new Scalar(this.value*((Scalar) other).value);
        }else{
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        Dispatcher dispatcher = new TypeLister();
        other.accept(dispatcher);
        if (((TypeLister) dispatcher).wasAtInstanceOfScalar){
            return new Scalar(this.value/((Scalar) other).value);
        }else {
            return other.mul(this);
        }
    }

    public Scalar(double value){
        this.value = value;
    }
    public Scalar(Scalar scalarObj){
        value = scalarObj.value;
    }
    public Scalar(String strVal){
        value = Double.parseDouble(strVal);
    }
    @Override
    public String toString() {
        return Double.toString(this.value);
    }

}
