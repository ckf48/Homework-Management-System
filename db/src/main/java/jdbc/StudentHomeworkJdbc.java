package jdbc;

import model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/homeworks?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public static void addStudentHomework(StudentHomework studentHomework) {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String addSql = "insert into school.s_student_homework (student_id, homework_id, homework_title, homework_content, create_time, update_time) values (?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(URL,"root", "123456")) {
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

    public static List<StudentHomework> selectAllStudentHomework() {
        List<StudentHomework> list = new ArrayList<>();
        String sql = "select * from school.s_student_homework";
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL,"root", "123456")) {
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


}
