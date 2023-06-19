package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;


    //The class constructor should receive the name and capacity,
    // also it should initialize the employees
    // with a new instance of the collection.

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        //•	Field employees – List that holds added Employees
        this.employees=new ArrayList<>();
    }

    //•	Method addEmployee(Employee employee) – adds an entity to the data if there is room for him/her
    public void addEmployee(Employee employee){
        //ако няма място: this.employees.size()>=capacity
        //проверка има ли място - по условие
        if (this.employees.size()<capacity){
            this.employees.add(employee);
        }
    }
    //•	Method removeEmployee(String name) – removes an employee by given name, if such exists, and returns a bool.
    public boolean removeEmployee(String name){
        //обхождаме целия списък
        for (Employee employee :this.employees) {
            if (employee.getName().equals(name)){
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    //•	Method getOldestEmployee() – returns the oldest employee
    public Employee getOldestEmployee(){

        //взимаме най възрастния служител->e1,e2)->Integer.compare(e1.getAge(),e2.getAge()
        return this.employees.stream().max((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).get();
    }

    //•	Method getEmployee(string name) – returns the employee with the given name.
    public Employee getEmployee(String name){
        //ако има служител с това име
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        //ако няма служител с това име връща null
        return null;
    }

    //•	Getter getCount() – returns the number of employees.
    public int getCount(){
        return this.employees.size();
    }

    //•	report() – returns a string in the following format:
    public String report() {
        //o	"Employees working at Cafe {cafeName}:
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:",this.name)).append(System.lineSeparator());
        //{Employee1}
        //{Employee2}
        //(…)"
        this.employees.forEach(e->sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString().trim();//trim()-премахва последни празен ред след принтирането
    }

}
