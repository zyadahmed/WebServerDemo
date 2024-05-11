package com.example.demo1.HTTP.request;

import java.io.PrintWriter;

public class HttpRequestBuilder {
    private IRequestHeader requestHeader;
    private String rawPayload;
    PrintWriter printWriter;

    public HttpRequestBuilder setRequestHeader(IRequestHeader requestHeader) {
        this.requestHeader = requestHeader;
        return this;
    }

    public HttpRequestBuilder setRawPayload(String rawPayload) {
        this.rawPayload = rawPayload;
        return this;
    }

    public HttpRequestBuilder setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
        return this;
    }

    public HttpRequestImp build() {
        return new HttpRequestImp(requestHeader, rawPayload,printWriter);
    }
}

