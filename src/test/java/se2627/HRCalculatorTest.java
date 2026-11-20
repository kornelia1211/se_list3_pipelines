package se2627;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class HRCalculatorTest {
    @Test
    public void testValidMaxHR() {
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }

    @Test
    public void testInvalidMaxHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }
    @Test
    public void testInvalidMaxHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testWorkoutZones() {
        assertEquals("Resting", HRCalculator.getWorkoutZone(40, 80)); //44%
        assertEquals("Recovery", HRCalculator.getWorkoutZone(40, 100)); //56%
        assertEquals("Fat Burn", HRCalculator.getWorkoutZone(40, 120)); //67%
        assertEquals("Aerobic", HRCalculator.getWorkoutZone(40, 140)); //78%
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(40, 160)); //89%
        assertEquals("VO2 Max", HRCalculator.getWorkoutZone(40, 180)); //100%
    }

    @Test
    public void testWorkoutZoneBoundaries() {
        assertEquals("Recovery", HRCalculator.getWorkoutZone(40, 90)); //50%
        assertEquals("Fat Burn", HRCalculator.getWorkoutZone(40, 108)); //60%
        assertEquals("Aerobic", HRCalculator.getWorkoutZone(40, 126)); //70&
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(40, 144)); //80%
        assertEquals("VO2 Max", HRCalculator.getWorkoutZone(40, 162)); //90%
    }

    @Test
    public void testInvalidWorkoutZoneAge() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(-1, 100));

        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(121, 100));
    }

    @Test
    public void testInvalidWorkoutZoneBpm() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(40, 0));

        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(40, -10));
    }

}