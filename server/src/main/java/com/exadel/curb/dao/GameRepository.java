package com.exadel.curb.dao;

import com.exadel.curb.entity.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameResult, Long> {
}
