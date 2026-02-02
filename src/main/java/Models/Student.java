//without annotation (For JDBC and Spring JDBC Template
//With annotation (For Hibernate and JPA)


package Models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="student")
public class Student{
    
    /*@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id");
    int id;
    */

    @Column(name="name")
    String name;

    @Column(name="marks")
    double marks;
    
    @Column(name="grade")
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