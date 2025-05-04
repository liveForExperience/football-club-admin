package cn.lfe.football.club.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:22:51
 */
@Getter
@Setter
public class Team {
    private Long id;
    private String name;
    private String display;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
