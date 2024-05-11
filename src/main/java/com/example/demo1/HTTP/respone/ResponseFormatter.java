package com.example.demo1.HTTP.respone;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Set;

public class ResponseFormatter {
//    public static String formatResponse(HttpResponseImpl httpResponse) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("HTTP/1.1 ").append(httpResponse.s).append(" OK\n");
//        for (Map.Entry<String, String> entry : headers.entrySet()) {
//            builder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
//        }
//        builder.append("\n").append(content);
//        return builder.toString();
//    }

//    public static StringBuilder formatResponse(HttpServletResponse httpResponse) throws IOException {
//        StringBuilder respone = new StringBuilder();
//        respone.append("HTTP/1.1 ").append(httpResponse.getStatus()).append(" OK\n");
//        Set<String> headers = (Set<String>) httpResponse.getHeaderNames();
//        headers.forEach(e-> {
//            respone.append(e).append(":").append(httpResponse.getHeader(e)).append("\n");});
//        respone.append(httpResponse.getWriter());
//    return  respone;
//    }

    public static StringBuilder formatResponse(HttpServletResponse httpResponse) throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append(httpResponse.getStatus()).append(" OK\n");

        // Append headers
        Collection<String> headerNames = httpResponse.getHeaderNames();
        for (String headerName : headerNames) {
            response.append(headerName).append(": ").append(httpResponse.getHeader(headerName)).append("\n");
        }
        System.out.println("format response before print writer " + response);


        // Append data from writer, if present
        PrintWriter writer = httpResponse.getWriter();
        if (writer != null) {
            response.append("\n");
            response.append(readWriterContent(writer));
        }
        System.out.println("format response after print writer " + response);


        return response;
    }

    private static String readWriterContent(PrintWriter writer) {
        StringWriter stringWriter = new StringWriter();
        writer.flush();
        stringWriter.write(writer.toString());
        return stringWriter.toString();
    }

}
