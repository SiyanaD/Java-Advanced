package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Map<String, LinkedHashMap<String,Double>> shopProductPrice = new TreeMap<>();


        while (!data.equals("Revision")){

            String [] input = data.split(",\\s+");
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            if (shopProductPrice.containsKey(shop)){
                shopProductPrice.get(shop).put(product,price);
            }

            shopProductPrice.putIfAbsent(shop,new LinkedHashMap<>());
            shopProductPrice.get(shop).put(product,price);



            data = scanner.nextLine();
        }
        //обхождаме продукт и цена на дадения магазин
        for (Map.Entry<String,LinkedHashMap<String,Double>> currentShop : shopProductPrice.entrySet()) {
            System.out.printf("%s->%n",currentShop.getKey()); //принтиране на map(key)
            for (Map.Entry<String,Double>currentProduct : currentShop.getValue().entrySet()){//принтиране на LinkedHashMap<String,Double>
                System.out.printf("Product: %s, Price: %.1f%n",currentProduct.getKey(),currentProduct.getValue());
            }

        }


    }
}
