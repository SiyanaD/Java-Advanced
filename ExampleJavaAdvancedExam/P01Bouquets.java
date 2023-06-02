package ExampleJavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tulips = scanner.nextLine();
        String daffodils = scanner.nextLine();

        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();

        //пълним tulips в stackTulips
        Arrays.stream(tulips.split(",\\s+")).mapToInt(Integer::parseInt).forEach(n->stackTulips.push(n));
        //пълним daffodils в queueDaffodils
        Arrays.stream(daffodils.split(",\\s+")).mapToInt(Integer::parseInt).forEach(t->queueDaffodils.offer(t));
        int bouquets = 0;//брой букети
        int sum = 0;
        int leftFlowers = 0;//цветята който не са станали на букет


        while (!stackTulips.isEmpty()&&!queueDaffodils.isEmpty()){

            int tulip = stackTulips.peek();
            int daffodil = queueDaffodils.peek();
            sum=tulip+daffodil;
            if (sum==15){
                //правя букет
                bouquets++;
                //премахване на букета
                stackTulips.pop();//премахва посления елемент добавен в стека
                queueDaffodils.poll();//премахва първия елелмент добавен в опашката

            }
            else if (sum>15) {
                stackTulips.pop();//премахваме текущния елемент
                stackTulips.push(tulip-2);

            }
            else if (sum<15) {

                //съхраняваме сумата за по късно
                leftFlowers+=sum;
                stackTulips.pop();//премахва последния елелмент добавен в стека
                queueDaffodils.poll();//премахва пъвия елемент добавен в опашката
            }
        }
        //брой букети
        //брой на цветята който не са образували букет
        int bouquetLeft = leftFlowers/15;
        bouquets+=bouquetLeft;


        if (bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!%n",bouquets);
        }

        else {
            System.out.printf("You failed... You need more %d bouquets.%n",5-bouquets);
        }

    }
}
