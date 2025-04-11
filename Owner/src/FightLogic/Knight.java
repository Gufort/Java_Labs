package FightLogic;

public class Knight extends Player {
    private int _berserkCount = 1;

    public Knight(String Name) {
        super("Рыцарь ", Name, 250, 100, 100, 35, 20);
    }

    public Knight(String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection) {
        super("Рыцарь ", Name, HP, Energy, MagicEnergy, Damage, Protection);
    }

    public void BerserkOn(Player enemy) {
        super.Attack(enemy);
        super.Attack(enemy);
        this._currentEnergy -= 40;
        if (this._currentEnergy < 0) {
            this._currentEnergy = 0;
        }

    }

    public void Attack(Player enemy) {
        if (this._berserkCount == 10 && !this._isFrozen) {
            this._playerDamage = 70;
            System.out.println(this._playerClass + this._Name + " наносит сокрушительный удар!");
            this._berserkCount = 0;
            super.Attack(enemy);
            this._playerDamage = 35;
        } else if (this._berserkCount == 4 && this._currentEnergy >= 40 && !this._isFrozen) {
            System.out.println(this._playerClass + this._Name + " переходит в режим берсерка!");
            this.BerserkOn(enemy);
        } else {
            super.Attack(enemy);
        }

        ++this._berserkCount;
    }
}

