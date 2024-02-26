package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRepository;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final LotteryRepository lotteryRepository;

    private final UserRepository userRepository;

    public UserService(LotteryRepository lotteryRepository, UserRepository userRepository) {
        this.lotteryRepository = lotteryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserTicket buyLotteryById(String id, String ticketId) {
        UserTicket userTicket = null;
        Optional<UserTicket> existUserTicket = userRepository.findById(id);
        if(existUserTicket.isEmpty()){
            userTicket = new UserTicket();
            userTicket.setUserId(id);
            userTicket.setName("Nan");
            userRepository.save(userTicket);
        }

        Optional<Lottery> lottery = lotteryRepository.findByTicket(ticketId);
        if(lottery.isPresent()){
            lottery.get().setUserTicket(existUserTicket.orElse(userTicket));
            lotteryRepository.save(lottery.get());

        } else{
            throw new NotFoundException("Ticket not found "+ticketId);
        }
        return existUserTicket.orElse(userTicket);
    }

    public UserResponse getLotteriesByUserId(String userId) {
        int count = 0;
        int cost = 0;

        UserTicket userTicket = new UserTicket(userId);
        List<Lottery> lotteryList = lotteryRepository.findByUserId(userTicket);
        List<String> ticketList = new ArrayList<>();

        for (Lottery lottery : lotteryList){
            ticketList.add(lottery.getTicket());
            cost += lottery.getPrice();
            count += lottery.getAmount();
        }
        return new UserResponse(ticketList, count, cost);
    }

    public String sellLotteryById(String userId, String ticketId) {
        UserTicket userTicket = new UserTicket(userId);
        Optional<Lottery> lottery = lotteryRepository.findByUserIdAndTicket(userTicket, ticketId);
        if(lottery.isPresent()){
            lottery.get().setUserTicket(null);
            lotteryRepository.save(lottery.get());
        } else{
            throw new NotFoundException("Data not found");
        }
        return lottery.get().getTicket();
    }
}
