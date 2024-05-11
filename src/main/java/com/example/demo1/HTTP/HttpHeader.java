package com.example.demo1.HTTP;

import java.net.InetAddress;
import java.util.Date;

public interface HttpHeader {

        ContentType getContentType();
        String getContentLength();
        Date getRequestDate();
        HTTPMethod getHTTPMethod();


}
