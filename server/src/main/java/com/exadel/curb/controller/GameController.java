package com.exadel.curb.controller;

import com.exadel.curb.entity.GameResult;
import com.exadel.curb.entity.response.GameResponse;
import com.exadel.curb.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(path = {"/statistics"}, method = RequestMethod.GET)
    public ResponseEntity<GameResponse> getAllBets() {
        List<GameResult> games = gameService.getAllGames();
        return new ResponseEntity<>(new GameResponse(games), HttpStatus.OK);
    }
}
