/**
 * Created by Benjamin Ehlers on 12/25/2018.
 */
public class AlphabetCipher {

    public static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                                        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        String keyword = args[0];
        String message = args[1];
        char[] keywordArray = keyword.toCharArray();
        String keywordRepeated = "";
        String encryptedMessage = "";

        for(int i = 0; i < message.length(); i++) {
            keywordRepeated+= keywordArray[i % keyword.length()];
        }

        for(int i = 0; i < message.length(); i++) {
            char[][] alphabetGrid = alphabetGrid();
            int indexOfMessage = indexOf(message.charAt(i));
            int indexOfKeywordRepeated = indexOf(keywordRepeated.charAt(i));
            encryptedMessage+=alphabetGrid[indexOfMessage][indexOfKeywordRepeated];
        }

        System.out.println(encryptedMessage);

    }

    public static char[][] alphabetGrid() {
        char[][] alphabetGrid = new char[26][26];

        for(int i = 0; i < 26; i++) {
            for(int j = 0 + i; j < 26 + i; j++) {
                alphabetGrid[i][j % 26] = alphabet[(j+i)%26];
            }
        }
        return alphabetGrid;
    }

    public static int indexOf(char c) {

        for(int i = 0; i < 26; i++) {
            if(c == alphabet[i]) return i;
        }
        return 0;
    }

}
