import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Starter {

    public static void main(String [] args){

        System.out.println("Is string 'cry dry' is palindrome (with stream api): "+isPalindrome("cry dry"));
        System.out.println("Is string 'abcd dbca' is palindrome (with stream api): "+isPalindrome("abcd dcba"));
        System.out.println("Is string 'avv vaa' is palindrome (with stream api): "+isPalindrome("avv vaa"));
        System.out.println("\n");

        System.out.println("Is string 'cry dry' is palindrome (with sb): "+isPalindromWithSB("cry dry"));
        System.out.println("Is string 'abcd dbca' is palindrome (with sb): "+isPalindromWithSB("abcd dcba"));
        System.out.println("Is string 'avv vaa' is palindrome (with sb): "+isPalindromWithSB("avv vaa"));
        System.out.println("\n");

        System.out.println("Is string 'cry dry' is palindrome (with string only): "+isPalindromWithString("cry dry"));
        System.out.println("Is string 'abcd dbca' is palindrome (with string only): "+isPalindromWithString("abcd dcba"));
        System.out.println("Is string 'avv vaa' is palindrome (with string only): "+isPalindromWithString("avv vaa"));
        System.out.println("\n");


        List<String> list = Arrays.asList("cry dry", "abcd dcba", "avv vaa");
        Map<String, Boolean> result = new HashMap<>();

        for (int i = 0; i < list.size(); ++i) {
            for (int j = i; j < list.size(); ++j) {
                String candidate = list.get(j);
                Boolean temp = false;
                if (isPalindrome(candidate)){
                    temp = true;
                }
                result.put(candidate, temp);
            }
        }

        System.out.println("Map<String, Boolean>");
        for (Map.Entry<String, Boolean> entry : result.entrySet()) {
            System.out.println("Word = " + entry.getKey() + ", IsPalindrome = " + entry.getValue());
        }

    }

    public static boolean isPalindrome(String s){
        StringBuilder leftToright = new StringBuilder();
        s.chars().forEach(leftToright::appendCodePoint); //.filter(Character::isLetterOrDigit).map(Character::toLowerCase)
        StringBuilder rightToLeft = new StringBuilder(leftToright).reverse();
        return leftToright.toString().equals(rightToLeft.toString());
    }

    public static boolean isPalindromWithSB(String str){
        StringBuilder reverse = new StringBuilder(str).reverse();
        if (str.equals(String.valueOf(reverse))){
            return true;
        }
        return false;
    }

    public static boolean isPalindromWithString(String str) {

        for (int i = 0, j = str.length() - 1; j >= i; i++, j--) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
