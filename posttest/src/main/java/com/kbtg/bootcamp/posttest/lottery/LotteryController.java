package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.handler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lotteries")
public class LotteryController {

    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllLotteries(){
        List<Lottery> listLottery = lotteryService.getAllLotteries();
        return ResponseHandler.response("ticket", listLottery, HttpStatus.OK);
    }

}
