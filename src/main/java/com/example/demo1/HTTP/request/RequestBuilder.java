package com.example.demo1.HTTP.request;

import com.example.demo1.HTTP.ContentType;
import com.example.demo1.HTTP.HTTPMethod;
import jakarta.servlet.http.HttpServletRequest;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    private final String rawHeader;
    private  final String rawPayload;
    private final PrintWriter printWriter;

    public RequestBuilder(String rawHeader, String rawPayload, PrintWriter printWriter) {
        this.rawHeader = rawHeader;
        this.rawPayload = rawPayload;
        this.printWriter = printWriter;
    }


    public HttpServletRequest getRequest(){
        HTTPRequestHeader requestHeader =parseHreader(rawHeader);
        HttpServletRequest httpRequest = new HttpRequestBuilder().setRequestHeader(requestHeader).setRawPayload(rawPayload).setPrintWriter(printWriter).build();
        return httpRequest;
    }

    private HTTPRequestHeader parseHreader(String rawHeader) {
        String[] lines = rawHeader.split("\n");
        String[] firstline =  lines[0].split(" ",3);
        HTTPMethod httpMethod =HTTPMethod.valueOf(firstline[0]);
        Map<String, String> headers = new HashMap<>();
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            int index = line.indexOf(':');
            if (index != -1) {
                String name = line.substring(0, index).trim();
                String value = line.substring(index + 1).trim();
                headers.put(name, value);
            }
        }
        String path = firstline[1];
        ContentType contentType = ContentType.text;

        return new RequestHeaderBuilder().headers(headers)
                .contentType(contentType)
                .httpMethod(httpMethod)
                .path(path)
                .build();
    }



}
