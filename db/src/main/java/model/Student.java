package model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student {
    private Long id;

    private String name;

    private Timestamp createTime;

    private Timestamp updateTime;
}
