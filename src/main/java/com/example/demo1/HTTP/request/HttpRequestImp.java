package com.example.demo1.HTTP.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

public class HttpRequestImp implements HttpServletRequest {
    private final IRequestHeader requestHeader;
    private final String rawPayload;
    JSONObject payloadObject;
    Map<String,Object> payloadMap;
    PrintWriter output;

    public HttpRequestImp(IRequestHeader requestHeader, String rawPayload, PrintWriter outPutWriter) {
        this.requestHeader = requestHeader;
        this.rawPayload = rawPayload;
        parsePayload(rawPayload);
        this.output = outPutWriter;


    }

    private void parsePayload(String rawPayload)  {
        try {

            JSONParser parser = new JSONParser();
            if (!rawPayload.isEmpty()) {
                JSONObject payloadObject = (JSONObject) parser.parse(rawPayload);
                payloadObject.keySet().forEach(e -> payloadMap.put((String) e, payloadObject.get(e)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }


    @Override
    public String getAuthType() {
        return null;
    }

    @Override
    public Cookie[] getCookies() {
        return new Cookie[0];
    }

    @Override
    public long getDateHeader(String s) {
        return 0;
    }

    @Override
    public String getHeader(String s) {
        return requestHeader.getHeaders().get(s);
    }

    @Override
    public Enumeration<String> getHeaders(String s) {
        return Collections.enumeration(requestHeader.getHeaders().keySet());
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return Collections.enumeration(requestHeader.getHeaders().keySet());
    }

    @Override
    public int getIntHeader(String s) {
        return Integer.parseInt(requestHeader.getHeaders().get(s));
    }

    @Override
    public String getMethod() {
        System.out.println(requestHeader.getHttpMethod().name());
        return requestHeader.getHttpMethod().name().strip().toUpperCase();
    }

    @Override
    public String getPathInfo() {
        return requestHeader.getPath();
    }

    @Override
    public String getPathTranslated() {
        return null;
    }

    @Override
    public String getContextPath() {
        return null;
    }

    @Override
    public String getQueryString() {
        return null;
    }

    @Override
    public String getRemoteUser() {
        return null;
    }

    @Override
    public boolean isUserInRole(String s) {
        return false;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public String getRequestedSessionId() {
        return null;
    }

    @Override
    public String getRequestURI() {
        return requestHeader.getPath();
    }

    @Override
    public StringBuffer getRequestURL() {
        return null;
    }

    @Override
    public String getServletPath() {
        return null;
    }

    @Override
    public HttpSession getSession(boolean b) {
        return null;
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public String changeSessionId() {
        return null;
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override
    public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
        return false;
    }

    @Override
    public void login(String s, String s1) throws ServletException {

    }

    @Override
    public void logout() throws ServletException {

    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return null;
    }

    @Override
    public Part getPart(String s) throws IOException, ServletException {
        return null;
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return payloadMap.get(s);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return (Enumeration<String>) payloadMap.keySet();
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    @Override
    public int getContentLength() {
        return rawPayload.length();
    }

    @Override
    public long getContentLengthLong() {
        return rawPayload.length();
    }

    @Override
    public String getContentType() {
        return requestHeader.getContentType().toString();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            private int index = 0;

            @Override
            public boolean isFinished() {
                return index >= rawPayload.length();
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }

    @Override
    public String getParameter(String s) {
        return (String) payloadMap.get(s);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String s) {
        return new String[0];
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return null;
    }

    @Override
    public String getProtocol() {
        return "HTTP";
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

         payloadMap.put(s,o);

    }

    @Override
    public void removeAttribute(String s) {
        payloadMap.remove(s);
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
        return null;
    }

    @Override
    public String getRealPath(String s) {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getLocalName() {
        return null;
    }

    @Override
    public String getLocalAddr() {
        return null;
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    @Override
    public boolean isAsyncStarted() {
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }

    @Override
    public AsyncContext getAsyncContext() {
        return null;
    }

    @Override
    public DispatcherType getDispatcherType() {
        return null;
    }
}
