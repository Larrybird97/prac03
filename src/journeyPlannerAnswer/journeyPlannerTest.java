package journeyPlannerAnswer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import journeyPlannerQuestion.JourneyPlannerA;
import journeyPlannerQuestion.JourneyPlannerB;

public class journeyPlannerTest {
    private JourneyPlannerB underTest;

    @BeforeEach
    public void newJourney() throws Exception {
        underTest = new JourneyPlannerB(5);
    }

    @Test
    /*
    Passed both And B
     */
    public void validInputs() throws Exception{
        underTest.setOrigin(0,0);
        underTest.setDestination(5,5);

        assertEquals(50,underTest.journeyTime());
    }

    @Test
    /*
    Passed both And B
     */
    public void goingNowhere() throws Exception {
        underTest.setOrigin(0,0);
        underTest.setDestination(0,0);

        assertEquals(underTest.journeyTime(),0);
    }

    @Test
    /*
    Passed both A and B
     */
    public void invalidInputs() throws Exception{
        underTest.setOrigin(-1,0);
        underTest.setDestination(6,-5);

        assertThrows(Exception.class, () -> {
            underTest.journeyTime();
        });
    }

    @Test
    /*
    Passed both A and B
     */
    public void inputsOver10() throws Exception{
        underTest.setOrigin(20,0);
        underTest.setDestination(25,6);

        assertThrows(Exception.class, () -> {
            underTest.journeyTime();
        });
    }

    @Test
    /*
    Fails B
     */
    public void backwardsTest() throws Exception{
        underTest.setOrigin(10,10);
        underTest.setDestination(0,0);

        assertThrows(Exception.class, () -> {
            underTest.journeyTime();
        });
    }

    @Test
    /*
    Passed A not B
     */
    public void backwardsvalidInputs() throws Exception{
        underTest.setOrigin(10,10);
        underTest.setDestination(0,0);

        assertEquals(100,underTest.journeyTime());
    }

}
