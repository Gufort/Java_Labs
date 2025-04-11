import java.util.Scanner;
import java.util.regex.Pattern;

public class Card {
    public double Money;
    public int CardNumber;
    private int PinCode;

    Card(double Money, int CardNumber, int PinCode) throws Exception{
        if(checkCardNumber(CardNumber))
            this.CardNumber = CardNumber;
        else throw new Exception("Номер карты не соответсвует формату! Должно быть 9-значное число");

        if(checkPinCode(PinCode))
            this.PinCode = PinCode;
        else throw new Exception("Пин-код не соответсвует формату! Он должен содержать минимум 4 цифры, максимум 8!");

        this.Money = Money;
    }



    private boolean checkPinCode(int code){
        return (1000 <= code) && (code < 100000000);
    }

    private boolean checkCardNumber(int cardNumber){
        return (100000000 <= cardNumber) && (cardNumber < 999999999);
    }

    private boolean checkInputPassword() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int inputPassword = scanner.nextInt();

        if(inputPassword == PinCode) return true;
        else throw new Exception("Неправильный пин-код");
    }



    public void DepositMoneyIntoSimCard(SimCard simCard)
            throws Exception{
        System.out.println("Процедуры пополнения счета сим-карты!");
        System.out.println("Введите сумму для перевода: ");

        Scanner scanner = new Scanner(System.in);
        double moneyToDeposit = scanner.nextInt();

        if(moneyToDeposit < 0) throw new Exception("Нельзя перевести отрицательную сумму!");

        System.out.println("Пожалуйста, введите пин-код!");

        if(Money - moneyToDeposit >= 0 && checkInputPassword()){
            Money -= moneyToDeposit;
            simCard.Money += moneyToDeposit;
            System.out.println("Вы перевели на сим-карту " + simCard.Number + " " +
                    moneyToDeposit + " монгольских тугриков!\n" +
                    "Текущий баланс: " + Money);
        }
        else System.out.println("Недостаточно средств для перевода!");
    }

    public void TransferToCard(Card card) throws Exception{
        System.out.println("Процедура перевода денег на другой счет!");
        System.out.println("Введите сумму для перевода: ");

        Scanner scanner = new Scanner(System.in);
        double moneyToTransfer = scanner.nextInt();

        if(moneyToTransfer < 0) throw new Exception("Нельзя перевести отрицательную сумму!");

        System.out.println("Пожалуйста, введите пин-код!");

        if(Money - moneyToTransfer >= 0 && checkInputPassword()){
            card.Money += moneyToTransfer;
            Money -= moneyToTransfer;
            System.out.println("Вы перевели на карту " + card.CardNumber + " " +
                    moneyToTransfer + " монгольских тугриков!\n" +
                    "Текущий баланс: " + Money);
        }
        else System.out.println("Недостаточно средств для перевода!");
    }


    public void WithdrawMoney(ATM atm) throws Exception {
        System.out.println("Процедура снятия денег со счета в банкомате!");

        System.out.println("Введите сумму, которую хотите снять: ");
        Scanner scanner = new Scanner(System.in);
        double moneyToWithdraw = scanner.nextInt();

        if (moneyToWithdraw < 0) throw new Exception("Нельзя снять отрицательную сумму!");
        if (moneyToWithdraw > atm.Cash) throw new Exception("В банкомате недостаточно наличных!");

        System.out.println("Пожалуйста, введите пин-код!");

        if (Money >= moneyToWithdraw && checkInputPassword()) {
            Money -= moneyToWithdraw;
            atm.Cash -= moneyToWithdraw;
            atm.OutputCash += moneyToWithdraw;
            System.out.println(moneyToWithdraw + " было снято с карты в банкомате!\n" +
                    "Текущий баланс: " + Money);
        }
        else System.out.println("У вас на счету недостаточно средств для снятия!");
    }

    public void DepositMoney(ATM atm) throws Exception{
        System.out.println("Процедура внесения денег!");

        System.out.println("Введите сумму, которую хотите внести: ");
        Scanner scanner = new Scanner(System.in);
        double moneyToDeposit = scanner.nextInt();

        if (moneyToDeposit < 0) throw new Exception("Нельзя положить отрицательную сумму!");

        System.out.println("Пожалуйста, введите пин-код!");

        if (checkInputPassword()) {
            Money += moneyToDeposit;
            atm.Cash += moneyToDeposit;
            atm.InputCash += moneyToDeposit;
            System.out.println("Вы внесли на ваш счет " + moneyToDeposit + " монгольских тугриков!\n" +
                    "Текущий баланс: " + Money);
        }
    }

    public void CardInfo(){
        System.out.println("===> Информация о карте " + CardNumber + " <===\n" +
                "Номер: " + CardNumber +
                "\nБаланс : " + Money);
    }
}
