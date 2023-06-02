package DefiningClassesExercises.P01OpinionPoll;

public class Person {
    //характеристики - име, възраст
    private String name;
    private int age;

    //конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.age;
    }
}
