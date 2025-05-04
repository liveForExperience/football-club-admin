package cn.lfe.football.club.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import static cn.lfe.common.football.club.common.constant.AppConstants.MAPPER_LOCATION;

/**
 * @author chen yue
 * @date 2025-05-04 18:53:27
 */
@Configuration
@MapperScan(MAPPER_LOCATION)
public class DaoConfig {
}
