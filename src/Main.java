public class Main {
    public static StringBuilder encryptionForTheEnglishAlphabet(String message, int key){
        StringBuilder stringBuilder = new StringBuilder();
        for(char character: message.toCharArray()){
            if(Character.isLowerCase(character)){
                int originalPosition = character - 'a'  ;
                int newPosition = (originalPosition + key) % 26;
                char newCharacter = (char)('a'+newPosition);
                stringBuilder.append(newCharacter);
            }
            else if (Character.isUpperCase(character)) {
                int originalPosition = character - 'A'  ;
                int newPosition = (originalPosition + key) % 26;
                char newCharacter = (char)('A'+newPosition);
                stringBuilder.append(newCharacter);
            }
            else{
                stringBuilder.append(character);
            }
        }
        return stringBuilder;
    }

    public static StringBuilder encryptionForTheRussianAlphabet(String message, int key){
        StringBuilder stringBuilder = new StringBuilder();
        for(char character: message.toCharArray()){
            if(Character.isLowerCase(character)){
                int originalPosition = character -'а';
                int newPosition = (originalPosition + key) % 33;
                char newCharacter = (char)('а'+newPosition);
                stringBuilder.append(newCharacter);
            } else if (Character.isUpperCase(character)) {
                int originalPosition = character -'А';
                int newPosition = (originalPosition + key) % 33;
                char newCharacter = (char)('А'+newPosition);
                stringBuilder.append(newCharacter);
            } else{
                stringBuilder.append(character);
            }
        }
        return stringBuilder;
    }

    public static StringBuilder englishAlphabetDecoder(String message, int key){
        return encryptionForTheEnglishAlphabet(message,26-(key % 26));
    }


    public static StringBuilder russianhAlphabetDecoder(String message, int key){
        return encryptionForTheRussianAlphabet(message,33-(key % 33));
    }

    public static void hackingTheEnglishAlphabet(String encryptedMessage){
        for (int key = 0; key < 26; key++) {
            StringBuilder decryptedMessage = encryptionForTheEnglishAlphabet(encryptedMessage, 26-key);
            System.out.println("Ключ: " + key + " - Сообщение: " + decryptedMessage);
        }
    }

    public static void hackingTheRussianAlphabet(String encryptedMessage){
        for (int key = 0; key < 33; key++) {
            StringBuilder decryptedMessage = encryptionForTheRussianAlphabet(encryptedMessage, 33-key);
            System.out.println("Ключ: " + key + " - Сообщение: " + decryptedMessage);
        }
    }




    public static void main(String[] args) {
        System.out.println(encryptionForTheEnglishAlphabet("Hello", 3));
        System.out.println(encryptionForTheRussianAlphabet("Привет Олег", 3));
        System.out.println(englishAlphabetDecoder("Khoor",3));
        System.out.println(russianhAlphabetDecoder("Тулеих Соиж", 3));
        hackingTheEnglishAlphabet("Khoor");

        hackingTheRussianAlphabet("Тулеих");
    }
}
