package com.example.demo1.dispatchers;

import jakarta.servlet.http.HttpServlet;

public interface Dispatcher {
    public HttpServlet findBestMatchServlet(String urlPattern);
}
