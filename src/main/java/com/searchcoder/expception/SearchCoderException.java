package com.searchcoder.expception;

public class SearchCoderException extends Throwable {

	private static final long serialVersionUID = 1L;

	public SearchCoderException() {
	}

	public SearchCoderException(String message) {
		super(message);
	}

	public SearchCoderException(Throwable cause) {
		super(cause);
	}

	public SearchCoderException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearchCoderException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
