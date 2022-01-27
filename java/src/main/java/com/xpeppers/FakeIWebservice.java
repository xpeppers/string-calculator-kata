package com.xpeppers;

public
class FakeIWebservice implements IWebservice
{
	String errorMessage;

	public
	void notifyError(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public
	String getErrorMessage()
	{
		return errorMessage;
	}
}
