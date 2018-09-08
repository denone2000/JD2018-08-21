package by.it.akhmelev.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String[] parts = Poem.text.split("[.!?]+");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts.length-1-i; j++) {
                if (parts[j].length()>parts[j+1].length()){
                    String tmp=parts[j];
                    parts[j]=parts[j+1];
                    parts[j+1]=tmp;
                }
            }
        }
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
