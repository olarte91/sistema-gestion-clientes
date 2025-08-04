package model;

import java.time.LocalDateTime;

public class UserAction {

    private String actionType;
    private LocalDateTime timestamp;

    public UserAction(String actionType, LocalDateTime timestamp) {
        this.actionType = actionType;
        this.timestamp = timestamp;
    }

}
