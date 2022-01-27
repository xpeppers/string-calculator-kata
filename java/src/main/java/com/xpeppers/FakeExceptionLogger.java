package com.xpeppers;

public
class FakeExceptionLogger
	implements ILogger
{
	public
	void write(int value)
	{
		throw new RuntimeException("Errore di scrittura");
	}

}
