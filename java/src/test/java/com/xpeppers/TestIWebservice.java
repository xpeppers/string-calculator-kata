package com.xpeppers;

public class TestIWebservice implements IWebservice{

    private boolean notified;

    @Override
    public void msg(String message) {
        notified = true;
    }

    public boolean hasNotified() {
       return notified;
    }
}
