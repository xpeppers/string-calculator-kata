package com.xpeppers;

public class ILoggerImpl implements ILogger {
    @Override
    public void write(int sum) {
        System.out.print("sum:");
        System.out.print(sum);
        System.out.println("");
    }
}
