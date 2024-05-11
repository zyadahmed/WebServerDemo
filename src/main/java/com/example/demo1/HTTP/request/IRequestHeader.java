package com.example.demo1.HTTP.request;

import com.example.demo1.HTTP.ContentType;
import com.example.demo1.HTTP.HTTPMethod;

import java.util.Map;

public interface IRequestHeader {
    Map<String, String> getHeaders();
    ContentType getContentType();
    HTTPMethod getHttpMethod();
    String getPath();
}
