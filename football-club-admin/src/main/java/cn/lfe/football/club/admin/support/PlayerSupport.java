package cn.lfe.football.club.admin.support;

import cn.lfe.football.club.admin.entity.player.Player;
import cn.lfe.football.club.admin.entity.player.PlayerDto;
import cn.lfe.football.club.admin.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.lfe.common.football.club.common.util.SmartUtils.copyToBean;
import static cn.lfe.common.football.club.common.util.SmartUtils.copyToList;


/**
 * @author chen yue
 * @date 2025-05-04 12:19:08
 */
@Service
@RequiredArgsConstructor
public class PlayerSupport {

    private final PlayerMapper playerMapper;

    public PlayerDto add(PlayerDto player) {
        Player playerEntity = copyToBean(player, Player.class);
        playerMapper.add(playerEntity);
        return copyToBean(playerEntity, PlayerDto.class);
    }

    public List<PlayerDto> listAll() {
        return copyToList(playerMapper.listAll(), PlayerDto.class);
    }

    public void delete(Long id) {
        playerMapper.delete(id);
    }

    public PlayerDto get(Long id) {
        return copyToBean(playerMapper.get(id), PlayerDto.class);
    }

    public void edit(PlayerDto player) {
        playerMapper.edit(copyToBean(player, Player.class));
    }
}
