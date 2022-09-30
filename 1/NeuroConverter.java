import java.util.Scanner;

public class NeuroConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();

        converter(amount);

        scanner.close();
    }

    public static void converter(double amount) {
        // 1 neuro
        int neuro = (int) amount;
        double decimalMoney = amount % 1;

        // float things :/ It doesnt change the result but solves the decimal divide
        // problem (i.e. 0.49/0.49 = 0)
        decimalMoney += 0.0001;

        // 49 neuro cent
        int neuroCentFourtyNineCount = (int) (decimalMoney / 0.49);
        decimalMoney -= (float) (neuroCentFourtyNineCount * 0.49);

        // 9 neuro cent
        int neuroCentNineCount = (int) (decimalMoney / 0.09);
        decimalMoney -= (float) (neuroCentNineCount * 0.09);

        // 1 neuro cent
        int neuroCentOneCount = (int) (decimalMoney / 0.01);
        decimalMoney -= (float) (neuroCentOneCount * 0.01);

        System.out.println(neuro);
        System.out.println(neuroCentFourtyNineCount);
        System.out.println(neuroCentNineCount);
        System.out.println(neuroCentOneCount);
        return;
    }
}