package FightLogic;

import java.util.Random;

public class Archer extends Player {
    public Archer(String Name) {
        super("Лучник ", Name, 200, 100, 100, 25, 10);
    }

    public Archer(String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection) {
        super("Лучник ", Name, HP, Energy, MagicEnergy, Damage, Protection);
    }

    public void StartAttack(Player enemy) {
        String var10001 = this._playerClass;
        System.out.println(var10001 + this.getName() + " начинает внезапную атаку!");

        for(int i = 0; i < 3; ++i) {
            this.Attack(enemy);
        }

    }

    public void Attack(Player enemy) {
        Random random = new Random();
        int countOfAttack = 1 + random.nextInt(2);

        for(int i = 1; i <= countOfAttack; ++i) {
            super.Attack(enemy);
        }

        if (this._currentHP < 30) {
            this.HealingSpell();
        }

    }

    public void HealingSpell() {
        if (this._magicEnergy > 0 && this._currentEnergy >= 0) {
            this._currentHP += 30;
            if (this._currentHP > 100) {
                this._currentHP = 100;
            }

            this._magicEnergy -= 50;
            if (this._magicEnergy <= 0) {
                this._magicEnergy = 0;
            }

            this._currentEnergy -= 10;
            if (this._currentHP <= 0) {
                this._currentEnergy = 0;
            }

            System.out.println(this._playerClass + this._Name + " использовал заклинание лечения! Текущее здоровье: " + this._currentHP);
        } else {
            System.out.println(this._playerClass + this._Name + " попытался использовать заклинание лечения, но у него не хватает энергии!");
        }
    }
}
