package com.exadel.curb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_Choice")
    private String userChoice;

    @Column(name = "curb_Choice")
    private String curbChoice;

    @Column(name = "winner")
    private String winner;

    public GameResult(String userChoice, String curbChoice, String winner) {
        this.userChoice = userChoice;
        this.curbChoice = curbChoice;
        this.winner = winner;
    }
}
