package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.handler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/lotteries")
    public UserResponse getLotteriesByUserId(@PathVariable("userId") String userId){
        return userService.getLotteriesByUserId(userId);
    }

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public ResponseEntity<Object> buyLotteryById(@PathVariable("userId") String userId, @PathVariable("ticketId") String ticketId){
        UserTicket userTicket = userService.buyLotteryById(userId, ticketId);
        return ResponseHandler.optionResponse("Id", userTicket.getUserId(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/lotteries/{ticketId}")
    public ResponseEntity<Object> sellLotteryById(@PathVariable("userId") String userId, @PathVariable("ticketId") String ticketId){
        String userTicket = userService.sellLotteryById(userId, ticketId);
        return ResponseHandler.optionResponse("ticket", userTicket, HttpStatus.OK);
    }
}
