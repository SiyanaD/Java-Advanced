package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //alphabetical (lexicographical) order - TreeMap

        Map<Character,Integer> map = new TreeMap<>();

        String data = scanner.nextLine();
        for (int i = 0; i <data.length() ; i++) {
            char symbol = data.charAt(i);//взимаме символите
            if (!map.containsKey(symbol)){
                map.put(symbol,1);//1 добавяме стойността на symbol
            }else {
                map.put(symbol,map.get(symbol)+1);//map.get(symbol) - ти дава value на предния елемент
            }

        }

        map.forEach((k,v)-> System.out.printf("%c: %d time/s%n",k,v));

    }
}
