package com.example.demo1.Parser;

import com.example.demo1.Container.EndPointsContainer;

import java.lang.reflect.InvocationTargetException;

public class ServletParser {
    EndPointsContainer endPointsContainer;
    ParserStrategy parserStrategy;
    public ServletParser(EndPointsContainer endPointsContainer, ParserStrategy parserStrategy) {
        this.endPointsContainer = endPointsContainer;
        this.parserStrategy = parserStrategy;
    }

    public ServletParser(ParserStrategy parserStrategy) {
        this.parserStrategy = parserStrategy;
    }
    public void Parsing() throws Exception {
        endPointsContainer.addServlet(parserStrategy.Parse());

    }

    public EndPointsContainer getEndPointsContainer() {
        return endPointsContainer;
    }
}

