package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.user.UserTicket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Integer> {
    Optional<Lottery> findByTicket(String ticketId);

    @Transactional
    @Query("SELECT l FROM Lottery l WHERE l.userTicket = ?1")
    List<Lottery> findByUserId(UserTicket userTicket);

    @Transactional
    @Query("SELECT l FROM Lottery l WHERE l.userTicket = ?1 AND l.ticket = ?2")
    Optional<Lottery> findByUserIdAndTicket(UserTicket userTicket, String ticketId);
}
