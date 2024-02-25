package com.kbtg.bootcamp.posttest.user;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {

    private List<String> ticket;

    private Integer count;

    private Integer cost;

    public UserResponse(List<String> ticket, Integer count, Integer cost) {
        this.ticket = ticket;
        this.count = count;
        this.cost = cost;
    }
}
