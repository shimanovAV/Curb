package com.exadel.curb.entity.response;

import com.exadel.curb.entity.GameResult;
import com.exadel.curb.entity.base.DataResponse;

import java.util.List;

public class GameResponse extends DataResponse<GameResult> {
    public GameResponse(List<GameResult> data) {
        super(data);
    }
}
