package com.xpeppers;

public
class FakeLogger
	implements ILogger
{
	int value;

	public
	void write(int value)
	{
		this.value = value;
	}

	public
	int getValue()
	{
		return value;
	}
}
