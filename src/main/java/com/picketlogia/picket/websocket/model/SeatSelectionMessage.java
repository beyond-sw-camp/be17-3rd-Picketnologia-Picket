package com.picketlogia.picket.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatSelectionMessage {
    private String seatName; // 유저 id
    private String sender;
    private String action; // "selecting", "available", "sold"
    private String seatIdx;
}
