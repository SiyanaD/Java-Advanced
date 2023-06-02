package DefiningClassesExercises.P02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, List<Employee>> map = new HashMap<>();

        Employee employee;

        for (int i = 0; i <n ; i++) {
            String [] line = scanner.nextLine().split("\\s+");
            int lineLength = line.length;
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];


            map.putIfAbsent(department,new ArrayList<>());


            if (lineLength==4){
             employee=new Employee(name,salary,position,department);

            } else if (line.length==5) {
                if (line[4].contains("@")){
                    employee= new Employee(name,salary,position,department,line[4]);
                }
                else {
                    employee = new Employee(name,salary,position,department,Integer.parseInt(line[4]));
                }
            }
            else {
                employee=new Employee(name,salary,position,department,line[4],Integer.parseInt(line[5]));

            }
            //добавяме в мап
            map.get(department).add(employee);
        }

        //- намираме най високата заплата sorted by salary in descending order- Comparator.reverseOrder())).findFirst().orElse(null);

        Map.Entry<String,List<Employee>> highestSalaryDepartment = map.entrySet().stream().sorted(Comparator.comparing
                ((Map.Entry<String,List<Employee>> department)->department.getValue().stream().mapToDouble(Employee::getSalary)
                        .average().getAsDouble(),Comparator.reverseOrder())).findFirst().orElse(null);


        System.out.printf("Highest Average Salary: %s%n",highestSalaryDepartment.getKey());
        //сравняваме 2 заплати една с друга и взимаме най високата
        highestSalaryDepartment.getValue().stream().sorted((e1,e2)->Double.compare(e2.getSalary(),e1.getSalary())).forEach(System.out::println);


    }
}
