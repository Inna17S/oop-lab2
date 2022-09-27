package main;
import java.util.regex.Pattern;
public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        String[] numbs = transform(numbers);
        StringBuilder negative = new StringBuilder();
        int s = 0;
        int n;
        for (String num : numbs) {
            try {
                n = Integer.parseInt(num);
            }
            catch (Exception e) {
                throw new RuntimeException("!ERROR!Invalid input format");
            }
            if (n < 0)
                negative.append(n).append(" ");
            else if (n <= 1000)
                s += n;
        }
        if (negative.length() > 0)
            throw new RuntimeException("Negative numbers : " + negative);
        return s;
    }

    private String[] transform(String numbers) {
        StringBuilder regex = new StringBuilder("\\\\n|,");
        if (numbers.startsWith("//")) {
            if (numbers.indexOf("\n") == numbers.length() - 1)
                return new String[]{"0"};
            String sum = "()[]{}+*.$?^|";
            if (numbers.charAt(3) == '\\' && numbers.charAt(4) == 'n') {
                regex.append("|").append(numbers.charAt(2));
                numbers = numbers.substring(5);
            }
            else {
                String[] delim = numbers.substring(3, numbers.indexOf("\\n") - 1).split("]\\[");
                regex.append("|");
                for (String d : delim){
                    for (int i = 0; i < d.length(); i++){
                        if (sum.contains(String.valueOf(d.charAt(i))))
                            regex.append("\\").append(d.charAt(i));
                        else
                            regex.append(d.charAt(i));
                    }
                    regex.append("|");
                }
                regex = new StringBuilder(regex.substring(0, regex.length() - 1));
                numbers = numbers.substring(numbers.indexOf("\\n") + 2);
            }
        }
        Pattern pattern = Pattern.compile(regex.toString());
        return pattern.split(numbers);
    }

}

