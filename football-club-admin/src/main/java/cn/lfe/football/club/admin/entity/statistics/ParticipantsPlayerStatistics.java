package cn.lfe.football.club.admin.entity.statistics;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:26:31
 */
@Getter
@Setter
public class ParticipantsPlayerStatistics {
    private Long id;
    private Long participantsId;
    private Long playerId;
    private String type;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
