package com.xpeppers;

public class TestLogger implements ILogger{
    private String printed;

    @Override
    public void write(int sum) {
        printed = String.valueOf(sum);
    }

    public String getPrinted() {
        return printed;
    }
}
