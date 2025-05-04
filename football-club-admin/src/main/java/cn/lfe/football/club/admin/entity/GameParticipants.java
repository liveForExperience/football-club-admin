package cn.lfe.football.club.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:21:53
 */
@Getter
@Setter
public class GameParticipants {
    private Long id;
    private Long gameId;
    private Long teamId;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
