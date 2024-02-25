package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {

    private final LotteryRepository repository;

    public LotteryService(LotteryRepository repository) {
        this.repository = repository;
    }

    public Lottery addLottery(LotteryRequest lotteryRequest) {
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
