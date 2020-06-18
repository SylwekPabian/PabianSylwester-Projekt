package com.example.nieruchomosci;

import java.util.ArrayList;
import java.util.List;

public class Session {
    public enum UserType {
        Anonymous,
        User,
        EstateManager
    }

    public static final Session instance = new Session();
    public UserType userType;

    public ViewPropertyData selectedPropertyData;

    private Session() {
        userType = UserType.Anonymous;
    }

    public void logout() {
        userType = UserType.Anonymous;
    }
}
