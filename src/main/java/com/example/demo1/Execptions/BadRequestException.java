package com.example.demo1.Execptions;

import java.io.IOException;
import java.io.OutputStream;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message , OutputStream out) throws IOException {
        super(message);
        out.write("Error".getBytes());
    }
}
