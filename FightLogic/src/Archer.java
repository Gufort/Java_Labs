import javax.naming.Name;
import java.util.Random;

public class Archer extends Player{
    public Archer(String Name) {
        super("Лучник ", Name, 200, 100, 100, 25, 10);
    }

    public Archer(String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection){
        super("Лучник ", Name ,HP, Energy, MagicEnergy, Damage, Protection);
    }

    public void StartAttack(Player enemy){
        System.out.println(_playerClass + getName() + " начинает внезапную атаку!");
        for(int i = 0; i < 3; i++)
            Attack(enemy);
    }

    @Override
    public void Attack(Player enemy){
        Random random = new Random();
        int countOfAttack = 1 + random.nextInt(2);
        for(int i = 1; i <=countOfAttack; i++)
            super.Attack(enemy);
        if(_currentHP < 30) HealingSpell();
    }

    @Override
    public void HealingSpell(){
        if(_magicEnergy <= 0 || _currentEnergy < 0) {
            System.out.println(_playerClass + _Name + " попытался использовать заклинание лечения, но у него не хватает энергии!");
            return;
        }

        _currentHP += 30;
        if(_currentHP > 100) _currentHP = 100;

        _magicEnergy -= 50;
        if(_magicEnergy <= 0) _magicEnergy = 0;

        _currentEnergy -= 10;
        if(_currentHP <= 0) _currentEnergy = 0;

        System.out.println(_playerClass + _Name + " использовал заклинание лечения! Текущее здоровье: " + _currentHP);
    }
}
