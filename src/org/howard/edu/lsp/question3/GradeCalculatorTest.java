package org.howard.edu.lsp.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    @Test
    public void testAverageReturnsCorrectAverage() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(85.0, calculator.average(80, 85, 90));
    }

    @Test
    public void testLetterGradeReturnsCorrectGrade() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("A", calculator.letterGrade(95));
        assertEquals("B", calculator.letterGrade(85));
        assertEquals("C", calculator.letterGrade(75));
        assertEquals("D", calculator.letterGrade(65));
        assertEquals("F", calculator.letterGrade(50));
    }

    @Test
    public void testIsPassingReturnsTrueForPassingAverage() {
        GradeCalculator calculator = new GradeCalculator();
        assertTrue(calculator.isPassing(60));
    }

    @Test
    public void testAverageAllowsMinimumBoundaryScore() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(0.0, calculator.average(0, 0, 0));
    }

    @Test
    public void testAverageAllowsMaximumBoundaryScore() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(100.0, calculator.average(100, 100, 100));
    }

    @Test
    public void testAverageThrowsExceptionForScoreBelowZero() {
        GradeCalculator calculator = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 90);
        });
    }

    @Test
    public void testAverageThrowsExceptionForScoreAboveOneHundred() {
        GradeCalculator calculator = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 90);
        });
    }
}
