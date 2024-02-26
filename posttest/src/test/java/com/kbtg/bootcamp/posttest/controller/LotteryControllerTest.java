package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryController;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class LotteryControllerTest {

    MockMvc mockMvc;

    @Mock
    LotteryService lotteryService;

    @BeforeEach
    void setUp() {
        LotteryController lotteryController = new LotteryController(lotteryService);
        mockMvc = MockMvcBuilders.standaloneSetup(lotteryController)
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("when perform on GET: /lotteries should return ticket 000001, 000002")
    void getAllLottery() throws Exception {
        Lottery lottery1 = new Lottery();
        lottery1.setTicket("000001");
        lottery1.setPrice(80);
        lottery1.setAmount(1);

        Lottery lottery2 = new Lottery();
        lottery2.setTicket("000002");
        lottery2.setPrice(80);
        lottery2.setAmount(1);

        when(lotteryService.getAllLotteries()).thenReturn(List.of(lottery1, lottery2));

        ArrayList<String> ticket = new ArrayList<String>();
        ticket.add(lottery1.getTicket());
        ticket.add(lottery2.getTicket());

        mockMvc.perform(get("/lotteries"))
                .andExpect(jsonPath("$.ticket", is(ticket)))
                .andExpect(status().isOk());
    }
}
