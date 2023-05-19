package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(s->Integer.parseInt(s)).
                boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(n->Integer.parseInt(n)).
                boxed().collect(Collectors.toCollection(LinkedHashSet::new));


        for (int i = 0; i <=50 ; i++) {
            int firstPlayerNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstPlayerNumber);

            int secondPlayerNumber =  secondPlayer.iterator().next();
            secondPlayer.remove(secondPlayerNumber);

            if (firstPlayerNumber>secondPlayerNumber){
                firstPlayer.add(firstPlayerNumber);
                firstPlayer.add(secondPlayerNumber);
            } else if (secondPlayerNumber>firstPlayerNumber) {
                secondPlayer.add(secondPlayerNumber);
                secondPlayer.add(firstPlayerNumber);
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;

            }

        }
        if (secondPlayer.size()>firstPlayer.size()){
            System.out.println("Second player win!");
        } else if (secondPlayer.size()<firstPlayer.size()) {
            System.out.println("First player win!");

        }
        else {
            System.out.println("Draw!");
        }
    }

}
