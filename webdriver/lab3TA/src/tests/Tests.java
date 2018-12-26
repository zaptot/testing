package tests;
import by.bsu.kiselev.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

        @Test
        public void isTriangleNotExistWithSideLengthsEquals0 () {

            int a = 0;
            int b = 0;
            int c = 0;

            assertFalse(Triangle.exists(a, b, c));
        }

        @Test
        public void isTriangleNotExistWithTwoSideLengthsEquals0 () {

            int a = 0;
            int b = 0;
            int c = 3;

            assertFalse(Triangle.exists(a, b, c));
            assertFalse(Triangle.exists(b, c, a));
            assertFalse(Triangle.exists(c, a, b));
        }

        @Test
        public void isTriangleNotExistWithOneSideEquals0 () {

            int a = 2;
            int b = 0;
            int c = 5;

            assertFalse(Triangle.exists(a, b, c));
            assertFalse(Triangle.exists(b, c, a));
            assertFalse(Triangle.exists(c, a, b));
        }


        @Test
        public void isTriangleExistWithCorrectSideLengths () {

            int a = 2;
            int b = 2;
            int c = 2;

            assertTrue(Triangle.exists(a, b, c));
            assertTrue(Triangle.exists(b, c, a));
            assertTrue(Triangle.exists(c, a, b));
        }


        @Test
        public void isTriangleNotExistWithIncorrectSideLengths () {

            int a = 10;
            int b = 2;
            int c = 5;

            assertFalse(Triangle.exists(a, b, c));
            assertFalse(Triangle.exists(b, c, a));
            assertFalse(Triangle.exists(c, a, b));
        }

        @Test
        public void isTriangleNotExistIfOneSideLengthLess0 () {

            int a = 2;
            int b = 5;
            int c = -7;

            assertFalse(Triangle.exists(a, b, c));
            assertFalse(Triangle.exists(b, c, a));
            assertFalse(Triangle.exists(c, a, b));
        }

        @Test
        public void isTriangleNotExistIfSideLengthsLess0 () {

            int a = -1;
            int b = -2;
            int c = -3;

            assertFalse(Triangle.exists(a, b, c));
            assertFalse(Triangle.exists(b, c, a));
            assertFalse(Triangle.exists(c, a, b));
        }

        @Test
        public void isTriangleNotExistWhenOneSideEqualsToSumOfTwoOther () {

            int a = 10;
            int b = 6;
            int c = 16;

            assertFalse(Triangle.exists(a, b, c));
            assertFalse(Triangle.exists(b, c, a));
            assertFalse(Triangle.exists(c, a, b));
        }

        @Test
        public void isTriangleExistWhenSideLengthsEqualToMaxValue () {

            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            assertTrue(Triangle.exists(a, b, c));
        }

        @Test
        public void isTriangleExistWhenSideLengthsAreTooBigNumbers () {

            int a = Integer.MAX_VALUE - 2;
            int b = Integer.MAX_VALUE - 3;
            int c = Integer.MAX_VALUE - 4;

            assertTrue(Triangle.exists(a, b, c));
            assertTrue(Triangle.exists(b, c, a));
            assertTrue(Triangle.exists(c, a, b));
        }
}
