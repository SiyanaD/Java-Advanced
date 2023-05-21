package SetsAndMapsAdvancedExercises;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")){
            String [] data = input.split(": ");
            String name = data[0];
            String cards = data[1];//"2C, 4H, 9H, AS, QS"
            String [] separateCards = cards.split(",\\s+");//["2C", "4H", "9H", "AS", QS]

            //1. съхраняваме картите в set
            Set<String> cardsSet = new LinkedHashSet<>();

            cardsSet.addAll(Arrays.asList(separateCards));

            //2. добавяне в мап
            //ако не сме го записали
            if (!map.containsKey(name)){
                map.put(name,cardsSet);
            }
            //ако сме го записали
            else{
                //взимаме до момента картите му и към тях добавяме новите
                Set<String> currentCards = map.get(name);
                //към текущите карти добавям новите изтеглени
                currentCards.addAll(cardsSet);// Set<String> cardsSet = new LinkedHashSet<>(); -новите изтеглени карти
                map.put(name,currentCards);
            }
            input= scanner.nextLine();
        }

        //запис: име на играч -> списък с картите
        map.entrySet().forEach(entry->{
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n",name,points);
        });


    }

    private static int getCardsPoints(Set<String> cards) {
        //всяка един символ -> стойност
        Map<Character,Integer> symbolsValues = getSymbolsValues();
        int sumPoints = 0;
        //списък с карти: "2C", "4H", "9H", "AS", "QS"
        //всяка една карта -> намираме точките за картата -> доабвяме точките на картата към сумата от всички точки
        for (String card : cards) {
            //card = "2C" -> "[сила][тип]"
            //сила: 2(2), 3(3),4(4), 5(5), 6(6), 7 (7), 8 (8), 9(9), 10(10), J(11), D(12), K(13), A(14)
            //тип: S -> 4, H-> 3, D -> 2, C -> 1
            //точките=силата * типа;

            int points = 0;
            if (card.startsWith("10")){
                //картата е "10C"
                //сила = 10
                char type = card.charAt(2);
                points = 10*symbolsValues.get(type);
            }
            else {
                //"4H"
                char power = card.charAt(0);
                char type = card.charAt(1);
                points=symbolsValues.get(power)*symbolsValues.get(type);
            }
            sumPoints+=points;
        }
        //знаем сумата от точките за всички карти
        return sumPoints;

    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character,Integer> characterValues = new HashMap<>();
        characterValues.put('2',2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;

    }
}
