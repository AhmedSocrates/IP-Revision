package Models;
public class Student{
    String name;
    double marks;
    String grade;

    public Student(){}
    public Student(String name, double marks ){
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }
    public double getMarks() {
        return marks;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}