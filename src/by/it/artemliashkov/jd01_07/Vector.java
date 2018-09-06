package by.it.artemliashkov.jd01_07;

public class Vector extends AbstractVar {
    private double[] value;
    public Vector(double[] value)
    {
        this.value=new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i]=value[i];

        }
    }

    public Vector(Vector otherVector)
    {
        this.value=new double[otherVector.value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i]=otherVector.value[i];

        }
    }


    public  Vector(String strVector)
    {
        strVector=strVector.replace('{',' ').replace('}',' ').trim();
        String[] strArray=strVector.split(",\\s*");
        value=new double[strArray.length];
        for (int i = 0; i <strArray.length ; i++) {
            value[i]=Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString(){
        StringBuilder result=new StringBuilder("{");
        String delimiter="";
        for (double currectValue : value) {
            result.append(delimiter).append(currectValue);
            delimiter=", ";
        }
        result.append("}");
        return result.toString();
    }
}
