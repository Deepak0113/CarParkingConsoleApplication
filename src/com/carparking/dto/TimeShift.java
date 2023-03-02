package com.carparking.dto;

import java.time.LocalDateTime;

public class TimeShift {
    private LocalDateTime startLocalDateTime;
    private LocalDateTime endLocalDateTime;

    public TimeShift(LocalDateTime startLocalDateTime){
        this.startLocalDateTime = startLocalDateTime;
    }

    public void setEndLocalDateTime(LocalDateTime endLocalDateTime) {
        this.endLocalDateTime = endLocalDateTime;
    }
}
