package DAOs;
import Configuration.DatabaseConfig;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import Models.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class StudenDAO2 {
    private JdbcTemplate jdbcTemplate;
    public StudenDAO2(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired 
    public void saveStudent(Student student){
        String sql = "INSERT INTO student (name,marks,grade) VALUES (?,?,?)";
        jdbcTemplate.update(sql, student.getName(), student.getMarks(), student.getGrade());
    }

    public List<Student> getAllStudents(){
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
