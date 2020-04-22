package model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author ckf48
 */
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
