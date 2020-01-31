package com.exadel.curb.dao;

import com.exadel.curb.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
    Bet findBetByName(String name);
}
