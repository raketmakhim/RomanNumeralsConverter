package com.company;

public class NumberConverter {

    private final char[] romanCharacterArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public static final int LOWER_LIMIT = 0;
    public static final int UPPER_LIMIT = 3999;

    public String generate(int numberToRomanNumerals) {

        int characterArrayTracker = 6;
        int decimalPosition = 1000;

        StringBuilder romanNumeral = new StringBuilder();

        while (numberToRomanNumerals != LOWER_LIMIT && numberToRomanNumerals <= UPPER_LIMIT){

            int quotientOfNumberToRomanNumerals = numberToRomanNumerals/decimalPosition;

            if (quotientOfNumberToRomanNumerals > 0){

                if (quotientOfNumberToRomanNumerals <= 3) {
                    //for cases when the digit is between 1 and 3
                    romanNumeral.append(appendMultipleCharacters(quotientOfNumberToRomanNumerals, characterArrayTracker));
                }
                else if (quotientOfNumberToRomanNumerals == 4) {

                    romanNumeral.append(romanCharacterArray[characterArrayTracker]);
                    romanNumeral.append(romanCharacterArray[characterArrayTracker + 1]);
                }
                else if (quotientOfNumberToRomanNumerals == 5) {

                    romanNumeral.append(romanCharacterArray[characterArrayTracker + 1]);
                }
                else if (quotientOfNumberToRomanNumerals <= 8) {
                    //for cases when the digit is between 5 and 8
                    romanNumeral.append(romanCharacterArray[characterArrayTracker + 1]);
                    romanNumeral.append(appendMultipleCharacters(quotientOfNumberToRomanNumerals - 5, characterArrayTracker));
                }
                else {

                    romanNumeral.append(romanCharacterArray[characterArrayTracker]);
                    romanNumeral.append(romanCharacterArray[characterArrayTracker + 2]);
                }
            }
            characterArrayTracker -= 2;
            numberToRomanNumerals = numberToRomanNumerals % decimalPosition;
            decimalPosition = decimalPosition/10;
        }

        //For when the input is not between 0 and 3999
        if (romanNumeral.toString().isBlank()){
            romanNumeral.append("Number not supported. Please enter numbers between 1 and 3999.");
        }
        return romanNumeral.toString();
    }

    //For the cases of when a number is between 1 and 3, and between 6 and 8
    //where same character needs to be appended multiple times.
    private String appendMultipleCharacters(int number, final int charPosition){
        StringBuilder romanNumeral = new StringBuilder();
        while (number != 0){
            romanNumeral.append(romanCharacterArray[charPosition]);
            number--;
        }
        return romanNumeral.toString();
    }
}
