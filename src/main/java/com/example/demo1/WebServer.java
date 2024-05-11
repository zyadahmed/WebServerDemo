package com.example.demo1;

import com.example.demo1.Container.EndPointsContainer;
import com.example.demo1.HTTP.request.RequestBuilder;
import com.example.demo1.HTTP.respone.HttpResponseImpl;
import com.example.demo1.HTTP.respone.ResponseFormatter;
import com.example.demo1.Parser.ServletParser;
import com.example.demo1.Parser.WebParser;
import com.example.demo1.Parser.XmlParser;
import com.example.demo1.dispatchers.ServletDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private final int port;
    private final String webXmlLocation;
    private final EndPointsContainer endPointsContainer;
    private  ServletDispatcher servletDispatcher;

    public WebServer(int port, String webXmlLocation) {
        this.port = port;
        this.webXmlLocation = webXmlLocation;
        this.endPointsContainer = new EndPointsContainer();
    }

    public void start() throws Exception {
        WebParser webParser = new WebParser(webXmlLocation);
        webParser.ParseFile();

        ServletParser servletParser = new ServletParser(endPointsContainer, new XmlParser(webParser.xmlFile));
        servletParser.Parsing();
        servletDispatcher = new ServletDispatcher(servletParser.getEndPointsContainer());
        HttpServlet httpServlet = servletDispatcher.findBestMatchServlet("/hello");

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);



        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            handleClientRequest(clientSocket);
        }
    }



    private void handleClientRequest(Socket clientSocket) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), false)) {
            System.out.println("my test");
            StringWriter writer = new StringWriter();
            StringBuilder requestBuilder = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                requestBuilder.append(line).append("\n");
                if (line.isEmpty()) {
                    break;
                }
            }
            String request = requestBuilder.toString().trim();
            System.out.println("Request received (Headers):");
            System.out.println(request);

            StringBuilder payloadBuilder = new StringBuilder();
            while (in.ready()) {
                payloadBuilder.append((char) in.read());
            }
            String payload = payloadBuilder.toString().trim();
            System.out.println("Request received (Payload):");
            System.out.println(payload);

            RequestBuilder requestBuilder1 = new RequestBuilder(request, payload, out);
            HttpServletRequest httpServletRequest = requestBuilder1.getRequest();

            HttpResponseImpl httpResponse = new HttpResponseImpl(out);

            httpResponse.setHeader("Content-Type", "text/html");
            httpResponse.setDateHeader("Date", System.currentTimeMillis());

            HttpServlet httpServlet = servletDispatcher.findBestMatchServlet(httpServletRequest.getRequestURI());
            if (httpServlet != null) {
                httpServlet.service(httpServletRequest, httpResponse);
                out.flush();
            } else {
                out.print("HTTP/1.1 404 Not Found\n\n");
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            clientSocket.close();
            System.out.println("Client disconnected");
        }
    }





    public static void main(String[] args) throws Exception {
        int port = 8080;
        String webXmlLocation = "./src/main/webapp/WEB-INF/web.xml";

        WebServer webServer = new WebServer(port, webXmlLocation);
        webServer.start();
    }
}
