package model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author ckf48
 */
@Data
public class Student {
    private Long id;

    private String name;

    private Timestamp createTime;

    private Timestamp updateTime;
}
