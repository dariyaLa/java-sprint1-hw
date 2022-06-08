public class MonthData {

    int[] monthDaysSteps;
    int purposeInDay;

    MonthData() {
        monthDaysSteps = new int[31];
        purposeInDay = 10000;
    }

    public void setDaysStaps(int day, int steps) {
        monthDaysSteps[day] = steps;
    }

    public int getMonthDataSteps(int day) {
        return monthDaysSteps[day];
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
