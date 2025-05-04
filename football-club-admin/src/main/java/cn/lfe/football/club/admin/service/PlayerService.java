package cn.lfe.football.club.admin.service;

import cn.lfe.football.club.admin.entity.player.PlayerDto;
import cn.lfe.football.club.admin.entity.player.PlayerRequest;
import cn.lfe.football.club.admin.support.PlayerSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.lfe.common.football.club.common.util.SmartUtils.copyToBean;


/**
 * @author chen yue
 * @date 2025-05-04 12:18:10
 */
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerSupport playerSupport;

    public void add(PlayerRequest player) {
        playerSupport.add(copyToBean(player, PlayerDto.class));
    }

    public List<PlayerDto> listAll() {
        return playerSupport.listAll();
    }

    public void delete(Long id) {
        playerSupport.delete(id);
    }

    public Object get(Long id) {
        return playerSupport.get(id);
    }

    public void edit(PlayerDto player) {
        playerSupport.edit(player);
    }
}
