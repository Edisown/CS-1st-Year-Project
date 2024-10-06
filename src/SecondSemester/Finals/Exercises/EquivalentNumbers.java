/**
 Name of programmer: Malasan, Edison M.
 Class Code and Schedule: 9322 A/B - (A)12:30 - 1:30 / (B)3:00 - 4:30
 Date: 17/03/2024
 */
package FirstYear.SecondSemester.Finals.Exercises;

public class EquivalentNumbers implements NumberConverter {
    private double decimalNumber; // decimal number form
    private String hexadecimalString; // hexadecimal number form
    private String binaryString; // binary number form
    private String octalString; // octal number form

    /**
     *Constructs an object representing the number 0
     **/
    public EquivalentNumbers() {
        decimalNumber = 0;
        hexadecimalString = "0";
        binaryString = "0";
        octalString = "0";
    }

    // constructor with parameters to set all fields
    public EquivalentNumbers(double d, String h, String b, String o) {
        decimalNumber = d;
        hexadecimalString = h;
        binaryString = b;
        octalString = o;
    }

    /**
     *Returns the decimal number form of an object of EquivalentNumbers
     **/
    public double getDecimalNumber() {
        return decimalNumber;
    }

    /**
     *Returns the hexadecimal number form of an object of EquivalentNumbers
     **/
    public String getHexadecimalString() {
        return hexadecimalString;
    }

    /**
     *Returns the binary number form of an object of EquivalentNumbers
     **/
    public String getBinaryString() {
        return binaryString;
    }

    /**
     *Returns the octal number form of an object of EquivalentNumbers
     **/
    public String getOctalString() {
        return octalString;
    }

    /**
     *Sets the decimal number, then the hexadecimal number, binary number and octal number
     *are set based on the decimal number.
     */
    public void setDecimalNumber(double d) {
        decimalNumber = d;
        hexadecimalString = convertToHex(decimalNumber);
        binaryString = convertToBinary(decimalNumber);
        octalString = convertToOctal(decimalNumber);
    }

    /**
     *Sets the hexadecimal number, then the decimal number, binary number and octal number
     *are set based on the hexadecimal number.
     */
    public void setHexadecimalString(String n) {
        hexadecimalString = n;
        decimalNumber = Double.parseDouble(convertToHex(Double.parseDouble(hexadecimalString)));
        binaryString = convertToBinary(decimalNumber);
        octalString = convertToOctal(decimalNumber);
    }

    /**
     *Sets the octal number, then the decimal number, binary number and hexadecimal number
     *are set based on the octal number.
     */
    public void setOctalString(String n) {
        octalString = n;
        decimalNumber = octalToDecimal(octalString);
        binaryString = convertToBinary(decimalNumber);
        hexadecimalString = convertToHex(decimalNumber);
    }

    /**
     *Sets the binary number, then the decimal number, octal number and hexadecimal number
     *are set based on the binary number.
     */
    public void setBinaryString(String b) throws Exception {
        binaryString = b;
        decimalNumber = binaryToDecimal(binaryString);
        octalString = convertToOctal(decimalNumber);
        hexadecimalString = convertToHex(decimalNumber);
    }

    /**
     *Returns the hexadecimal digit corresponding to a given number in the arranged 0 to 15
     **/
    public char hexDigit(byte digit){
        char r='0';
        switch (digit){

            case 0: r = '0'; break;
            case 1: r = '1'; break;
            case 2: r = '2'; break;
            case 3: r = '3'; break;
            case 4: r = '4'; break;
            case 5: r = '5'; break;
            case 6: r = '6'; break;
            case 7: r = '7'; break;
            case 8: r = '8'; break;
            case 9: r = '9'; break;
            case 10: r = 'A'; break;
            case 11: r = 'B'; break;
            case 12: r = 'C'; break;
            case 13: r = 'D'; break;
            case 14: r = 'E'; break;
            case 15: r = 'F'; break;
        }
        return r;
    }

    /**
     *Returns the decimal number corresponding to a given binary number
     **/
    public int binaryToDecimal(String b) throws Exception {
        int result = 0;
        if (!isValidBinaryString(b))
            throw new Exception("Invalid Binary Number");
        for (int i = 0; i < b.length(); i++) {
            result += Integer.parseInt("" + b.charAt(i)) * Math.pow(2, b.length() - 1 - i);
        }
        return result;
    }

    /**
     *Returns the decimal number corresponding to a given hexadecimal number
     **/
    public int hexadecimalToDecimal(String h) {
        int result = 0;
        for (int i = 0; i < h.length(); i++) {
            switch (h.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    result += Integer.parseInt("" + h.charAt(i)) * Math.pow(16, h.length() - 1 - i);
                    break;
                case 'a':
                case 'A':
                    result += 10 * Math.pow(16, h.length() - 1 - i);
                    break;
                case 'b':
                case 'B':
                    result += 11 * Math.pow(16, h.length() - 1 - i);
                    break;
                case 'c':
                case 'C':
                    result += 12 * Math.pow(16, h.length() - 1 - i);
                    break;
                case 'd':
                case 'D':
                    result += 13 * Math.pow(16, h.length() - 1 - i);
                    break;
                case 'e':
                case 'E':
                    result += 14 * Math.pow(16, h.length() - 1 - i);
                    break;
                case 'f':
                case 'F':
                    result += 15 * Math.pow(16, h.length() - 1 - i);
                    break;
            }
        }
        return result;
    }

    /**
     *Returns the decimal number corresponding to a given octal number
     **/
    public int octalToDecimal(String n) {
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            result += Integer.parseInt("" + n.charAt(i)) * Math.pow(8, n.length() - 1 - i);
        }
        return result;
    }

    /**
     *Returns a string showing a whole number with its decimal, binary, ocatal and hexadecimal form.
     **/
    public String toString() {
        String decimalStr = String.format("%.2f", decimalNumber);
        String binaryStr = binaryString.replace(".", "");
        return "Decimal Value = " + decimalStr + "\nBinary Value = " + binaryStr + "\nOctal Value = " +
                octalString + "\nHexadecimal Value = " + hexadecimalString;
    }

    /**
     *Returns true if this number is equivalent to another number.
     **/
    public boolean equals(EquivalentNumbers another) {
        return this.decimalNumber == another.getDecimalNumber();
    }
    private boolean isValidBinaryString(String s) {
        boolean result = true;
        for (int index = 0; index < s.length() && result; index++) {
            if (s.charAt(index) != '0' && s.charAt(index) != '1')
                result = false;
        }
        return result;
    }


    // Method to convert decimal with decimal point to hexadecimal
    private String convertToHex(double number){
        long intPart = (long) number; // Extract integer part
        double decimalPoint = number - intPart; // Extract decimal point part
        StringBuilder hexString = new StringBuilder(Long.toHexString(intPart)); // Convert integer part to hexadecimal

        // Add decimal point part if exists
        if (decimalPoint != 0) {
            hexString.append('.');
            int precision = 16;
            for (int i = 0; i < precision; i++) {
                decimalPoint *= 16; // Multiply fractional part by 16
                int digit = (int) decimalPoint; // Extract integer part of fractional part
                hexString.append(digit); // Append digit to hexadecimal string
                decimalPoint -= digit; // Subtract the digit from the fractional part
            }
        }

        return hexString.toString().toUpperCase(); // Convert to uppercase and return
    }

    // Method to convert decimal with decimal point to binary
    private String convertToBinary(double number) {
        long intPart = (long) number;
        double decimalPoint = number - intPart;
        StringBuilder binary = new StringBuilder(Long.toBinaryString(intPart));

        if (decimalPoint != 0) {
            binary.append('.');
            int precision = 10;
            for (int i = 0; i < precision; i++) {
                decimalPoint *= 2;
                int bit = (int) decimalPoint;
                binary.append(bit);
                decimalPoint -= bit;
            }
        }

        return binary.toString();
    }

    // Method to convert decimal with decimal point to octal
    private String convertToOctal(double number) {
        long intPart = (long) number;
        double decimalPoint = number - intPart;
        StringBuilder octal = new StringBuilder(Long.toOctalString(intPart));

        if (decimalPoint != 0) {
            octal.append('.');
            int precision = 10; // Adjust precision as needed
            for (int i = 0; i < precision; i++) {
                decimalPoint *= 8;
                int digit = (int) decimalPoint;
                octal.append(digit);
                decimalPoint -= digit;
            }
        }

        return octal.toString();
    }

}
