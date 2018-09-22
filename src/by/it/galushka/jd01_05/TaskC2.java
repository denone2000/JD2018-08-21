package by.it.galushka.jd01_05;

public class TaskC2 {
    public static int[] getArrayA(int[] arrayA) {
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (Math.random() * 450 + 103);
        }
        return arrayA;
    }

    public static void sort(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex, array);
    }

    private static void doSort(int start, int end, int[] array) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, array);
        doSort(cur + 1, end, array);
    }

    public static int[] getArrayB(int[] arrayA) {
        int tmp = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if ((arrayA[i] * 10 / 100) > i) {
                tmp++;
            }
        }
        int[] arrayB = new int[tmp];
        tmp = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if ((arrayA[i] * 10 / 100) > i) {
                arrayB[tmp] = arrayA[i];
                tmp++;
            }
        }
        return arrayB;
    }

    public static void printf(int[] array, int colomnCount, String nameIndex) {
        String leftTop = "┏━━━━━━━━━━━━━┳";
        String midleTop = "━━━━━━━━━━━━━┳";
        String rightTop = "━━━━━━━━━━━━━┓%n";
        String leftMidle = "┣━━━━━━━━━━━━━╋";
        String midleMidle = "━━━━━━━━━━━━━╋";
        String rightMidle = "━━━━━━━━━━━━━┫%n";
        String leftBottom = "┗━━━━━━━━━━━━━┻";
        String midleBottom = "━━━━━━━━━━━━━┻";
        String rightBottom = "━━━━━━━━━━━━━┛%n";
        String name = nameIndex;
        int min = 0;
        int col = colomnCount;
        int max = array.length - 1;
        int lastRow = (array.length)%col;
        for (int i = 0; i < array.length; i++) {

            // Первый ряд и верхняя граница таблицы
            if (i == min) {
                for (int j = min; j < col; j++) {
                    if (j == min) {
                        System.out.printf(leftTop);
                    } else if (j == col - 1) {
                        System.out.printf(rightTop);
                        System.out.print("┃");
                    } else {
                        System.out.printf(midleTop);
                    }
                }
                for (int j = 0; j < col; j++) {
                    System.out.printf(" %s[%-2d]=%3d ┃", name, j, array[j]);
                    if ((j + 1) % col == 0) {
                        System.out.println();
                        i++;
                    }
                }
            }

            // Ряды между первым и последним
            if (i > col -1 && i < max - lastRow-1) {
                for (int j = 0; j < col; j++) {
                    if (j == 0) {
                        System.out.printf(leftMidle);
                    } else if ( j == col-1) {
                        System.out.printf(rightMidle);
                        System.out.printf("┃");
                    } else {
                        System.out.printf(midleMidle);
                    }
                }
                for (int j = 0; j < col; j++) {
                    System.out.printf(" %s[%-2d]=%3d ┃", name, i, array[i]);
                    i++;
                    if ((j + 1) % col == 0) {
                        System.out.println();
                    }
                }
                i--;
            }

            // Последний ряд
            if (i + lastRow-1 == max) {
                for (int k = min; k < min + col; k++) {
                    if (k == min) {
                        System.out.printf(leftMidle);
                    } else if (k == min + col - 1) {
                        System.out.printf(rightMidle);
                        System.out.print("┃");
                    } else {
                        System.out.printf(midleMidle);
                    }
                }
                for (int j = i; j <= max; j++) {
                    System.out.printf(" %s[%-2d]=%3d ┃", name, j, array[j]);
                    if (j == max) {
                        System.out.println();
                    }
                }
            }
        }

        // Нижняя граница таблицы
        for (int j = 0; j < col; j++) {
            if (j == 0) {
                System.out.printf(leftBottom);
            } else if (j == col - 1){
                System.out.printf(rightBottom);
            } else {
                System.out.printf(midleBottom);
            }
        }
    }

    public static void printElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+":"+array[i]+" ");
            if ((i+1)%5 == 0) {
                System.out.println();
            }
        }
        System.out.println(array.length);
        System.out.println("\n");
    }
}
