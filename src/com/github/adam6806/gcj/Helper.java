package com.github.adam6806.gcj;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Adam on 4/22/2015.
 */
public class Helper {

    public static ArrayList<Integer> convertToIntList(String[] nums) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(Integer.parseInt(nums[i]));
        }
        return numList;
    }

    public static ArrayList<BigInteger> convertToBigIntList(String[] nums) {
        ArrayList<BigInteger> numList = new ArrayList<BigInteger>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(BigInteger.valueOf(Integer.parseInt(nums[i])));
        }
        return numList;
    }

    public static int[] convertToIntArray(String[] prices) {
        int[] intPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            intPrices[i] = Integer.parseInt(prices[i]);
        }
        return intPrices;
    }
}
