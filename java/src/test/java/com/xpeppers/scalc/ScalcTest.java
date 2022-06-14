package com.xpeppers.scalc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.singletonList;

public class ScalcTest {

    private Scalc scalc;
    private TestPrinter printer;

    @Before
    public void init() {
        printer = new TestPrinter();
        scalc = new Scalc(printer);
    }

    @Test
    public void x() {
        scalc.main(new String[]{"scalc", "1,2,3"});
        Assert.assertEquals("The result is 6", printer.getOutputString());
    }

    private class TestPrinter implements Printer {
        private String outputString;

        public String getOutputString() {
            return outputString;
        }

        @Override
        public void print(String message) {
            outputString = message;
        }
    }
}
