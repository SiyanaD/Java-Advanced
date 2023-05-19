package SetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOnStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrade = new TreeMap<>();

        for (int i = 1; i <=numberOnStudents ; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            double grades = Double.parseDouble(input[1]);


            studentsGrade.putIfAbsent(name, new ArrayList<>());
            studentsGrade.get(name).add(grades);//studentsGrade.get(name) - това е листа в който добавяме оценките
        }

            studentsGrade.entrySet().forEach(entry->{
                double sum = 0;
                for (int j = 0; j <entry.getValue().size() ; j++) {
                    sum+=entry.getValue().get(j);
                }
                double avrSum = sum/entry.getValue().size();

                System.out.print(entry.getKey()+ " -> ");
                entry.getValue().forEach(e-> System.out.printf("%.2f ",e));
                System.out.printf("(avg: %.2f)%n", avrSum);


            });





        }
    }


