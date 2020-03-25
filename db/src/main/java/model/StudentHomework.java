package model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StudentHomework {
    private Long id;

    private Long studentId;

    private Long homeworkId;

    private String homeworkTitle;

    private String homeworkContent;

    private Timestamp createTime;

    private Timestamp updateTime;
}
