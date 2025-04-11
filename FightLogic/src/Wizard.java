import java.util.Random;

public class Wizard extends Player{
    public Wizard(String Name) {
        super("Маг ", Name, 160, 100, 200, 35, 10);
    }

    public Wizard(String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection){
        super("Маг ", Name,HP, Energy, MagicEnergy, Damage, Protection);
    }

    public void FreezeSpell(Player enemy) {
        if (_magicEnergy < 40) {
            System.out.println(_playerClass + _Name + " пытается использовать заморозку, но ему не хватает магии!");
            return;
        }
        else{
            enemy._isFrozen = true;
            _magicEnergy -= 40;
            System.out.println(_playerClass + _Name + " замораживает " + enemy.getName() + " на 3 хода!");
        }
    }

    @Override
    public void Attack(Player enemy){
        super.Attack(enemy);
        Random random = new Random();
        int frozen = random.nextInt(100);
        if(frozen > 80 && !enemy._isFrozen)
            FreezeSpell(enemy);

        _magicEnergy -= 30;
        if(_magicEnergy < 0){
            _magicEnergy = 0;
            Meditation();
        }
    }

    @Override
    public void HealingSpell() {
        if (_magicEnergy < 20) {
            System.out.println(_playerClass + _Name + "пытается захилиться, но ему не хватает магии!");
            return;
        }

        _currentHP += 50;
        if (_currentHP > 100) _currentHP = 100;
        _magicEnergy -= 20;
        System.out.println(_playerClass + _Name + " использует мощное лечение! HP: " + _currentHP);
    }
}
