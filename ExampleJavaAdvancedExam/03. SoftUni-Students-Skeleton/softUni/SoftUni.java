package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

//The class constructor should receive capacity,
// also it should initialize the students with a new instance of the collection.
    public SoftUni(int capacity) {
        this.capacity = capacity;

        //заменяме null с празен списък, за да мога да добавяме в списъка
        this.data = new ArrayList<>();//създаваме нов ArrayList в constructor capacity

    }

    //методи, Implement the following features:

    //•	getCapacity()

    public int getCapacity() {
        return capacity;
    }

    //•	getCount() method – returns the number of students in the course.
    public int getCount(){
        return this.data.size();//връща броя на учениците в листа от студенти
    }
    //•	insert(Student student) method – adds an entity to the data if there is a hall for it.
    public String insert(Student student){

        //o	Returns "The hall is full." - if the hall is full.
        if (getCount()+1>this.capacity){//залата е пълна не може да влизат повече студенти
            return "The hall is full.";
        }
        else {
            //o	Returns "Student is already in the hall." –  if the student is already in the hall.
            //може да влезе в залата но вече го има
            if (this.data.contains(student)){
                return "Student is already in the hall.";
            }
            //o	Returns "Added student {firstName} {lastName}." –  if the student is successfully added.
            //може да влезе в залата и го няма
            else {
                this.data.add(student);//добавяме студента
                return String.format("Added student {firstName} {lastName}.",student.getFirstName(),student.getLastName());
            }
        }
    }

    //•	remove(Student student) method – removes the student
    public String remove(Student student){

        //o	Returns "Removed student {firstName} {lastName}." –  if the student is successfully removed.
        if (this.data.contains(student)){
            this.data.remove(student);//ако студента се съдържа в списъка го изтриваме
            return String.format("Removed student %s %s.",student.getFirstName(),student.getLastName());
        }

        //o	Returns "Student not found." if the student is not in the hall.
        else {
            return "Student not found.";
        }
    }


    //•	getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName){
        for (Student student : this.data) {//обхождаме всеки един студент в списъка със студенти
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        //ако обходим списъка и не намери студента return null;
        return null;
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"Hall size: {addedStudentsCount}
    // Student: {firstName} {lastName}, Best Course = {bestCourse}
    // Student: {firstName} {lastName}, Best Couse = {bestCourse}
    // (…)"
    public String getStatistics(){
        //създаваме StringBuilder
        StringBuilder sb = new StringBuilder();
        //o	"Hall size: {addedStudentsCount}
        sb.append("Hall size: ").append(getCount()).append(System.lineSeparator());

        //след това обхождаме всеки един от студентите
        // Student: {firstName} {lastName}, Best Course = {bestCourse}
        // Student: {firstName} {lastName}, Best Couse = {bestCourse}
        // (…)"

        this.data.forEach(student->sb.append(student.toString()).append(System.lineSeparator()));


        return sb.toString();
    }
}
