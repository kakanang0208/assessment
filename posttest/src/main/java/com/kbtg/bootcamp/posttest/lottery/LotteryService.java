package com.kbtg.bootcamp.posttest.lottery;

import exception.DuplicateException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotteryService {

    private final LotteryRepository repository;

    public LotteryService(LotteryRepository repository) {
        this.repository = repository;
    }

    public Lottery addLottery(LotteryRequest lotteryRequest) {
        Optional<Lottery> exitLottery = repository.findByTicket(lotteryRequest.getTicket());
        if(exitLottery.isPresent()){
            throw  new DuplicateException("Ticket already exist");
        }

        Lottery lottery = new Lottery();
        lottery.setAmount(lotteryRequest.getAmount());
        lottery.setPrice(lotteryRequest.getPrice());
        lottery.setTicket(lotteryRequest.getTicket());
        return repository.save(lottery);
    }

    public List<Lottery> getAllLotteries() {
        return repository.findAll();
    }
}
