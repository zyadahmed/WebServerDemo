package com.example.demo1.HTTP;

public enum HTTPStatus {
    OK(200,"OK"),
    BAD_REQUEST(400,"Bad Request"),
    NOT_FOUND(404,"Not Found"),
    PERM_REDIRECT(301,"Permanent Redirect"),
    TEMP_REDIRECT(302,"Temporary Redirect");


    private final int codeStatus;
    private final String codeDescription;


    HTTPStatus(int codeStatus, String codeDescription) {
        this.codeStatus = codeStatus;
        this.codeDescription = codeDescription;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public String getCodeDescription() {
        return codeDescription;
    }
}
