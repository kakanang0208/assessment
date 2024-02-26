package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.user.UserController;
import com.kbtg.bootcamp.posttest.user.UserResponse;
import com.kbtg.bootcamp.posttest.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    MockMvc mockMvc;

    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        UserController userController = new UserController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("Path : GET /users/{userId}/lotteries Get lottery by userId")
    void getLotteriesByUserId() throws Exception {

        ArrayList<String> ticket = new ArrayList<String>();
        ticket.add("000001");
        ticket.add("000002");

        UserResponse userResponse;
        userResponse = userService.getLotteriesByUserId("0000000001");
        userResponse = new UserResponse(ticket, 2, 180);

        assertThat(userResponse.getTicket()).hasSize(2);
    }
}
