package cn.lfe.football.club.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-03 23:21:09
 */
@Getter
@Setter
public class EventGameRel {
    private Long id;
    private Long eventId;
    private Long matchDayId;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
