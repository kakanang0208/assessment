package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.user.UserTicket;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lottery")
@Getter @Setter
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 6, max = 6)
    private String ticket;

    @NotNull
    private Integer price;

    @NotNull
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserTicket userTicket;

    public Lottery() {
    }
}
