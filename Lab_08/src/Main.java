import java.util.ArrayList;

public class Main {

    public static void printArray(String[] arrayOfStrings, int delay) {
        for(String str: arrayOfStrings) {
            System.out.println(str);
            try{
                Thread.sleep(delay);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] createArray(int numberOfArray, int countOfElements) {
        String[] result = new String[countOfElements];
        for(int i = 0; i < countOfElements; i++){
            result[i] = String.format("%d - %d", numberOfArray, i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] firstArray = createArray(1, 6);
        String[] secondArray = createArray(2, 6);
        String[] thirdArray = createArray(3, 6);

        Thread thread1 = new Thread(() -> {
            printArray(firstArray, 2000);
        });
        Thread thread2 = new Thread(() -> {
            printArray(secondArray, 2000);
        });
        Thread thread3 = new Thread(() -> {
            printArray(thirdArray, 2000);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}