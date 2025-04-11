public class Knight extends Player{
    private int _berserkCount = 1;

    public Knight(String Name) {
        super("Рыцарь ", Name, 250, 100, 100, 35, 20);
    }

    public Knight(String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection){
        super("Рыцарь ", Name,HP, Energy, MagicEnergy, Damage, Protection);
    }

    public void BerserkOn(Player enemy){
        super.Attack(enemy);
        super.Attack(enemy);
        _currentEnergy -= 40;
        if(_currentEnergy < 0) _currentEnergy = 0;
    }

    public void Attack(Player enemy){
        if(_berserkCount == 10 && !_isFrozen){
            _playerDamage = 70;
            System.out.println(_playerClass + _Name + " наносит сокрушительный удар!");
            _berserkCount = 0;
            super.Attack(enemy);
            _playerDamage = 35;
        }
        else if(_berserkCount == 4  && _currentEnergy >= 40 && !_isFrozen){
            System.out.println(_playerClass + _Name + " переходит в режим берсерка!");
            BerserkOn(enemy);
        }

        else
            super.Attack(enemy);
        _berserkCount++;
    }
}
