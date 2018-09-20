package by.it.litvin.jd01_12;


import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        List<String> list = new ArrayList<>();
        while (!(str = scan.next()).equals("end")) {
            scan.useDelimiter("[^A-z']+");
            list.add(str);
        }
        Set<String> words = new HashSet<>(list);
        int frq = 0;
        Iterator<String> iterator = words.iterator();

        while(iterator.hasNext()){
            String s= iterator.next();
            for (int i = 0; i <list.size() ; i++) {
                if (s.equals(list.get(i)))
                    frq++;

            }
            System.out.println(s+"="+frq);
            frq=0;
        }
    }
}