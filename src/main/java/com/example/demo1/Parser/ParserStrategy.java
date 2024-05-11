package com.example.demo1.Parser;

import org.w3c.dom.Document;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;

public interface ParserStrategy {
    Map<String,Object> Parse() throws Exception;
}
