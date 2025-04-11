import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //Лабораторная 1
    public static void PrintBodyMassIndex(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для того, чтобы посчитать индекс массы тела, нам необходимо узнать ваш вес и рост");

        System.out.println("Пожалуйста, введите ваш рост (в сантиметрах): ");
        int height = scanner.nextInt();
        System.out.println(height);
        System.out.println("Пожалуйста, введите ваш вес (в килограммах): ");
        int weight = scanner.nextInt();

        double heightInMetres = height/100.0;
        double BOI = weight/Math.pow(heightInMetres,2);
        System.out.println("Ваш индекс массы тела - " + BOI);

        if(BOI<=16) System.out.println("Наблюдается выраженный дефицит массы тела");
        if(BOI>16 && BOI<=18.5) System.out.println("Наблюдается дефицит массы тела");
        if(BOI>18.5 && BOI<=25) System.out.println("Это нормальные значения");
        if(BOI>25 && BOI<=30) System.out.println("Наблюдается избыточная масса тела");
        if(BOI>30 && BOI<=35) System.out.println("Ожирение I степени");
        if(BOI>35 && BOI<=40) System.out.println("Ожирение II степени");
        if(BOI>40) System.out.println("Ожирение III степени");
    }



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



    //Лабораторная 4
    public static void makeRandomString(){
        String base = "[1] Товарищи!" +
                "[2] реализация намеченных планов" +
                "[3] играет важную роль в формировании" +
                "[4] существующих финансовых и административных условий" +
                "[5] С другой стороны" +
                "[6] рамки и место обучения кадров" +
                "[7] требуют от нас анализа" +
                "[8] дальнейших направлений развития" +
                "[9] Равным образом" +
                "[10] постоянный количественный рост и сфера нашей активности" +
                "[11] требуют определения и уточнения" +
                "[12] системы массового участия" +
                "[13] Не следует, однако, забывать, что" +
                "[14] сложившаяся структура организации" +
                "[15] способствуют подготовке и реализации" +
                "[16] позиций, занимаемых участниками в отношении поставленных задач" +
                "[17] Таким образом" +
                "[18] новая модель организационной деятельности" +
                "[19] обеспечивает широкому кругу специалистов участие в формировании" +
                "[20] новых предложений" +
                "[21] Повседневная практика показывает, что" +
                "[22] дальнейшее развитие различных форм деятельности" +
                "[23] позволяет выполнять важные задания по разработке" +
                "[24] направлений прогрессивного развития" +
                "[25] Значимость этих проблем настолько очевидна, что" +
                "[26] постоянное информационно-пропагандистское обеспечение нашей деятельности" +
                "[27] в значительной степени обусловливает создание" +
                "[28] системы обучения кадров, соответствующих насущным потребностям" +
                "[29] Разнообразный и богатый опыт" +
                "[30] укрепления в развитии структуры" +
                "[31] позволяет оценить значение" +
                "[32] соответствующий условий активизации" +
                "[33] Задача организации, в особенности же" +
                "[34] консультация с широким активом" +
                "[35] представляет собой интересный эксперимент проверки" +
                "[36] модели развития" +
                "[37] Идейные выражения высшего порядка, а также" +
                "[38] начало повседневной работы по формированию позиции" +
                "[39] влечет за собой процесс внедрения и модернизации" +
                "[40] форм воздействия";

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество предложений: ");
        int count_of_sentences = scanner.nextInt();

        Pattern pattern = Pattern.compile("\\[(\\d+)\\]\\s*([^\\[]+)");
        Matcher matcher = pattern.matcher(base);
        int count_sentences_in_base = 0;
        while (matcher.find()) 
            count_sentences_in_base++;


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count_of_sentences; i++){
            int index = random.nextInt(count_sentences_in_base);
            matcher = pattern.matcher(base);
            int current_index = 0;

            while(matcher.find()){
                if(current_index == index){
                    sb.append(matcher.group(2)).append(" ");
                    break;
                }
                current_index++;
            }
        }

        String res = sb.toString();
        System.out.println("Результат: " + res);
    }

    public static void main(String[] args){
//        Вызов функции для первой лаборатоной
//        PrintBodyMassIndex();
//
//        Вызов функции для второй лабораторной
//        System.out.println("Сыграем в камень-ножницы-бумага?");
//        RockPaperScissors();
//
//        Вызов функции для третьей лабораторной
//        System.out.println("Сыграем в камень-ножницы-бумага-ящерица-спок?");
//        int[] scores = {0,0};
//        RockPaperScissorsLizardSpock(scores);
//
//        Вызов функции для четвертой лабораторной
//        makeRandomString();
    }
}