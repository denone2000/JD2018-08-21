package by.it.artemliashkov.jd01_08;

public class Matrix extends Var {
    private double[][] value;
    public Matrix(double[][] value)
    {
        this.value=new double[value.length][value.length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j <this.value.length ; j++) {
                this.value[i][j]=value[i][j];
            }

        }
    }

    public Matrix(Matrix OtherMatrix)
    {
        this.value=new double[OtherMatrix.value.length][OtherMatrix.value.length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j <this.value.length ; j++) {
                this.value[i][j]=OtherMatrix.value[i][j];
            }

        }
    }

    Matrix(String strMatrix) {
        String[] arrayString = strMatrix.split("},");
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayString[i].replace("{", "").replace("}", "");
        }
        String[] numberElementInRow = arrayString[0].split(",");
        value = new double[arrayString.length][numberElementInRow.length];
        for (int i = 0; i < arrayString.length; i++) {
            String[] arrayMatrix = arrayString[i].split(",");
            for (int j = 0; j < arrayMatrix.length; j++) {
                value[i][j] = Double.parseDouble(arrayMatrix[j]);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiterI = "{";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiterI);
            String delimiterJ = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiterJ).append(value[i][j]);
                delimiterJ = ", ";
            }
            delimiterI = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }



}
