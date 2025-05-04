package cn.lfe.football.club.admin.config;

import lombok.Data;

/**
 * @author ChenYue
 * @date 2021/6/30 17:51
 */
@Data
public class PageParam {
    private Integer pageNum;
    private Integer pageSize;

    public static PageParam create() {
        return new PageParam();
    }

    public PageParam pageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public PageParam pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
