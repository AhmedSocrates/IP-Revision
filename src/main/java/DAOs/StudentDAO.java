package DAOs;
import Models.Student;
import java.sql.*;

public class StudentDAO {
    private String url = "jdbc:mysql://localhost:3306/student_db";
    private String username = "root";
    private String password = "root";

    public void saveStudent(Student student){
        //1. load the driver: 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. Establish the connection
            try{
                Connection conn = DriverManager.getConnection(url,username,password);
                // Create PreparedStatement 
                String sql = "INSERT INTO student (name,marks,grade) VALUES (?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, student.getName());
                stmt.setDouble(2, student.getMarks());
                stmt.setString(3, student.getGrade());
                stmt.executeUpdate();
                stmt.close();
                conn.close();
            }catch(Exception e){
                e.printStackTrace(); 
            } 
        
    } catch(Exception e){
                e.printStackTrace();
}
}
}

