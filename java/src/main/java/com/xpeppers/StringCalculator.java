package com.xpeppers;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {

            List<Integer> numeri = getArrayInt(input);

            int result  = 0;
            for (int i : numeri){
                result += i;
            }
            return result;

    }

    private List<Integer> getArrayInt(String input) {

        if ("".equals(input))
            return new ArrayList<Integer>();

        String[] numeri = input.split(",");
        List<Integer> listaNumeri= new ArrayList<Integer>();

        for (int i=0; i< numeri.length;i++)
            listaNumeri.add(Integer.parseInt(numeri[i]));

        return listaNumeri;
    }

}
