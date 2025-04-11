import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    //Лабораторная 2
    public static void RockPaperScissors(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Выбирайте: 1)Камень, 2)Ножницы, 3)Бумага");

        int user_choise = scanner.nextInt();
        if(user_choise < 1) user_choise = 1;
        if(user_choise > 3) user_choise = 3;
        String user_object = (user_choise == 1) ? "Камень":
                (user_choise == 2) ? "Ножницы":
                        (user_choise == 3) ? "Бумага":
                                null;
        System.out.println("Ваш выбор: " + user_object);

        int computer_choice = random.nextInt(3)+1;
        String computer_object = (computer_choice == 1) ? "Камень":
                (computer_choice == 2) ? "Ножницы":
                        (computer_choice == 3) ? "Бумага":
                                null;
        System.out.println("Выбор компьютера: " + computer_object);

        System.out.print("Итоги игры: ");
        helpToPlayRPS(user_choise, computer_choice);
        System.out.println("Хотите сыграть еще? (да - 1, нет - 2)");
        if(scanner.nextInt() == 1)
            RockPaperScissors();
        else return;
    }

    public static void helpToPlayRPS(int choice_1, int choice_2) {
        if (choice_1 == choice_2)
            System.out.println("Ничья!");
        else if (choice_1 == 1 && choice_2 == 2)
            System.out.println("Вы выиграли!");
        else if (choice_1 == 2 && choice_2 == 3)
            System.out.println("Вы выиграли!");
        else if (choice_1 == 3 && choice_2 == 1)
            System.out.println("Вы выиграли!");
        else System.out.println("Вы проиграли!");
    }

    public static void main(String[] args) {
        //Вызов функции для второй лабораторной
        System.out.println("Сыграем в камень-ножницы-бумага?");
    }
}
