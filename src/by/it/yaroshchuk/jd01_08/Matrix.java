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
        /*Pattern pattern = Pattern.compile("(},)*");
        String[] strArray = pattern.split(str);
        pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < strArray.length; i++) {
            Matcher matcher = pattern.matcher(strArray[i]);
            while(matcher.find()){
                sb.append(matcher.group());
                sb.append(" ");
                length++;
            }
        }
        String [][] strValueArray*/
        /*String regex = "([0-9]*[.])?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        String strArray[] = str.split("},");
        StringBuilder sb = new StringBuilder();
        String[] strBuffer = new String[];
        int lengthValue = 0;
        for (int i = 0; i < strArray.length; i++) {

            Matcher matcher = pattern.matcher(strArray[i]);
            while (matcher.find()) {
                sb.append(matcher.group());
                sb.append(" ");
            }
            String strSb = new String(sb);
            String[] strBuffer = strSb.trim().split(" ");
            String[][] strValueArray = new String [strArray.length][strBuffer.length];
            lengthValue = strBuffer.length;
            for (int j = 0; j < strBuffer.length; j++) {
                strValueArray[i][j] = strBuffer[i];
            }
            sb.delete(0, sb.length()-1);
        }
        value = new double[strArray.length] [lengthValue];
        for (int j = 0; j < lengthValue; j++) {
            value[i][j] = Double.parseDouble(strBuffer[i]);
        }*/
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
