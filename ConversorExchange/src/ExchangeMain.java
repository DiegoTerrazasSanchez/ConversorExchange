import java.util.Scanner;

public class ExchangeMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QueryCurrency queryCurrency = new QueryCurrency();

        int searchExchange;

        do {
            System.out.println("Welcome currency converter");
            System.out.println("1 USD -> ARS");
            System.out.println("2 ARS -> USD");
            System.out.println("3 USD -> BRL");
            System.out.println("4 BRL -> USD");
            System.out.println("5 Exit");

            searchExchange = sc.nextInt();

            if (searchExchange == 5) break;

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            CurrencyTarget result = null;

            switch (searchExchange) {
                case 1 -> result = queryCurrency.query("USD", "ARS", amount);
                case 2 -> result = queryCurrency.query("ARS", "USD", amount);
                case 3 -> result = queryCurrency.query("USD", "BRL", amount);
                case 4 -> result = queryCurrency.query("BRL", "USD", amount);
                default -> System.out.println("Invalid option");
            }

            if (result != null) {
                System.out.println("Rate: " + result.getConversion_rate());
                System.out.println("Result: " + result.getConversion_result());
            }

        } while (true);

        sc.close();
        System.out.println("Bye");
    }
}
