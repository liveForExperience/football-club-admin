package cn.lfe.football.club.admin.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-03 22:48:22
 */
@Getter
@Setter
public class Event {
    private Long id;
    private String name;
    private String display;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
