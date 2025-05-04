package cn.lfe.football.club.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:24:00
 */
@Getter
@Setter
public class TeamPlayerRel {
    private Long id;
    private Long teamId;
    private Long playerId;
    private Date startDate;
    private Date endDate;
    private Boolean isCurrent;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
