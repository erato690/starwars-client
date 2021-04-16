package com.starwars.client.exception;


public class SingleLoadRequestAsync extends RuntimeException {


    public SingleLoadRequestAsync() {
    }

    public SingleLoadRequestAsync(String message) {
        super(message);
    }

    public SingleLoadRequestAsync(String message, Throwable cause) {
        super(message, cause);
    }

    public SingleLoadRequestAsync(Throwable cause) {
        super(cause);
    }

    public SingleLoadRequestAsync(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
