package com.example.Device.models;

import java.io.Serializable;

public class AddDeviceResponse  implements Serializable {
        private String message;

    public AddDeviceResponse(Exception err) {
    }

    public AddDeviceResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
