package allSameAnswer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import allSameQuestion.AllSame;
import allSameQuestion.AllSameA;
import allSameQuestion.AllSameB;
import allSameQuestion.AllSameC;



public class allSameTest {
    private AllSameA underTest;

    @BeforeEach
    public void newSame() throws Exception {
        underTest = new AllSameA();
    }

    @Test
    /*
    Test no inputs
    A,B,C passed
     */
    public void noInput(){
        assertThrows(Exception.class, () -> {
            underTest.same(new int[] {});
        });
    }

    //@Test
    /* Test a non-natural input
    A and C passed, B fails and doesn't throw an exception,
     */
    @Test
    public void unnattyInput(){
        assertThrows(Exception.class, () -> {
            underTest.same(new int[] {-1,-5, 6, 9});
        });
    }

    @Test
    /*
    Confirm natural numbers are identified correctly
    All passed
     */
    public void nattyInput() throws Exception{
        assertTrue(underTest.same(new int[] {6,6, 6,6}));
    }

    @Test
    /* Confirm that the first number is checked - passed by all
     * versions
     */
    public void firstNumber() throws Exception {
        assertEquals(underTest.same(new int[] {2, 7, 7, 7, 7}), false);
    }

    @Test
    /* Confirm that the last number is checked - failed by
     * allSameB because it has an off-by-one error in its
     * loop
     */
    public void lastNumber() throws Exception {
        assertEquals(underTest.same(new int[] {7, 7, 7, 7, 2}), false);
    }

    @Test
    /* The following test identifies the flaw in the algorithm
     * used by AllSameA.  This algorithm, due to Myers, "works"
     * by calculating the average of the numbers and comparing
     * this with the first number.  Surprisingly, this approach
     * is successful in most cases, so the flaw is hard to
     * detect by testing.  It fails when given an array of different
     * numbers in which the first one just happens to equal the
     * average of them all, as in this test.
     */
    public void myersCheck() throws Exception {
        assertEquals(underTest.same(new int[] {4, 2, 6, 1, 7}), false);
    }
}
