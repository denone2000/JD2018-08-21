package by.it.korolchuk.jd01_07;



public class Vector extends AbstractVar {

    private double[] value;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double currentValue : value) {
            result.append(delimiter).append(currentValue);
            delimiter = ", ";

        }
        result.append("}");
        return result.toString();
    }

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        //{1,2,3,4,5}
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strVector.split(",\\s*");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }
}

