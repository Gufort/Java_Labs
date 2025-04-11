import ATM_Machine.ATM;
import ATM_Machine.Card;
import ATM_Machine.SimCard;
import FightLogic.Knight;
import FightLogic.Wizard;

import java.util.Random;
import java.util.Scanner;

import ATM_Machine.*;
import FightLogic.*;
import Lab1to4.*;

public class EntryPoint {

    public static int playerInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите число (выбор нужного приложения): ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= 0) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Ошибка: введите целое неотрицательное число!");
        }
    }


    public static void FifthApp() {
        boolean startAttackFlag = true;
        Wizard player_1 = new Wizard("Ахилесс");
        System.out.println("Здравствуй, " + player_1.getName() + "!");
        Knight player_2 = new Knight("Максим");
        System.out.println("Здравствуй, " + player_2.getName() + "!");
        Random random = new Random();
        int count = 1;
        System.out.println("Начинаем бой!\n");

        while(true) {
            System.out.println("Круг " + count + "!");
            int rnd = random.nextInt(100);
            player_1.Attack(player_2);
            String var10001;
            
            if (player_2._isDeath) {
                var10001 = player_1._playerClass;
                System.out.println(var10001 + player_1.getName() + " победил!");
                player_1.checkState();
                break;
            }

            player_2.Attack(player_1);
            if (player_1._isDeath) {
                var10001 = player_2._playerClass;
                System.out.println(var10001 + player_2.getName() + " победил!");
                player_2.checkState();
                break;
            }

            if (rnd >= 80) {
                player_1.Rest();
            } else if (rnd >= 20 && rnd <= 60) {
                player_1.Meditation();
            } else if (rnd <= 50 && rnd >= 20) {
                player_1.HealingSpell();
            }

            rnd = random.nextInt(100);
            if (rnd >= 80) {
                player_2.Rest();
            } else if (rnd >= 70) {
                player_2.Meditation();
            } else if (rnd <= 50 && rnd >= 20) {
                player_2.HealingSpell();
            }

            ++count;
            System.out.println();
        }
    }

    public static void SixApp(){
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

    public static void pressEnterToContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nНажмите Enter чтобы продолжить...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void main(String[] args){

        try{
            boolean closeApp = false;

            while(!closeApp){
                System.out.println("Выберете нужное приложение: \n" +
                        "1) Индекс массы тела;\n"+
                        "2) Камень-ножницы-бумага;\n"+
                        "3) Камень-ножницы-бумага-ящерица-спок;\n"+
                        "4) Генерация предложений из предложенных фраз;\n"+
                        "5) Боевая логика;\n"+
                        "6) Банкомат и карты;\n"+
                        "0) Выход;\n");

                int userChoice = playerInput();

                switch (userChoice) {
                    case 1:
                        Lab1to4.Lab_1.PrintBodyMassIndex();
                        break;

                    case 2:
                        System.out.println("Сыграем в камень-ножницы-бумага?");
                        Lab1to4.Lab_2.RockPaperScissors();
                        break;

                    case 3:
                        System.out.println("Сыграем в камень-ножницы-бумага-ящерица-спок?");
                        int[] scores = {0,0};
                        Lab1to4.Lab_3.RockPaperScissorsLizardSpock(scores);
                        break;

                    case 4:
                        Lab1to4.Lab_4.makeRandomString();
                        break;

                    case 5:
                        FifthApp();
                        break;

                    case 6:
                        SixApp();
                        break;

                    case 0:
                        closeApp = true;
                        break;

                    default:
                        System.out.println("Неверный выбор!");
                        pressEnterToContinue();
                }
            }
        }

        catch (Exception e){
            System.out.println("Ошибка!\n" + e.getMessage());
        }
    }
}
