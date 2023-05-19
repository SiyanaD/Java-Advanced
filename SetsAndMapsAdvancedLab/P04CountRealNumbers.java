package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(n->Double.parseDouble(n)).toArray();

        Map<Double,Integer> map = new LinkedHashMap<>();
        for (double n : numbers) {
            if (!map.containsKey(n)){
                map.put(n,1);
            }
            else {
                map.put(n,map.get(n)+1);//map.get(n)-предишната стойност
            }

        }
        for (Double key : map.keySet()) {
            System.out.printf("%.1f -> %d%n",key,map.get(key));//map.get(key) - стойността

        }



    }
}
