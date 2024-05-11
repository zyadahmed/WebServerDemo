package com.example.demo1.HTTP.request;

import com.example.demo1.HTTP.ContentType;
import com.example.demo1.HTTP.HTTPMethod;

import java.util.Map;
    public class RequestHeaderBuilder {
        private Map<String, String> headers;
        private ContentType contentType;
        private HTTPMethod httpMethod;
        private String path;

        public RequestHeaderBuilder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public RequestHeaderBuilder contentType(ContentType contentType) {
            this.contentType = contentType;
            return this;
        }

        public RequestHeaderBuilder httpMethod(HTTPMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public RequestHeaderBuilder path(String path) {
            this.path = path;
            return this;
        }

        public HTTPRequestHeader build() {
            return new HTTPRequestHeader(headers, contentType, httpMethod, path);
        }
    }

