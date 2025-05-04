package cn.lfe.football.club.admin.entity.statistics;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:32:18
 */
@Getter
@Setter
public class StatisticsScore {
    private Long id;
    private Long participantsPlayerId;
    private Boolean ownGoal;
    private Integer scoreMinute;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
