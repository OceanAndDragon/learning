public class code {

    public String intToRoman(int num) {
        int[] numbers = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        // loop through the table
        for (int i = 0; i < numbers.length && num > 0; i++) {
            while (num >= numbers[i]) {
                roman.append(symbols[i]);
                num -= numbers[i];
            }
        }
        return roman.toString();
    }

}