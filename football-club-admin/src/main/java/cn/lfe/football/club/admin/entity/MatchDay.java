package cn.lfe.football.club.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:16:12
 */
@Getter
@Setter
public class MatchDay {
    private Long id;
    private String name;
    private String display;
    private Date planDate;
    private Date actualDate;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
