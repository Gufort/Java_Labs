package FightLogic;

import java.util.Random;

public class Player {
    public String _playerClass;
    public String _Name;
    public int _currentHP;
    public int _currentEnergy;
    public int _playerDamage;
    public int _playerProtection;
    public int _magicEnergy;
    public boolean _isDeath = false;
    public boolean _isFrozen = false;
    public int _frozenCount = 3;

    public Player(String playerClass, String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection) {
        this._playerClass = playerClass;
        this._Name = Name;
        this._currentHP = HP;
        this._currentEnergy = Energy;
        this._magicEnergy = MagicEnergy;
        this._playerDamage = Damage;
        this._playerProtection = Protection;
    }

    public String getName() {
        return this._Name;
    }

    public void Attack(Player enemy) {
        if (this._isFrozen) {
            System.out.println(this._playerClass + this._Name + " заморожен и не может защищаться!");
        } else if (this._currentEnergy <= 0) {
            System.out.println(this._playerClass + this._Name + " устал! Не может атаковать!");
            this.Rest();
        } else {
            enemy.TakeDamage(this._playerDamage);
            this._currentEnergy -= 20;
            if (this._currentEnergy < 0) {
                this._currentEnergy = 0;
            }

            if (enemy._currentHP < 0) {
                enemy._currentHP = 0;
            }

            if (!enemy._isDeath) {
                String var10001 = this._playerClass;
                System.out.println(var10001 + this._Name + " нанес урон игроку " + enemy.getName() + "! Его текущее здоровье: " + enemy._currentHP);
            }

        }
    }

    public void TakeDamage(int damage) {
        if (this._isFrozen) {
            if (this._frozenCount <= 0) {
                this._isFrozen = false;
                this._frozenCount = 3;
                System.out.println(this._playerClass + this._Name + " разморожен!");
            } else {
                System.out.println(this._playerClass + this._Name + " заморожен и не может защищаться!");
                this._currentHP -= damage;
                --this._frozenCount;
            }

        } else {
            Random random = new Random();
            int rnd = random.nextInt(100);
            if (this._playerProtection >= rnd) {
                System.out.println(this._playerClass + this._Name + " парировал удар!");
            } else {
                this._currentHP -= damage;
                if (this._currentHP < 0) {
                    this._currentHP = 0;
                }

                if (this._currentHP <= 0) {
                    this._currentHP = 0;
                    this._isDeath = true;
                    System.out.println(this._playerClass + this._Name + " проиграл!");
                }

            }
        }
    }

    public void Meditation() {
        this._magicEnergy += 20;
        if (this._magicEnergy > 100) {
            this._magicEnergy = 100;
        }

        System.out.println(this._playerClass + this._Name + " медитирует! Магия: " + this._magicEnergy);
    }

    public void HealingSpell() {
        if (this._magicEnergy <= 0) {
            System.out.println(this._playerClass + this._Name + " не хватает магической энергии!");
        } else {
            this._currentHP += 30;
            if (this._currentHP > 100) {
                this._currentHP = 100;
            }

            this._magicEnergy -= 30;
            System.out.println(this._playerClass + this._Name + " исцеляется! Здоровье: " + this._currentHP);
        }
    }

    public void Rest() {
        this._currentEnergy += 20;
        if (this._currentEnergy > 100) {
            this._currentEnergy = 100;
        }

        System.out.println(this._playerClass + this._Name + " отдыхает! Энергия: " + this._currentEnergy);
    }

    public void checkState() {
        System.out.println("Состояние победителя:");
        System.out.println("HP: " + this._currentHP + ", Энергия: " + this._currentEnergy + ", Магия: " + this._magicEnergy);
        System.out.println("Урон: " + this._playerDamage + ", Защита: " + this._playerProtection);
    }
}
