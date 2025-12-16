package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserLog {
    private String action;
    private LocalDateTime timestamp;

    public UserLog(String action){
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    public String getAction(){
        return action;
    }

    public String getTimestamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timestamp.format(formatter);
    }
}
