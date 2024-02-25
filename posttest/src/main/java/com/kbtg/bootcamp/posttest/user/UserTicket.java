package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_ticket")
@Getter @Setter
public class UserTicket {

    @Id
    @NotNull
    private String userId;

    private String name;

    @OneToMany(mappedBy = "userTicket")
    private List<Lottery> lottoryList;

    public UserTicket(String userId) {
        this.userId = userId;
    }

    public UserTicket() {
    }
}
