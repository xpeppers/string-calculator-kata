package com.xpeppers.scalc;

import com.xpeppers.ILoggerImpl;
import com.xpeppers.IWebservice;
import com.xpeppers.NegativeNumbersGuard;
import com.xpeppers.StringCalculator;

import java.io.FileOutputStream;

public class Scalc {
    private static Printer printer;

    public Scalc(Printer printer) {
        Scalc.printer = printer;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new NegativeNumbersGuard(), new ILoggerImpl(), new IWebservice() {
            @Override
            public void msg(String message) {

            }
        });
        printer.print("The result is " + stringCalculator.add(args[1]));
    }
}
