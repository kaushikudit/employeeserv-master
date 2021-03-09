package com.paypal.bfs.test.employeeserv.enums;

public enum ErrorCode {

    EMPLOYEE_NOT_FOUND(900, "The Employee you're searching for, is not present."),
    ERROR_IN_FETCHING_EMPLOYEE_DATA(901, "Something went wrong while fetching employee data."),
    ERROR_IN_ADDING_EMPLOYEE(902, "Something went wrong while adding employee data.");

    private Integer subErrorCode;
    private String message;

    ErrorCode(final Integer subErrorCode, final String message) {
        this.subErrorCode = subErrorCode;
        this.message = message;
    }

    public static ErrorCode getEnumByMessage(final String message) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getMessage().equalsIgnoreCase(message)) {
                return errorCode;
            }
        }
        return null;
    }

    public static ErrorCode getEnumBySubErrorCode(final Integer subErrorCode) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getSubErrorCode() == subErrorCode) {
                return errorCode;
            }
        }
        return null;
    }

    public Integer getSubErrorCode() {
        return subErrorCode;
    }

    public String getMessage() {
        return message;
    }
}
