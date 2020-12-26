public class Main {

    public static void main(String[] args) {

        System.out.println("Alice");
        User alice = new User();
        System.out.println("Bob");
        User bob = new User();

        int message = 200;
        System.out.println("Отправленное сообщение: " + message);
        int messageSent = bob.encryptMessageFor(alice, message);
        System.out.println("Отправленное зашифрованное сообщение: " + messageSent);
        int decryptedMessage = alice.decryptMessage(messageSent);
        System.out.println("Полученное сообщение: " + decryptedMessage);

    }

}
