package ATM_Machine;

public class ATM {
    public double Cash;
    private int ATM_Number;
    public double InputCash;
    public double OutputCash;

    public ATM(double Cash, int ATM_Number){
        this.ATM_Number = ATM_Number;
        this.Cash = Cash;
    }

    public void PrintInfoAboutATM(){
        System.out.println("Номер банкомата: " + ATM_Number +
                "\nДенег в банкомате: " + Cash +
                "\nДенег внесено: " + InputCash +
                "\nДенег выведено: " + OutputCash);
    }
}
