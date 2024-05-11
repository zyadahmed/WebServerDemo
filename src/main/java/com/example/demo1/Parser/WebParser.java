package com.example.demo1.Parser;

import com.example.demo1.Container.EndPointsContainer;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class WebParser {
    String xmlLocation;
    public Document xmlFile;
    EndPointsContainer endPointsContainer;

    public WebParser(String xmlLocation) {
        this.xmlLocation = xmlLocation;
    }

    public void ParseFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        xmlFile = builder.parse(xmlLocation);


    }
}
