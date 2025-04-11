import java.util.regex.Pattern;

public class SimCard {
    public String Number;
    public double Money;

    SimCard(String Number) throws Exception{
        if(checkSimCard(Number))
            this.Number = Number;
        else throw new Exception("Некорректный номер сим-карты!");
    }

    private boolean checkSimCard(String number){
        String regex = "\\+\\d{1,3}\\d{7,12}$";
        return Pattern.matches(regex, number);
    }
}
