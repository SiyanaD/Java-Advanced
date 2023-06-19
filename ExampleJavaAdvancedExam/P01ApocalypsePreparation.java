package ExampleJavaAdvancedExam;

import java.util.*;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();

        int sum = 0;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(t->textilesQueue.offer(Integer.parseInt(t)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(m->medicamentStack.push(Integer.parseInt(m)));

        Map<String,Integer> mapHealing = new HashMap<>();
        mapHealing.put("Patch",0);
        mapHealing.put("Bandage",0);
        mapHealing.put("MedKit",0);
        //Patch
        //Bandage
        //MedKit


        while (!textilesQueue.isEmpty() && !medicamentStack.isEmpty()){

            int firstTextile = textilesQueue.peek();
            int firstMedicament = medicamentStack.peek();
            sum=firstTextile+firstMedicament;

            //•	if their sum is equal to any of the items in the table below
            // create that item and remove both values
            if (sum==30){
                mapHealing.put("Patch",mapHealing.get("Patch")+1);
                textilesQueue.poll();
                medicamentStack.pop();
            } else if (sum==40) {
                mapHealing.put("Bandage",mapHealing.get("Bandage")+1);
                textilesQueue.poll();
                medicamentStack.pop();
            } else if (sum==100) {
                mapHealing.put("MedKit",mapHealing.get("MedKit")+1);
                textilesQueue.poll();
                medicamentStack.pop();
            }
            else {
            //•	Otherwise, check if the sum is bigger than the value of the MedKit,
            // create the MedKit, remove both values,
            // and add the remaining resources(of the sum) to the next value in the medicament
            // collection (Take the element from the collection, add the remaining sum to it,
            // and put the element back to its place).

            if (sum>100){
                mapHealing.put("MedKit",mapHealing.get("MedKit")+1);
                sum-=100;
                medicamentStack.pop();
                medicamentStack.push(medicamentStack.pop()+sum);
                textilesQueue.poll();
            }
            //If you can’t create anything, remove the textile value,
                // add 10 to the medicament value, and return the medicament back to its place,
                // into its collection
                else {
                    medicamentStack.push(medicamentStack.pop()+10);
                    textilesQueue.poll();
            }
        }
        }

        //o	If both are empty print: "Textiles and medicaments are both empty."
         if (textilesQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

        }
        //If the textile is over print: "Textiles are empty."
        else if (textilesQueue.isEmpty()){
            System.out.println("Textiles are empty.");

        }

        //o	If the medicaments are over print: "Medicaments are empty."
        else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }



        //•	On the next n lines print only the created items (if any)
        // ordered by the amount created descending, then by name alphabetically:
        List<Map.Entry<String,Integer>> listItem = new ArrayList<>(mapHealing.entrySet());
        Collections.sort(listItem,Comparator.comparing(
                Map.Entry<String,Integer>::getValue).reversed()
                .thenComparing(Map.Entry<String,Integer>::getKey));

        for (Map.Entry<String,Integer> item : listItem){
            if (item.getValue()==0){
                break;
            }
            else {
            System.out.println(item.getKey()+ " - " + item.getValue());}
        }
        //•	On the last line print the remaining items (if any):
        //o	If there are any textiles left:
        //"Textiles left: {textile1}, {textile2}…"
       if (!textilesQueue.isEmpty()){
        System.out.println("Textiles left: " + String.join(", ",textilesQueue.toString()
                .replace("[","").replace("]","").trim()));

        }
        //o	If there are any medicaments left:
        //"Medicaments left: {medicament1}, {medicament2}…"
       else if (!medicamentStack.isEmpty()) {
        List<String> result = new ArrayList<>();
        while (!medicamentStack.isEmpty()){
            String leftMedicament = String.valueOf(medicamentStack.pop());
            result.add(leftMedicament);
        }
            System.out.print("Medicaments left: ");
            String joined = String.join(", ",result);
            System.out.println(joined);
        }



    }
}
