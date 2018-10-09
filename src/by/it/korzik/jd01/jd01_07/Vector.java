package by.it.korzik.jd01.jd01_07;

public class Vector extends AbstractVar {
    private double[] value;
    Vector(double[] value){
        this.value=value;
    }
    Vector(Vector vector){
        value=vector.value;
    }
    Vector(String strVec){
        strVec=strVec.replace('{',' ').replace('}',' ').trim();
        String[] strArr= strVec.split(",\\s*");
        value=new double[strArr.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strArr[i]);
        }

    }
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimit="";
        for (double v : value) {
            sb.append(delimit).append(v);
            delimit=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
