package com.example.demo1.dispatchers;

import com.example.demo1.Container.EndPointsContainer;
import jakarta.servlet.http.HttpServlet;

public class ServletDispatcher implements Dispatcher{
    private final EndPointsContainer container;

    public ServletDispatcher(EndPointsContainer container) {
        this.container = container;
    }
    public HttpServlet findBestMatchServlet(String urlPattern){
        return (HttpServlet) container.retrieveServlet(urlPattern);

    }
}
