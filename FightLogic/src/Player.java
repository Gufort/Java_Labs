import java.util.Random;

class Player {
    protected String _playerClass;
    protected String _Name;
    protected int _currentHP;
    protected int _currentEnergy;
    protected int _playerDamage;
    protected int _playerProtection;
    protected int _magicEnergy;
    protected boolean _isDeath = false;
    protected boolean _isFrozen = false;
    protected int _frozenCount = 3;

    public Player(String playerClass, String Name, int HP, int Energy, int MagicEnergy, int Damage, int Protection) {
        _playerClass = playerClass;
        _Name = Name;
        _currentHP = HP;
        _currentEnergy = Energy;
        _magicEnergy = MagicEnergy;
        _playerDamage = Damage;
        _playerProtection = Protection;
    }

    public String getName() { return _Name; }

    public void Attack(Player enemy) {
        if (_isFrozen) {
            System.out.println(_playerClass + _Name + " заморожен и не может защищаться!");
            return;
        }

        if (_currentEnergy <= 0) {
            System.out.println(_playerClass + _Name + " устал! Не может атаковать!");
            Rest();
            return;
        }

        enemy.TakeDamage(_playerDamage);
        _currentEnergy -= 20;
        if (_currentEnergy < 0) _currentEnergy = 0;

        if(enemy._currentHP < 0) enemy._currentHP = 0;

        if (!enemy._isDeath) {
            System.out.println(_playerClass + _Name + " нанес урон игроку " + enemy.getName() + "! Его текущее здоровье: " + enemy._currentHP);
        }
    }

    public void TakeDamage(int damage) {
        if (_isFrozen) {
            if (_frozenCount <= 0) {
                _isFrozen = false;
                _frozenCount = 3;
                System.out.println(_playerClass + _Name + " разморожен!");
            }
            else {
                System.out.println(_playerClass + _Name + " заморожен и не может защищаться!");
                _currentHP -= damage;
                _frozenCount--;
            }
            return;
        }


        Random random = new Random();
        int rnd = random.nextInt(100);
        if (_playerProtection >= rnd) {
            System.out.println(_playerClass + _Name + " парировал удар!");
            return;
        } else {
            _currentHP -= damage;
            if(_currentHP < 0) _currentHP = 0;
            //System.out.println(_playerClass + _Name + " ранен! Текущее здоровье: " + _currentHP);
        }

        if (_currentHP <= 0) {
            _currentHP = 0;
            _isDeath = true;
            System.out.println(_playerClass + _Name + " проиграл!");
        }
    }


    public void Meditation() {
        _magicEnergy += 20;
        if (_magicEnergy > 100) _magicEnergy = 100;
        System.out.println(_playerClass + _Name + " медитирует! Магия: " + _magicEnergy);
    }

    public void HealingSpell() {
        if (_magicEnergy <= 0) {
            System.out.println(_playerClass + _Name + " не хватает магической энергии!");
            return;
        }
        _currentHP += 30;
        if (_currentHP > 100) _currentHP = 100;
        _magicEnergy -= 30;
        System.out.println(_playerClass + _Name + " исцеляется! Здоровье: " + _currentHP);
    }

    public void Rest() {
        _currentEnergy += 20;
        if (_currentEnergy > 100) _currentEnergy = 100;
        System.out.println(_playerClass + _Name + " отдыхает! Энергия: " + _currentEnergy);
    }

    public void checkState() {
        System.out.println("Состояние победителя:");
        System.out.println("HP: " + _currentHP + ", Энергия: " + _currentEnergy +
                ", Магия: " + _magicEnergy);
        System.out.println("Урон: " + _playerDamage + ", Защита: " + _playerProtection);
    }
}