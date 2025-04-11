package FightLogic;

import java.util.Random;

public class Wizard extends Player {
    public Wizard(String Name) {
        super("Маг ", Name, 160, 100, 200, 35, 10);
    }

    public Wizard(String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection) {
        super("Маг ", Name, HP, Energy, MagicEnergy, Damage, Protection);
    }

    public void FreezeSpell(Player enemy) {
        if (this._magicEnergy < 40) {
            System.out.println(this._playerClass + this._Name + " пытается использовать заморозку, но ему не хватает магии!");
        } else {
            enemy._isFrozen = true;
            this._magicEnergy -= 40;
            String var10001 = this._playerClass;
            System.out.println(var10001 + this._Name + " замораживает " + enemy.getName() + " на 3 хода!");
        }
    }

    public void Attack(Player enemy) {
        super.Attack(enemy);
        Random random = new Random();
        int frozen = random.nextInt(100);
        if (frozen > 80 && !enemy._isFrozen) {
            this.FreezeSpell(enemy);
        }

        this._magicEnergy -= 30;
        if (this._magicEnergy < 0) {
            this._magicEnergy = 0;
            this.Meditation();
        }

    }

    public void HealingSpell() {
        if (this._magicEnergy < 20) {
            System.out.println(this._playerClass + this._Name + "пытается захилиться, но ему не хватает магии!");
        } else {
            this._currentHP += 50;
            if (this._currentHP > 100) {
                this._currentHP = 100;
            }

            this._magicEnergy -= 20;
            System.out.println(this._playerClass + this._Name + " использует мощное лечение! HP: " + this._currentHP);
        }
    }
}
