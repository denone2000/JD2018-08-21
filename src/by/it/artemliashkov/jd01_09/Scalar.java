package by.it.artemliashkov.jd01_09;

class Scalar extends Var {
    public double getValue;
    private double value;
    Scalar(double value){
        this.value=value;
    }

    public double getValue() {
        return this.value;
    }

    Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }
    Scalar(String strScala) {
        this.value = Double.parseDouble(strScala);
    }

    @Override
    public String toString(){
        return Double.toString(this.value);
    }


    @Override
    public Var add(Var other) {
        if(other instanceof Scalar)
        {
            double result=this.value+((Scalar)other).value;
            return new Scalar(result);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar)
        {
            double result=this.value-((Scalar)other).value;
            return new Scalar(result);
        }
        else
        {
            Var minus=new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }


    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar)
        {
            double result=this.value*((Scalar)other).value;
            return new Scalar(result);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar)
        {
            double result=this.value/((Scalar)other).value;
            return new Scalar(result);
        }
        else
            return super.div(this);
    }
}
