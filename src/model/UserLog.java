package model;

import java.time.LocalDateTime;

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
        return timestamp.toString();
    }
}
