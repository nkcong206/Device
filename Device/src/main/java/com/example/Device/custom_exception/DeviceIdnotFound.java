package com.example.Device.custom_exception;

import org.springframework.security.core.AuthenticationException;

public class DeviceIdnotFound  extends AuthenticationException {
    public DeviceIdnotFound(String msg){
        super(msg);
    }
}
