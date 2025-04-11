import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean startAttackFlag = true;
        Wizard player_1 = new Wizard("Ахилесс");
        System.out.println("Здравствуй, " + player_1.getName() + "!");

//        Archer player_2 = new Archer("Максим");
//        System.out.println("Здравствуй, " + player_2.getName() + "!");
//        Random random = new Random();

        Knight player_2 = new Knight("Максим");
        System.out.println("Здравствуй, " + player_2.getName() + "!");
        Random random = new Random();

        int count = 1;

        System.out.println("Начинаем бой!\n");
        while (true) {
            System.out.println("Круг " + count + "!");

//            if(startAttackFlag) {
//                player_2.StartAttack(player_1);
//                startAttackFlag = false;
//            }

            int rnd = random.nextInt(100);
            player_1.Attack(player_2);
            if (player_2._isDeath) {
                System.out.println(player_1._playerClass + player_1.getName() + " победил!");
                player_1.checkState();
                break;
            }

            player_2.Attack(player_1);
            if (player_1._isDeath) {
                System.out.println(player_2._playerClass + player_2.getName() + " победил!");
                player_2.checkState();
                break;
            }

            if (rnd >= 80) player_1.Rest();
            else if (rnd >= 20 && rnd <= 60) player_1.Meditation();
            else if (rnd <= 50 && rnd >= 20) player_1.HealingSpell();
            rnd = random.nextInt(100);

            if (rnd >= 80) player_2.Rest();
            else if (rnd >= 70) player_2.Meditation();
            else if (rnd <= 50 && rnd >= 20) player_2.HealingSpell();

            count++;

            System.out.println();
        }
    }
}