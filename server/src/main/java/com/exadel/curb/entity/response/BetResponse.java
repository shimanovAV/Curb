package com.exadel.curb.entity.response;

import com.exadel.curb.entity.Bet;
import com.exadel.curb.entity.base.DataResponse;

import java.util.List;

public class BetResponse extends DataResponse<Bet> {
    public BetResponse(List<Bet> data) {
        super(data);
    }
}

