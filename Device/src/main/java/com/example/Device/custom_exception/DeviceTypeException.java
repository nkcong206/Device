package com.example.Device.custom_exception;

import org.springframework.security.core.AuthenticationException;

public class DeviceTypeException extends AuthenticationException {
    public DeviceTypeException(String msg) {
        super(msg);
    }
}
