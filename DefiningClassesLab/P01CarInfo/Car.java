package DefiningClassesLab.P01CarInfo;

public class Car {

    //характеристики на модела
   private String brand;

    private String model;

    private int HP;

    //методи

    //getters / accessors -> методи,  които осигуряват достъп до полетата и взимат стойността в тях
    //1. getter на полето brand -> върна стойността, която имам срещу полето brand
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

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    //вградени методи -> toString, equals, hashCode

    //1. toString -> представя обекта под формата на текст -> "package.class@address"
    @Override
    public String toString() {
        //"The car is: Chevrolet Impala - 390 HP."
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHP());
    }

    //2. equals -> метод, който сравняваме обекти

    //3. hashCode -> метод, който ни дава цифровата репрезентация на един обект
}
