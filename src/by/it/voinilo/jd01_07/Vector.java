package by.it.voinilo.jd01_07;

class Vector extends AbstractVar {

    private double[] value;


    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] arr = strVector.split(",\\s*");
        value = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            value[i] = Double.parseDouble(arr[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double elem : value) {
            sb.append(del).append(elem);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
