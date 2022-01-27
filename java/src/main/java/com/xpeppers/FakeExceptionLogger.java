package com.xpeppers;

public
class FakeExceptionLogger
	implements ILogger
{
	String errorMessage;

	public FakeExceptionLogger(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public
	void write(int value)
	{
		throw new RuntimeException(this.errorMessage);
	}

}
