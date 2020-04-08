package Bean;

import model.Homework;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Configuration
public class HomeworkJdbc {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/homeworks?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public void addHomework(Homework homework){
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String addSql = "insert into school.s_homework (title, content, create_time, update_time) values (?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(URL,"root", "123456")) {
            try(PreparedStatement statement = connection.prepareStatement(addSql)) {
                statement.setString(1,homework.getTitle());
                statement.setString(2,homework.getContent());
                statement.setTimestamp(3,homework.getCreateTime());
                statement.setTimestamp(4,homework.getUpdateTime());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Homework> selectAllHomework(){
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Homework> list = new ArrayList<>();
        String selectSql = "select * from school.s_homework";
        try(Connection connection = DriverManager.getConnection(URL,"root", "123456")) {
            try(Statement statement = connection.createStatement()){
                try (ResultSet resultSet = statement.executeQuery(selectSql)){
                    while (resultSet.next()){
                        Homework homework = new Homework();
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        homework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
