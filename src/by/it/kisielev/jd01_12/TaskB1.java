package by.it.kisielev.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {

        Map<String, Integer> map=new TreeMap<>();

        Scanner scanner=new Scanner(System.in);
        // перебор слов
        while(true){
            String line=scanner.nextLine();
            if (line.equals("end"))
                break;
            String[] words = line.split("[^a-zA-Z']+");
            //проверка слова в карте
            for (String word : words) {
                if (map.containsKey(word)){
                    int count=map.get(word);
                    map.put(word,count+1);
                }
                else
                    map.put(word,1);
            }
            System.out.println(map);
        }
        //перебор карты
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
       //     Map.Entry<String, Integer> pair=
        }

    }
}
