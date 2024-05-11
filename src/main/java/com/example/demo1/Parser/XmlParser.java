package com.example.demo1.Parser;

import jakarta.servlet.http.HttpServlet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class XmlParser implements ParserStrategy{
    Document xmlFile;

    public XmlParser(Document xmlFile) {
        this.xmlFile = xmlFile;
    }
    @Override
    public Map<String, Object> Parse() throws Exception {
        NodeList servletMappingNodes = xmlFile.getElementsByTagName("servlet-mapping");
        NodeList servletNodes = xmlFile.getElementsByTagName("servlet");
        Map<String, String> servletClassMap = new HashMap<>();
        for (int i = 0; i < servletNodes.getLength(); i++) {
            Element servletElement = (Element) servletNodes.item(i);
            String servletName = servletElement.getElementsByTagName("servlet-name").item(0).getTextContent();
            String servletClass = servletElement.getElementsByTagName("servlet-class").item(0).getTextContent();
            servletClassMap.put(servletName, servletClass);
        }

        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < servletMappingNodes.getLength(); i++) {
            Element servletMappingElement = (Element) servletMappingNodes.item(i);
            String servletName = servletMappingElement.getElementsByTagName("servlet-name").item(0).getTextContent();
            String urlPattern = servletMappingElement.getElementsByTagName("url-pattern").item(0).getTextContent();
            String servletClassName = servletClassMap.get(servletName);
            if (servletClassName != null) {
                Class<?> servletClass = Class.forName(servletClassName);
                HttpServlet servletInstance = (HttpServlet) servletClass.getDeclaredConstructor().newInstance();
                result.put(urlPattern, servletInstance);
            }
        }
        return result;
    }


}