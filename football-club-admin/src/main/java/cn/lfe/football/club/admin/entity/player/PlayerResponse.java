package cn.lfe.football.club.admin.entity.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author chen yue
 * @date 2025-05-04 11:46:37
 */
@Getter
@Setter
public class PlayerResponse {
    private Long id;
    private String name;
    private Integer age;
    private Boolean gender;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
}
