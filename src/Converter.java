public class Converter {

    public static void printDistanceTraveled(int steps) {

        double distanceTraveledInKilometers = ((double) steps * 75) / 100000;
        System.out.println("Пройденная дистанция (в км): " + distanceTraveledInKilometers);

    }

    public static void printCountCaloriesBurned(int steps) {

        double countCaloriesBurned = ((double) steps * 50) / 1000;
        System.out.println("Количество сожжённых килокалорий: " + countCaloriesBurned);
    }
}
