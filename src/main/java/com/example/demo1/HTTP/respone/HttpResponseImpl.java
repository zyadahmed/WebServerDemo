package com.example.demo1.HTTP.respone;

import com.example.demo1.HTTP.HTTPMethod;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class HttpResponseImpl implements HttpServletResponse {
    private HTTPMethod httpMethod;
    private final Map<String, String> headers = new HashMap<>();
    private final StringBuilder content = new StringBuilder();
    private PrintWriter writer;

    public HttpResponseImpl(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void addCookie(Cookie cookie) {

    }

    @Override
    public boolean containsHeader(String s) {
        return headers.containsKey(s);
    }

    @Override
    public String encodeURL(String s) {
        return null;
    }

    @Override
    public String encodeRedirectURL(String s) {
        return null;
    }

    @Override
    public String encodeUrl(String s) {
        return null;
    }

    @Override
    public String encodeRedirectUrl(String s) {
        return null;
    }

    @Override
    public void sendError(int i, String s) throws IOException {

    }

    @Override
    public void sendError(int i) throws IOException {

    }

    @Override
    public void sendRedirect(String s) throws IOException {

    }

    @Override
    public void setDateHeader(String s, long l) {
            headers.put("Date", String.valueOf(l));
    }

    @Override
    public void addDateHeader(String s, long l) {
        headers.put("Date", String.valueOf(l));

    }

    @Override
    public void setHeader(String s, String s1) {
        headers.put(s, s1);

    }

    @Override
    public void addHeader(String s, String s1) {
        headers.put(s, s1);

    }

    @Override
    public void setIntHeader(String s, int i) {
        headers.put(s, String.valueOf(i));

    }

    @Override
    public void addIntHeader(String s, int i) {
        headers.put(s, String.valueOf(i));

    }

    @Override
    public void setStatus(int i) {

    }

    @Override
    public void setStatus(int i, String s) {

    }

    @Override
    public int getStatus() {
        return 200;
    }

    @Override
    public String getHeader(String s) {
        return headers.get(s);
    }

    @Override
    public Collection<String> getHeaders(String s) {
        return headers.containsKey(s) ? List.of(headers.get(s)) : null;
    }

    @Override
    public Collection<String> getHeaderNames() {
        return headers.keySet();
    }

    @Override
    public String getCharacterEncoding() {
        return getHeader("Content-Type");
    }

    @Override
    public String getContentType() {
        return getHeader("Content-Type");
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append("200").append(" OK\n");

        Collection<String> headerNames = this.getHeaderNames();
        for (String headerName : headerNames) {
            response.append(headerName).append(": ").append(this.getHeader(headerName)).append("\n");
        }
        System.out.println("format response before print writer " + response);
            writer.append(response);

        if (writer != null) {
            response.append("\n");
            return writer;
        }else {
            throw new NullPointerException("writer exception");
        }

    }

    @Override
    public void setCharacterEncoding(String s) {

    }

    @Override
    public void setContentLength(int i) {

    }

    @Override
    public void setContentLengthLong(long l) {

    }

    @Override
    public void setContentType(String s) {
        setHeader("Content-Type", s);

    }

    @Override
    public void setBufferSize(int i) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
