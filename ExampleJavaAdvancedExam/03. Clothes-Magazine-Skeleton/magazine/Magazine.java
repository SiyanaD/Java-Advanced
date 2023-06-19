package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private int capacity;


     //The class constructor should receive type and capacity,
    // also it should initialize the data with a new instance of the collection.
    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data= new ArrayList<>();
    }
    //•	Method addCloth(Cloth cloth) – adds an entity to the data if there is room for it
    public void addCloth(Cloth cloth){
        //проверка има ли място
        if (this.data.size()<capacity){
            this.data.add(cloth);
        }
    }


    //•	Method removeCloth(String color) – removes a cloth by given color,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeCloth(String color){

        //   //обхождаме целия списък
        for (Cloth cloth : this.data) {
            if (cloth.getColor().equals(color)){
                return this.data.remove(cloth);
            }
        }
      return false;
    }

    //•	Method getSmallestCloth() – returns the smallest cloth
    public Cloth getSmallestCloth(){
    return data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);

    }

    //•	Method getCloth(String color) – returns the cloth with the given color
    public Cloth getCloth(String color){
        return data.stream().filter(c->c.getColor().equals(color)).findFirst().orElse(null);

    }

    //•	Method getCount – returns the number of clothes
    public int getCount(){

        return this.data.size();
    }



    //•	Method report() – returns a string in the following format (print the clothes in order of appearance):
    public String report(){
        StringBuilder sb = new StringBuilder();
        //o	"{type} magazine contains:
        sb.append(String.format("%s magazine contains:",this.type)).append(System.lineSeparator());
        //{Cloth1}
        //{Cloth2}
        //(…)"
        this.data.forEach(c->sb.append(c.toString()).append(System.lineSeparator()));



        return sb.toString().trim();//trim()-премахва последни празен ред след принтирането
    }
}
