import java.util.Random;
import java.util.Scanner;

public class Lab3 {
    //Лабораторная 3
    public static void RockPaperScissorsLizardSpock(int[] scores){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Выбирайте: 1)Камень, 2)Ножницы, 3)Бумага, 4)Ящерица, 5)Спок");
        int user_choise = scanner.nextInt();
        if(user_choise < 1) user_choise = 1;
        if(user_choise > 5) user_choise = 5;
        String user_object = (user_choise == 1) ? "Камень":
                (user_choise == 2) ? "Ножницы":
                        (user_choise == 3) ? "Бумага":
                                (user_choise == 4) ? "Ящерица":
                                        (user_choise == 5) ? "Спок":
                                                null;
        System.out.println("Ваш выбор: " + user_object);

        int computer_choice = random.nextInt(5)+1;
        String computer_object = (computer_choice == 1) ? "Камень":
                (computer_choice == 2) ? "Ножницы":
                        (computer_choice == 3) ? "Бумага":
                                (computer_choice == 4) ? "Ящерица":
                                        (computer_choice == 5) ? "Спок":
                                                null;
        System.out.println("Выбор компьютера: " + computer_object);

        System.out.print("Итоги игры: ");
        helpToPlayRPCLS(user_choise, computer_choice,scores);

        System.out.println("Хотите сыграть еще? (да - 1, нет - 2)");
        if(scanner.nextInt() == 1)
            RockPaperScissorsLizardSpock(scores);
        else return;
    }

    public static void helpToPlayRPCLS(int choice_1, int choice_2, int[] scores){
        if(choice_1 == choice_2)
            System.out.println("Ничья!");

        else if ((choice_1 == 1 && (choice_2 == 2 || choice_2 == 4)) ||
                (choice_1 == 2 && (choice_2 == 3 || choice_2 == 4)) ||
                (choice_1 == 3 && (choice_2 == 1 || choice_2 == 5)) ||
                (choice_1 == 4 && (choice_2 == 3 || choice_2 == 5)) ||
                (choice_1 == 5 && (choice_2 == 1 || choice_2 == 2))) {
            System.out.println("Вы победили!");
            scores[0]++;
        }

        else {
            System.out.println("Вы проиграли!");
            scores[1]++;
        }

        System.out.println("Текущий счет: " + scores[0] + "|" + scores[1]);
    }

    public static void main(String[] args) {
        //Вызов функции для третьей лабораторной
        System.out.println("Сыграем в камень-ножницы-бумага-ящерица-спок?");
        int[] scores = {0,0};
        RockPaperScissorsLizardSpock(scores);
    }
}
