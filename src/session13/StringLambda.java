package session13;

public class StringLambda {
    public static void main(String[] args) {
        String value = "Tung juve nga     BAFF";
        StringToInt words = str -> str.split("\\s+").length;
        System.out.printf("Number of words: %d%n",words.convert(value));

        StringToInt length = str -> str.length();
        System.out.printf("Length: %d%n",length.convert(value));
    }
}

interface StringToInt {
    int convert(String str);
}
