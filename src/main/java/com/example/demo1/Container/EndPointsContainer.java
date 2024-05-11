package com.example.demo1.Container;

import java.util.HashMap;
import java.util.Map;

public class EndPointsContainer {
    private  final Map<String,Object> endpoints;
    private static final EndPointsContainer INSTANCE = new EndPointsContainer();



    public EndPointsContainer() {
        endpoints = new HashMap<>();
    }
    public static EndPointsContainer getInstance() {
        return INSTANCE;
    }

    public EndPointsContainer(Map<String, Object> endpoints) {
        this.endpoints = endpoints;
    }
    public Object retrieveServlet(String urlPattern){
        return endpoints.get(urlPattern) ;
    }
    public void addServlet(Map<String,Object> endpoints){
        this.endpoints.putAll(endpoints);
    }
    public void addServlet(String urlPattern, Object servlet) {
        endpoints.put(urlPattern, servlet);
    }

}