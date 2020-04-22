package model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author ckf48
 */
@Data
public class Homework {
    private Long id;

    private String title;

    private String content;

    private Timestamp createTime;

    private Timestamp updateTime;
}
