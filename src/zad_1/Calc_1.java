package zad_1;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calc_1 {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("Wybierz jedną z operacji");
        for (Operation value : Operation.values()) {
            System.out.println(value.getSymbol() + " - " + value.getDescription());
        }
    }


    public void inputData() throws UnknowOperationException {
        int liczba_1 = liczba(1);
        Operation operation;
        boolean error = true;

        do {
            operation = Operation.valueOf(operator());
            error = false;
        } while (error);



        int liczba_2 = liczba(2);

        StringBuilder sb = new StringBuilder();
        sb.append(liczba_1);
        sb.append(" ");
        sb.append(operation.getDescription());
        sb.append(" ");
        sb.append(liczba_2);
        System.out.println(sb.toString());
        System.out.println("Wynik - " +calculateSum(liczba_1,liczba_2,operation));
    }

    private String operator() {
        System.out.println("Podaj działanie");
        String oper = sc.nextLine();
        for (Operation value : Operation.values()) {
            if (oper.equals(value.getSymbol())) {
                return value.name();
            }
        }
        return oper;
    }

    private int liczba(int i) {

        boolean error = true;
        int licz = 0;
        String opis = "pierwszą";
        if (i == 2) opis = "drugą";

        do {
            try {
                System.out.println("Podaj " + opis + " liczbę całkowitą");
                licz = sc.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("Wprowadź liczbę calkowitą ");
            } finally {
                sc.nextLine();
            }
        } while (error);
        return licz;
    }

    public double calculateSum(int licz_1, int licz_2, Operation znak) throws UnknowOperationException {
        switch (znak) {
            case ADD:
                return licz_1 + licz_2;
            case MINUS:
                return licz_1 - licz_2;
            case MULTIPLICATION:
                return licz_1 * licz_2;
            case DIVISION:
                if (licz_2 == 0) {
                    throw new ArithmeticException("Nie można dzielić przez zero");
                }
                return licz_1 / licz_2;
           default:
               return 0;
        }
    }
}
