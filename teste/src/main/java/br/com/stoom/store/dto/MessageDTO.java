package br.com.stoom.store.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MessageDTO {
    public static final String ZONE_ID = "America/Sao_Paulo";
    private int status;
    private String message;
    private LocalDateTime dateTime;

    public MessageDTO() {
        dateTime = ZonedDateTime.now(ZoneId.of(ZONE_ID)).toLocalDateTime();
    }

    public MessageDTO(int status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

}
