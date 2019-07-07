package com.online.market.service.exception;

public class OnlineMarketServiceException extends RuntimeException {

    public OnlineMarketServiceException(String message) {
        super(message);
    }

    public OnlineMarketServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OnlineMarketServiceException(Throwable cause) {
        super(cause);
    }

    public OnlineMarketServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
