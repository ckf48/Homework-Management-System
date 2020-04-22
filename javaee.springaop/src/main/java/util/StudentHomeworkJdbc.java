package util;

import model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ckf48
 */
@Component
public class StudentHomeworkJdbc {
    private JdbcConnection jdbcConnection;

    @Autowired
    public StudentHomeworkJdbc(JdbcConnection jdbcConnection){
        this.jdbcConnection = jdbcConnection;
    }

    public List<StudentHomework> selectAllStudentHomework() {
        List<StudentHomework> list = new ArrayList<>();
        String sql = "select * from school.s_student_homework";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement();) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        sh.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addStudentHomework(StudentHomework studentHomework) {
        String addSql = "insert into school.s_student_homework (student_id, homework_id, homework_title, homework_content, create_time, update_time) values (?,?,?,?,?,?)";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(addSql)) {
                statement.setLong(1, studentHomework.getStudentId());
                statement.setLong(2, studentHomework.getHomeworkId());
                statement.setString(3, studentHomework.getHomeworkTitle());
                statement.setString(4, studentHomework.getHomeworkContent());
                statement.setTimestamp(5, studentHomework.getCreateTime());
                statement.setTimestamp(6, studentHomework.getUpdateTime());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
