package com.exadel.curb.service;

import com.exadel.curb.dao.BetRepository;
import com.exadel.curb.dao.GameRepository;
import com.exadel.curb.entity.Bet;
import com.exadel.curb.entity.GameOption;
import com.exadel.curb.entity.GameResult;
import com.exadel.curb.entity.GameResultVO;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class BetService {

    private static Logger logger = LoggerFactory.getLogger(BetService.class);

    public static final String CURB_SERVER_URL = "https://private-anon-a2db22d4e7-curbrockpaperscissors.apiary-proxy.com/rps-stage/throw";
    private final BetRepository betRepository;

    private final GameRepository gameRepository;

    public BetService(BetRepository betRepository, GameRepository gameRepository) {
        this.betRepository = betRepository;
        this.gameRepository = gameRepository;
    }

    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    public GameResultVO getResultOfGame(String user){
        GameOption curbChoice = getCurbResponse();
        GameOption userChoice = GameOption.byName(user);
        if (userChoice.equals(curbChoice))
        {
            gameRepository.save(new GameResult(userChoice.getName(), curbChoice.getName(), "nobody"));
            return new GameResultVO("Tie!", "Nobody wins", betRepository.findBetByName(userChoice.getName()));
        }
        else if ( userChoice.beats(curbChoice))
        {
            gameRepository.save(new GameResult(userChoice.getName(), curbChoice.getName(), "user"));
            return new GameResultVO("You won!", "Curb with " + curbChoice.getName()
                    + " loses", betRepository.findBetByName(curbChoice.getName()));
        }
        else
        {
            gameRepository.save(new GameResult(userChoice.getName(), curbChoice.getName(), "curb"));
            return new GameResultVO("You lost!", "Curb with " + curbChoice.getName()
                    + " wins", betRepository.findBetByName(curbChoice.getName()));
        }
    }

    public GameOption getCurbResponse(){
        String body = null;
        Integer statusCode;
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(CURB_SERVER_URL);
        Response response = target.request().get();
        try {
            JSONObject obj = new JSONObject(response.readEntity(String.class));
            statusCode = Integer.valueOf(obj.getString("statusCode"));
            body = obj.getString("body");
            if (statusCode != 200) {
                logger.error(body);
            }
        }catch (JSONException ex){
            logger.error(ex.getMessage(), ex);
        }finally {
            return  GameOption.byName(body);
        }
    }
}
