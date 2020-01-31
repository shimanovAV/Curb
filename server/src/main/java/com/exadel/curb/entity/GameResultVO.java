package com.exadel.curb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResultVO {

    private String result;

    private String description;

    private Bet winnerBet;

}
