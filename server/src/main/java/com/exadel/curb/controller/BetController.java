package com.exadel.curb.controller;

import com.exadel.curb.entity.Bet;
import com.exadel.curb.entity.response.BetResponse;
import com.exadel.curb.entity.GameResultVO;
import com.exadel.curb.service.BetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BetController {

    private BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @RequestMapping(path = {"/bet"}, method = RequestMethod.GET)
    public ResponseEntity<BetResponse> getAllBets() throws Exception {
        List<Bet> bets = betService.getAllBets();
        return new ResponseEntity<>(new BetResponse(bets), HttpStatus.OK);
    }

    @RequestMapping(path = {"/bet/{nameOfBet}"}, method = RequestMethod.GET)
    public ResponseEntity<GameResultVO> getResultOfGame(final @PathVariable String nameOfBet) throws Exception {
        GameResultVO resultOfGame = betService.getResultOfGame(nameOfBet);
        return new ResponseEntity<>(resultOfGame, HttpStatus.OK);

    }


}
