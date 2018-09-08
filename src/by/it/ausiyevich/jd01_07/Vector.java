package by.it.ausiyevich.jd01_07;

public class Vector extends AbstractVar {
    private double[] value;

    public Vector(String strVector) {
        strVector = strVector.replace("{", "").replace("}", "");
        String[] strArray = strVector.split("(,\\s*)");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    public Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = value[i];
        }
    }

    public Vector(Vector anotherVect) {
        this.value = new double[anotherVect.value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = anotherVect.value[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double currentVal : value) {
            result.append(delimiter).append(currentVal);
            delimiter = ", ";
        }
        result.append("}");
        return result.toString();
    }
}
