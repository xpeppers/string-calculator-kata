package com.xpeppers;

public class TestExceptionLogger implements ILogger{
    private String printed;

    @Override
    public void write(int sum) {
        throw new RuntimeException("too lazy to log!");
    }

    public String getPrinted() {
        return printed;
    }
}
