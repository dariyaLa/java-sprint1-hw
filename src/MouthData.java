public class MouthData {

    int[] mouthDaysSteps;
    int purposeInDay;

    MouthData() {
        mouthDaysSteps = new int[31];
        purposeInDay = 10000;
    }

    public void setDaysStaps(int day, int steps) {
        mouthDaysSteps[day] = steps;
    }

    public int getMouthDataSteps(int day) {
        return mouthDaysSteps[day];
    }

    public void setMouthDataSteps(int[] mouthDataSteps) {
        this.mouthDaysSteps = mouthDataSteps;
    }

    public int getPurposeInDay() {
        return purposeInDay;
    }

    public void setPurposeInDay(int purposeInDay) {
        this.purposeInDay = purposeInDay;
    }

}
