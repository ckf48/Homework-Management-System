package util;

import model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ckf48
 */
@Component
public class HomeworkJdbc {
    private JdbcConnection jdbcConnection;

    @Autowired
    public HomeworkJdbc(JdbcConnection jdbcConnection){
        this.jdbcConnection = jdbcConnection;
    }

    public List<Homework> selectAllHomework(){
        List<Homework> list = new ArrayList<>();
        String selectSql = "select * from school.s_homework";
        try(Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
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

    public void addHomework(Homework homework){
        String addSql = "insert into school.s_homework (title, content, create_time, update_time) values (?,?,?,?)";
        try(Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
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
}
