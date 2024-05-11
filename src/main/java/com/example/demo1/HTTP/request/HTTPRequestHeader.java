package com.example.demo1.HTTP.request;

import com.example.demo1.HTTP.ContentType;
import com.example.demo1.HTTP.HTTPMethod;

import java.util.Map;

public class HTTPRequestHeader implements IRequestHeader {
    private  Map<String, String> headers;
    private ContentType contentType;
    private HTTPMethod httpMethod;
    private String path;


    public HTTPRequestHeader(Map<String, String> headers, ContentType contentType, HTTPMethod httpMethod, String path) {
        this.headers = headers;
        this.contentType = contentType;
        this.httpMethod = httpMethod;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public HTTPMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HTTPMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

}
