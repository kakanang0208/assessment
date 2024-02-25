package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryRequest {

    @NotNull
    @Size(min = 6, max = 6, message = "Ticket should be 6 number")
    private String ticket;

    @NotNull
    private Integer price;

    @NotNull
    private Integer amount;
}
