package cn.lfe.football.club.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:17:12
 */
@Getter
@Setter
public class Game {
    private Long id;
    private Long matchDayId;
    private Date startTime;
    private Date endTime;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
