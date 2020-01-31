package com.exadel.curb.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum GameOption {

    ROCK("Rock"){
        @Override
        public boolean beats(GameOption other){
            return other.equals(SCISSORS);

        }
    },
    PAPER("Paper"){
        @Override
        public boolean beats(GameOption other){
            return other.equals(ROCK);

        }
    },
    SCISSORS("Scissors"){
        @Override
        public boolean beats(GameOption other){
            return other.equals(PAPER);

        }
    };

    private static final List<GameOption> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private String name;

    GameOption() {
    }

    GameOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static GameOption randomOption()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static GameOption byName(String name) {
        if(name!=null) {
            name = name.replaceAll("\"", "");
            for (GameOption gameOption : VALUES) {
                if (gameOption.getName().equalsIgnoreCase(name)) {
                    return gameOption;
                }
            }
        }
        return randomOption();
    }

    public abstract boolean beats(GameOption other);

}
