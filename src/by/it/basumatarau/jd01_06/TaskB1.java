package by.it.basumatarau.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        pinterTaskB1(Poem.text);
    }
    static void pinterTaskB1(String text){
        StringBuilder buff = new StringBuilder();

        boolean lastCharIsAlapha = true;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (lastCharIsAlapha && Character.isAlphabetic(ch)){
                buff.append(ch);
            }else if (!lastCharIsAlapha && Character.isAlphabetic(ch)){
                buff.append(" ").append(ch);
                lastCharIsAlapha = true;
            } else lastCharIsAlapha=false;
        }

        String[] heap = new String(buff).split(" ");
        for (int i = 0; i < heap.length; i++) {
            if(!"ауоыиэяюёе".contains(""+heap[i].toLowerCase().charAt(0))&&
                    "ауоыиэяюёе".contains(""+heap[i].toLowerCase().charAt(heap[i].length()-1))) {
                System.out.println(heap[i]);
            }
        }
    }
}
