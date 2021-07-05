package com.example.Device.models;

import java.io.Serializable;

public class AddDeviceTypeResponse implements Serializable {
    private String message;

    public AddDeviceTypeResponse(Exception err) {
    }

    public AddDeviceTypeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
