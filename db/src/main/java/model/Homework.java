package model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Homework {
    private Long id;

    private String title;

    private String content;

    private Timestamp createTime;

    private Timestamp updateTime;
}
