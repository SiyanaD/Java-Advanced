package ExampleJavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> boxMaterialStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(b->boxMaterialStack.push(Integer.parseInt(b)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(m->magicQueue.offer(Integer.parseInt(m)));

        int multiply = 0;
        int sum = 0;


        Map<String,Integer> mapPresentMagicNeeded = new TreeMap<>();
        mapPresentMagicNeeded.put("Doll",0);
        mapPresentMagicNeeded.put("Wooden train",0);
        mapPresentMagicNeeded.put("Teddy bear",0);
        mapPresentMagicNeeded.put("Bicycle",0);
        //Doll
        //Wooden train
        //Teddy bear
        //Bicycle

        while (!boxMaterialStack.isEmpty()&&!magicQueue.isEmpty()) {

            int firstMaterial = boxMaterialStack.peek();
            int firstMagic = magicQueue.peek();
            multiply = firstMaterial * firstMagic;

            if (multiply == 150) {
                boxMaterialStack.pop();
                magicQueue.poll();
                mapPresentMagicNeeded.put("Doll", mapPresentMagicNeeded.get("Doll") + 1);

            } else if (multiply == 250) {
                boxMaterialStack.pop();
                magicQueue.poll();
                mapPresentMagicNeeded.put("Wooden train", mapPresentMagicNeeded.get("Wooden train") + 1);

            } else if (multiply == 300) {
                boxMaterialStack.pop();
                magicQueue.poll();
                mapPresentMagicNeeded.put("Teddy bear", mapPresentMagicNeeded.get("Teddy bear") + 1);

            } else if (multiply == 400) {
                boxMaterialStack.pop();
                magicQueue.poll();
                mapPresentMagicNeeded.put("Bicycle", mapPresentMagicNeeded.get("Bicycle") + 1);

            }

            //Otherwise:

                //•	If the product of the operation is a negative number,
                // then you have to sum the values together,
                // remove them both from their positions and the result should be added
                // to the materials.
               else if (multiply < 0) {
                    sum = firstMaterial + firstMagic;
                    boxMaterialStack.pop();
                    magicQueue.poll();
                    boxMaterialStack.push(sum);

                }

                //•	If the product doesn’t equal one of the magic levels in the table
                // and is a positive number, remove only the magic value and increase
                // the material value by 15.
                else if (multiply > 0) {
                    magicQueue.poll();
                    boxMaterialStack.push(boxMaterialStack.pop() + 15);
                }

                //•	If the magic or material (or both) equals 0,
                // remove it (or both) and continue crafting the presents.
                else {
                    if (firstMaterial == 0) {
                        boxMaterialStack.poll();
                    } else if (firstMagic == 0) {
                        magicQueue.poll();
                    }
                }
        }




                //Your task is considered done if you manage to craft
                // either one of the pairs - a doll and a train
                // or a teddy bear and a bicycle
                if (mapPresentMagicNeeded.get("Doll") > 0 && mapPresentMagicNeeded.get("Wooden train") > 0
                        || mapPresentMagicNeeded.get("Teddy bear") > 0 && mapPresentMagicNeeded.get("Bicycle") > 0){
                    System.out.println("The presents are crafted! Merry Christmas!");

                }

               else{
                   System.out.println("No presents this Christmas!");

               }






        //•	On the next two lines print the materials and magic
        // that are left, if there are any, otherwise skip the line
        //o	"Materials left: {material1}, {material2}, …"
        if (!boxMaterialStack.isEmpty()){
            System.out.print("Materials left: ");
            System.out.println(boxMaterialStack.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }

        //o	"Magic left: {magicValue1}, {magicValue2}, …
        else if (!magicQueue.isEmpty()) {
            System.out.println("Magic left: " + String.join(", ",magicQueue.toString()
                    .replace("[","").replace("]","").trim()));
        }

        //•	On the next lines print the presents you have crafted at least once,
        // ordered alphabetically in the format:
        //"{toy name}: {amount}

        for (Map.Entry<String,Integer> item :mapPresentMagicNeeded.entrySet()){
            if (item.getValue()>0){
                System.out.println(item.getKey()+ ": " + item.getValue());
            }
        }

    }

}
