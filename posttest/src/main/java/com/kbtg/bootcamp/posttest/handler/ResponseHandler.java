package com.kbtg.bootcamp.posttest.handler;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> optionResponse(String key, String value, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key, value);
        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> response(String key, List<Lottery> listLottery, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> listTicket = new ArrayList<>();
        for(Lottery lottery : listLottery){
            listTicket.add(lottery.getTicket());
        }
        map.put(key, listTicket);
        return new ResponseEntity<Object>(map, status);
    }
}
