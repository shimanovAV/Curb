package com.exadel.curb.service;

import com.exadel.curb.dao.GameRepository;
import com.exadel.curb.entity.GameResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameResult> getAllGames() {
        return gameRepository.findAll();
    }


}
