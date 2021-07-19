package org.pabba.happycube;

public class Cube_Conversion {
    public static String decimalToBinary(int num) {

        StringBuilder output = new StringBuilder(Integer.toBinaryString(num));

        while (output.length() < 5) {
            output.insert(0, "0");
        }

        return output.toString();
    }
    public static int binaryToDecimal(String num) {
        return Integer.parseInt(num, 2);
    }
    public static String reverseBinary(String num) {
        StringBuilder binaryNum = new StringBuilder(num);
        return binaryNum.reverse().toString();
    }
}
