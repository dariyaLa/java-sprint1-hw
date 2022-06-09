import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        //printMenu();
        //int userInput = scanner.nextInt();

        while (true) {
            // обаботка разных случаев
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            int userInput = scanner.nextInt(); // повторное считывание данных от пользователя

            if (userInput == 1) {
                stepTracker.saveSteps();
            }

            else if (userInput == 2) {
                System.out.println("Введите месяц для вывода статистики шагов, где 1 - январь, 12 - декабрь:");
                int userInputMouth = scanner.nextInt();
                stepTracker.printStatistic(userInputMouth);
            }

            else if (userInput == 3) {
                stepTracker.editPurposeInDay();
            }

            else if (userInput == 4) {
                System.out.println("Программа завершена");
                return;
            }
            else {
                System.out.println("Введена несуществующая команда. Повторите попытку");
            }


        }
    }

    public static void printMenu() {
        System.out.println("Выберите один из пунктов меню:" + "\n" +
                "1 - Ввести количество шагов за определённый день;" + "\n" +
                "2 - Напечатать статистику за определённый месяц;" + "\n" +
                "3 - Изменить цель по количеству шагов в день;" + "\n" +
                "4 - Выйти из приложения.");
    }
}
