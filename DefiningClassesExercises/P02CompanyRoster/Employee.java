package DefiningClassesExercises.P02CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;
    //The name, salary, position, and department are mandatory, while the rest are optional. - пишем 4 вида Constructors


    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        // входните данни липсва email и age и слагаме по условие на мястото на email "n/a" на age слагаме -1;
        this.setEmail("n/a");
        this.setAge(-1);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        // входните данни липсва  age и слагаме по условие на age -1;
        this.setAge(-1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        // входните данни липсва email слагаме по условие на мястото на email "n/a"
        this.setEmail("n/a");
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    //If an employee doesn't have an email – in place of that field,
    //you should print "n/a" instead, if he doesn't have an age – print "-1" instead
    //правим сетъри за email и age


    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",this.name,this.salary,this.email,this.age);

    }


}
