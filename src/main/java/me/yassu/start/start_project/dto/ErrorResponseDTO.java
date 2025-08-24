package me.yassu.start.start_project.dto;

public class ErrorResponseDTO {

    private int statusCode;
    private String status;
    private String errorMessage;

    public ErrorResponseDTO(int statusCode, String status, String errorMessage) {
        this.statusCode = statusCode;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
