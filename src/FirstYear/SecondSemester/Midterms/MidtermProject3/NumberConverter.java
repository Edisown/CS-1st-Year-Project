/**
 Name of programmer: Malasan, Edison M.
 Class Code and Schedule: 9322 A/B - (A)12:30 - 1:30 / (B)3:00 - 4:30
 Date: 17/03/2024
 */
package FirstYear.SecondSemester.Midterms.MidtermProject3;
/**
 Name of programmer: Bag-eo, Jim Hendrix T.
 Class Code and Schedule: 9322A/B CS 122/122L MTH/TF
 Date: March 16, 2024
 */

public interface NumberConverter {
    String decimalToBase(double number, byte base);
    String binaryToBase(String number, byte base) throws Exception;
    String hexadecimalToBase(String hexadecimalString, byte base);
    String octalToBase(String number, byte base);

}