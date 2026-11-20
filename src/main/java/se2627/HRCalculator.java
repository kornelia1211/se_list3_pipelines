package se2627;
public class HRCalculator {
    public static int calculateMaxHR(int age) {
        if (age > 120 || age < 0) {
            throw new IllegalArgumentException("Age out of bounds");
        }
        return 220 - age;
    }

    public static String getWorkoutZone(int age, int bpm) {

        if (age > 120 || age < 0) {
            throw new IllegalArgumentException("Age out of bounds");
        }

        if (bpm <= 0) {
            throw new IllegalArgumentException("Invalid bpm");
        }

        double percentage = ((double) bpm / calculateMaxHR(age));

        if(percentage < 0.5){
            return "Resting";
        }

        else if(percentage >= 0.5 && percentage < 0.6){
            return "Recovery";
        }

        else if(percentage >= 0.6 && percentage < 0.7){
            return "Fat Burn";
        }

        else if(percentage >= 0.7 && percentage < 0.8){
            return "Aerobic";
        }

        else if(percentage >= 0.8 && percentage < 0.9){
            return "Anaerobic";
        }

        else return "VO2 Max";
    }
}
