import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите пароль для первой карты: ");
            int password_1 = scanner.nextInt();

            System.out.println("Введите пароль для второй карты: ");
            int password_2 = scanner.nextInt();

            Card card_1 = new Card(1234, 111111111, password_1);
            Card card_2 = new Card(1234, 123432123, password_2);
            ATM atm = new ATM(12345678, 12345);
            SimCard simCard = new SimCard("+79181231233");

            card_1.DepositMoney(atm);
            card_1.WithdrawMoney(atm);
            card_1.TransferToCard(card_2);
            card_1.DepositMoneyIntoSimCard(simCard);
            card_1.CardInfo();
            card_2.CardInfo();
            atm.PrintInfoAboutATM();
        }
        catch (Exception e){
            System.err.println("Ошибка!\n" + e.getMessage());
        }
    }
}