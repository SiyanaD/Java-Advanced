package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    //Next, write a Java class Parking that has data (Collection, which stores the entity Car).
    // All entities inside the repository have the same fields.
    // Also, the Parking class should have those fields:
    //•	type: String
    //•	capacity: int
    private List<Car> data;
    private String type;
    private int capacity;

    //The class constructor should receive type and capacity, also it should initialize the data
    // with a new instance of the collection.
    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }

    //. Implement the following features:
    //•	Method add(Car car) – adds an entity to the data if there is an empty cell for the car
    public void add(Car car){
        //проверка има ли място
        if (data.size()<capacity){
            this.data.add(car);
        }
    }

    //•	Method remove(String manufacturer, String model) –
    // removes the car by given manufacturer and model, if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model){
        return this.data.removeIf(m->m.getManufacturer().equals(manufacturer)&&
                m.getModel().equals(model));
    }

    //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar(){
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }


    //•	Method getCar(String manufacturer, String model) –
    // returns the car with the given manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model){

        return data.stream().filter(m->m.getManufacturer().equals(manufacturer)
                &&(m.getModel().equals(model))).findFirst()
                .orElse(null);
    }

    //•	Getter getCount() – returns the number of cars.
    public int getCount(){
       return this.data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        //o	"The cars are parked in {parking type}:
        sb.append(String.format("The cars are parked in %s:",this.type)).append(System.lineSeparator());
        //{Car1}
        //{Car2}
        //(…)"
        this.data.forEach(c->sb.append(c.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
