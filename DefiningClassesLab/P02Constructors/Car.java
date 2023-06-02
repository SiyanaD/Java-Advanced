package DefiningClassesLab.P02Constructors;

public class Car {
    //полета -> характеристики
    private String brand;
    private String model;
    private int age;

    public Car(String brand, String model, int age) {
        this.brand = brand;
        this.model = model;
        this.age = age;
    }


    //If you miss information about the field of type String set the value to "unknown", and for an integer, fieldset -1.
     public Car(String brand){
         //празен обект
         //brand = null
         //model = null
         //horsePower = 0
        this.brand=brand;
        this.model = "unknown";
        this.age = -1;

}

    public Car() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //вградени методи -> toString, equals, hashCode

    //1. toString -> представя обекта под формата на текст -> "package.class@address"
    @Override
    public String toString() {
        //"The car is: Chevrolet Impala - 390 HP."
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getAge());
    }

    //2. equals -> метод, който сравняваме обекти

    //3. hashCode -> метод, който ни дава цифровата репрезентация на един обект

}

