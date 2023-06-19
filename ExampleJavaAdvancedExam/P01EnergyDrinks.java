package ExampleJavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksQueue= new ArrayDeque<>();
        int stamatMaxCaffeine = 0;
        int caffeineInDrinks = 0;

        //добавяме 34, 2, 3 - caffeineStack
        Arrays.stream(scanner.nextLine().split(",\\s+")).
                forEach(c->caffeineStack.push(Integer.parseInt(c)));

        //добавяме 40, 100, 250 - energyDrinksQueue
        Arrays.stream(scanner.nextLine().split(",\\s+")).
                forEach(e->energyDrinksQueue.offer(Integer.parseInt(e)));


        while (!caffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()){

            //To calculate the caffeine in the drink take the last milligrams of caffeinе
            // and the first energy drink, and multiply them.

            int firstEnergyDrink = energyDrinksQueue.poll();
            int lastMilOfCaffeine = caffeineStack.pop();
            caffeineInDrinks=lastMilOfCaffeine*firstEnergyDrink;
            //•	If the sum of the caffeine in the drink and the caffeine that
            // Stamat drank doesn't exceed 300 milligrams, remove both the milligrams
            // of caffeinе and the drink from their sequences.
            // Also, add the caffeine to Stamat's total caffeine
            if (stamatMaxCaffeine+caffeineInDrinks<=300){
                stamatMaxCaffeine+=caffeineInDrinks;
            }
            //•	If Stamat is about to exceed his maximum caffeine per night,
            // do not add the caffeine to Stamat’s total caffeine.
            else {
                // Remove the milligrams of caffeinе
                // and move the drink to the end of the sequence.
                energyDrinksQueue.offer(firstEnergyDrink);
                // Also, reduce the current caffeine that
                // Stamat has taken by 30 (Note: Stamat's caffeine cannot go below 0).
                stamatMaxCaffeine-=30;
                if (stamatMaxCaffeine<0){
                    stamatMaxCaffeine=0;
                }
            }
        }
        //Stop calculating when you are out of drinks or milligrams of caffeine.
        if (energyDrinksQueue.isEmpty()){
            //	"At least Stamat wasn't exceeding the maximum caffeine."
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        else {
            //	"Drinks left: { remaining drinks separated by ", " }"
            System.out.print("Drinks left: ");
            //на края на реда не слага ", "->
            //String result = drinks.toString().replaceAll("[\\[\\]]", "");
            //на края на реда не слага ", "->
            String result = energyDrinksQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.print(result);
            System.out.println();
        }
        //o	"Stamat is going to sleep with { current caffeine } mg caffeine."
        System.out.printf("Stamat is going to sleep with %d mg caffeine.",stamatMaxCaffeine);
    }
}
