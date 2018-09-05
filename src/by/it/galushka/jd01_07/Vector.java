package by.it.galushka.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends AbstractVar {

    private double[] value = {};

    Vector(double[] value) {
        this.value = value;
    }

    Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        Pattern compile = Pattern.compile("[0-9]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String group = matcher.group();
            double convertToDouble = Double.parseDouble(group);
            this.value = Arrays.copyOf(this.value, this.value.length+1);
            this.value[this.value.length-1] = convertToDouble;
        }
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length-1; i++) {
            String delimiter = ", ";
            sb.append(value[i] + delimiter);
        }
        sb.append(value[value.length-1]).append("}");
        return sb.toString();
    }
}
