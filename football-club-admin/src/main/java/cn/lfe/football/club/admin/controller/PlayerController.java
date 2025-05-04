package cn.lfe.football.club.admin.controller;

import cn.lfe.football.club.admin.entity.player.PlayerDto;
import cn.lfe.football.club.admin.entity.player.PlayerRequest;
import cn.lfe.football.club.admin.entity.player.PlayerResponse;
import cn.lfe.football.club.admin.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.lfe.common.football.club.common.util.SmartUtils.copyToBean;
import static cn.lfe.common.football.club.common.util.SmartUtils.copyToList;


/**
 * @author chen yue
 * @date 2025-05-04 11:45:28
 */
@RestController
@RequestMapping("player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("add")
    public ResponseEntity<Void> add(@RequestBody @Validated PlayerRequest player) {
        playerService.add(player);
        return ResponseEntity.ok().build();
    }

    @GetMapping("list/all")
    public ResponseEntity<List<PlayerResponse>> listAll() {
        return ResponseEntity.ok(copyToList(playerService.listAll(), PlayerResponse.class));
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<PlayerResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(copyToBean(playerService.get(id), PlayerResponse.class));
    }

    @PostMapping("edit")
    public ResponseEntity<Void> edit(@RequestBody @Validated PlayerRequest player) {
        playerService.edit(copyToBean(player, PlayerDto.class));
        return ResponseEntity.ok().build();
    }
}
