package cn.lfe.football.club.admin.mapper;

import cn.lfe.football.club.admin.entity.player.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chen yue
 * @date 2025-05-04 11:36:39
 */
@Mapper
public interface PlayerMapper {

    void add(Player player);

    List<Player> listAll();

    void delete(@Param("id") Long id);

    Player get(@Param("id") Long id);

    void edit(Player player);
}
