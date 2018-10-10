package by.it.galushka.jd01_13;

public class Tmp {
    public static void main(String[] args) {
        try {
            double a = -2;
            double res = Math.sqrt(a);
            String result = String.valueOf(res);
//            System.out.println("double: " + res);
//            System.out.println("String: " + result);
            if (result.equalsIgnoreCase("nan")) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
//            String name = e.getClass().getName();
//            System.out.println(name);
        }
    }
}
//        }
//        boolean counter = false;
//        for (int i = 0; i < 4; counter = true) {
//            try {
//                if (i == 4)
//                    counter = false;
//                while (counter == true) {
//                    double num = scanner.nextDouble();
//                    list.add(num);
//                }
//            } catch (Exception e) {
//                Thread.sleep(100);
//                int sizeList = list.size();
//                for (int j = sizeList-1; j >= 0; j--) {
//                    double res = list.get(j);
//                    System.out.print(res + " ");
//                }
//                i++;
//            }
//        }


//--------------------------------------
//вывод в обратном порядке
//        int sizeList = list.size();
//        for (int i = sizeList-1; i >= 0; i--) {
//            double res = list.get(i);
//            System.out.print(res + " ");
//        }
//--------------------------------------