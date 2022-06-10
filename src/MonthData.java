public class MonthData {

    int[] monthDaysSteps;
    int purposeInDay;

    MonthData() {
        monthDaysSteps = new int[30];
        purposeInDay = 1000;
    }

    public void setDaysStaps(int day, int steps) {
        monthDaysSteps[day-1] = steps;
    }

    public int getMonthDataSteps(int day) {
        return monthDaysSteps[day-1];
    }

    public void setMonthDataSteps(int[] mouthDataSteps) {
        this.monthDaysSteps = mouthDataSteps;
    }

    public int getPurposeInDay() {
        return purposeInDay;
    }

    public void setPurposeInDay(int purposeInDay) {
        this.purposeInDay = purposeInDay;
    }

}
