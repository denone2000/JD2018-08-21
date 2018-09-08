package by.it.yaroshchuk.jd01_08;

class Matrix extends Var {

    private double value [][];

    Matrix (Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (double[][] value){
        this.value = value;
    }

    Matrix (String str){

    }

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter ="";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if(j + 1 < value[0].length)
                    sb.append(", ");
            }
            sb.append("}");
            if(i + 1 <  value.length)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
