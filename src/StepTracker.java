import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;


public class StepTracker {

    MonthData[] monthToData;
    MonthData monthDaysData = new MonthData();
    Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void saveSteps() {
        System.out.println("Сначала введите месяц для статистики шагов, где 1 - январь, 12 - декабрь:");
        int userInputMouth = scanner.nextInt();
        System.out.println("Введите день для статистики шагов от 1 до 30:");
        int userInputDay = scanner.nextInt();
        System.out.println("Введите кол-во шагов за этот день:");
        int userInputSteps = scanner.nextInt();
        while (userInputSteps < 0) {
            System.out.println("Кол-во шагов не может быть отрицательным. Введите корректное кол-во");
            userInputSteps = scanner.nextInt();
        }

        monthToData[userInputMouth].setDaysStaps(userInputDay, userInputSteps);
    }

    public void printStatistic(int userInputMouth) {
        printStatisticStepsPerDay(userInputMouth);
        printSumStepsMouth(userInputMouth);
        printMaxStepsMouth(userInputMouth);
        printAVGStepsMouth(userInputMouth);
        printMaxDaysWihtTargetSteps(userInputMouth);
        Converter.printDistanceTraveled(sumStepsMouth(userInputMouth));
        Converter.printCountCaloriesBurned(sumStepsMouth(userInputMouth));
    }

    public void printStatisticStepsPerDay(int userInputMouth) {
        System.out.println("Количество пройденных шагов за месяц " + userInputMouth + ":");
        for (int i = 1; i <= monthDaysData.monthDaysSteps.length; i++) {
            System.out.println(i + " день: " + monthToData[userInputMouth].getMonthDataSteps(i));
        }
    }

    public void printSumStepsMouth(int mouth) {
        int sumStepsMouth = 0;
        for (int i = 1; i <= monthDaysData.monthDaysSteps.length; i++) {
            sumStepsMouth = sumStepsMouth + monthToData[mouth].getMonthDataSteps(i);
        }
        System.out.println("Общее количество шагов за месяц: " + sumStepsMouth);
    }

    public void printMaxStepsMouth(int mouth) {
        int maxStepsMouth = 0;
        for (int i = 1; i <= monthDaysData.monthDaysSteps.length; i++) {
            if (maxStepsMouth < monthToData[mouth].getMonthDataSteps(i)) {
                maxStepsMouth = monthToData[mouth].getMonthDataSteps(i);
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsMouth);
    }

    public void printAVGStepsMouth(int mouth) {
        int sumStepsMouth = 0;
        for (int i = 1; i <= monthDaysData.monthDaysSteps.length; i++) {
            sumStepsMouth = sumStepsMouth + monthToData[mouth].getMonthDataSteps(i);
        }
        int avgStepsMouth = sumStepsMouth / 30;
        System.out.println("Среднее количество шагов: " + avgStepsMouth);
    }

    public void printMaxDaysWihtTargetSteps(int mouth) {
        int daysWihtTargetSteps = 0;
        int maxDaysWihtTargetSteps = 0;

        for (int i = 1; i <= monthDaysData.monthDaysSteps.length; i++) {
            if (monthToData[mouth].getMonthDataSteps(i) >= monthDaysData.getPurposeInDay()) {
                daysWihtTargetSteps = daysWihtTargetSteps + 1;
            } else {
                if (daysWihtTargetSteps > maxDaysWihtTargetSteps) {
                    maxDaysWihtTargetSteps = daysWihtTargetSteps;
                }
                daysWihtTargetSteps = 0;
            }
        }
        if (daysWihtTargetSteps != 0) {
            if (daysWihtTargetSteps > maxDaysWihtTargetSteps) {
                maxDaysWihtTargetSteps = daysWihtTargetSteps;
            }
        }
        //IntStream intStream = Arrays.stream(masMaxDaysWihtTargetSteps);
        //OptionalInt optionalInt = intStream.max();
        //int maxAsInt = optionalInt.getAsInt();
        //int maxAsInt = Arrays.stream(masMaxDaysWihtTargetSteps).max().getAsInt();

        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, " +
                "в течение которых количество шагов за день было равно или выше целевого: " + maxDaysWihtTargetSteps);
    }

    public int sumStepsMouth(int mouth) {
        int sumStepsMouth = 0;
        for (int i = 1; i <= monthDaysData.monthDaysSteps.length; i++) {
            sumStepsMouth = sumStepsMouth + monthToData[mouth].getMonthDataSteps(i);
        }
        return sumStepsMouth;
    }

    public void editPurposeInDay() {
        System.out.println("Текущая цель по кол-ву шагов в день: " + monthDaysData.getPurposeInDay() +
                ". Введите новую цель по количеству шагов в день:");
        int userInputPurposeInDay = scanner.nextInt();
        while (userInputPurposeInDay < 0) {
            System.out.println("Цель не может быть отрицательной. Введите корректную цель");
            userInputPurposeInDay = scanner.nextInt();
        }
        monthDaysData.setPurposeInDay(userInputPurposeInDay);
        System.out.println("Цель по количеству шагов в день изменена: " + monthDaysData.getPurposeInDay());
    }

}