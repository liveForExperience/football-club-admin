package cn.lfe.football.club.admin.entity.player;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chen yue
 * @date 2025-05-04 11:46:27
 */
@Getter
@Setter
public class PlayerRequest {
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "年龄不能为空")
    private Integer age;
    @NotNull(message = "性别不能为空")
    private Boolean gender;
}
