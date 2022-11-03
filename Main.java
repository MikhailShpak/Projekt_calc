import java.util.Scanner;

public class Main {

    private static String result;
    private static int deistvie;
    private static int znak;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calc(input);
        System.out.println("Результат: " +result);
    }


    public static void proverkaVvoda(String input) throws Exception {
            if (input.isEmpty()){
            try {
               throw  new Exception();
            } catch (Exception e){
                System.out.println("Вы ничего не ввели");
                System.exit(1);
        }}
            if(input.indexOf("+")>0){
                deistvie = input.indexOf("+");
                znak = 1;}
            else if (input.indexOf("-")>0){
                deistvie = input.indexOf("-");
                znak = 2;}
            else if (input.indexOf("*")>0){
                deistvie = input.indexOf("*");
                znak = 3;}
            else if (input.indexOf("/")>0){
                deistvie = input.indexOf("/");
                znak = 4;}
            else if(znak == 0) try {
                throw new Exception();}
            catch (Exception e){
            System.out.println("строка не является математической операцией");
            System.exit(2);}
            if (input.indexOf("+") == 0 | input.indexOf("-") == 0 | input.indexOf("*") == 0 | input.indexOf("/") == 0)try {
                throw  new Exception();
            } catch (Exception e){
                System.out.println("Выражение не должно начинаться с оператора");
                System.exit(10);

    }}

    public static String calc(String input) throws Exception {
        proverkaVvoda(input);
        int num1 = 0, num2 = 0, num3 = 0;
        String str1 = input.substring(0, deistvie);
        String str2 = input.substring(deistvie+1);
        if(str2.contains("+") | str2.contains("-") | str2.contains("*") | str2.contains("/")){
            try {
                throw  new Exception();
            } catch (Exception e){
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(3);
            }}
        else if (str2.isEmpty()){
            try {
                throw  new Exception();
            } catch (Exception e){
                System.out.println("Не введен второй операнд");
                System.exit(11);}}
        else {
            str1 = str1.trim();
            str2 = str2.trim();
            String[] massiv = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            for (int i = 0; i < massiv.length; i++) {
                if (str1.equals(massiv[i])) {
                    num1 = i + 1;
                    break;
                }
            }
            for (int i = 0; i < massiv.length; i++) {
                if (str2.equals(massiv[i])) {
                    num2 = i + 1;
                    break;
                }
            }

            if (num1 > 0 & num2 > 0) {
                switch (znak) {
                    case 1:
                        num3 = num1 + num2;
                        break;
                    case 2:
                        num3 = num1 - num2;
                        break;
                    case 3:
                        num3 = num1 * num2;
                        break;
                    case 4:
                        num3 = num1 / num2;
                        break;
                    }
                result = String.valueOf(num3);}

                else {try {
                Rimskie rim1 = Rimskie.valueOf(str1);
                Rimskie rim2 = Rimskie.valueOf(str2);
            num1 = rim1.ordinal() + 1;
            num2 = rim2.ordinal() + 1;
            } catch (Exception e){
            System.out.println("используются одновременно разные системы счисления, любо введеное число больше 10");
            System.exit(4);}
            if (num1 <=10 & num2<=10) {
                switch (znak) {
                    case 1:
                        num3 = num1 + num2;
                        break;
                    case 2:
                        num3 = num1 - num2;
                        break;
                    case 3:
                        num3 = num1 * num2;
                        break;
                    case 4:
                        num3 = num1 / num2;
                        break;
                    }
            if (num3 <=0) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("в римской системе нет отрицательных чисел");
                    System.exit(5);
                }
            }
            Rimskie rimskie = Rimskie.values()[num3-1];
            result = rimskie.toString();
            }
             else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Введеное число больше X");
                    System.exit(6);
            }
                }
    }}
        return result;
    }}



