using System;
using Xunit;
using Triangle;

namespace TestProject1
{
    public class UnitTest1
    {
        [Fact]
        public void IsTriangle_NegativeLenght_false()
        {
            Equals(Triangle.Triangle.isExist(new []{3,-4,5}), false);
        }

        [Fact]
        public void IsTriangle_SimpleTriangle_true()
        {
            Equals(Triangle.Triangle.isExist(new[] {3, 4, 5}), true);
        }

        [Fact]
        public void IsTriangle_MoreThan3Sides_false()
        {
            Equals(Triangle.Triangle.isExist(new[] {3, 4, 5, 6}), false);
        }

        [Fact]
        public void IsTriangle_OneSideIsZero_false()
        {
            Equals(Triangle.Triangle.isExist(new[] {1, 2, 0}), false);
        }

        [Fact]
        public void IsTriangle_AllSidesIsZero()
        {
            Equals(Triangle.Triangle.isExist(new[] {0, 0, 0}), false);
        }

        [Fact]
        public void IsTriangle_BigLenght_true()
        {
            Equals(Triangle.Triangle.isExist(new[] {Int32.MaxValue, Int32.MaxValue - 1, Int32.MaxValue - 2}), true);
        }

        [Fact]
        public void IsTriangle_AllSidesAreNegative_false()
        {
            Equals(Triangle.Triangle.isExist(new[] {-3, -4, -5}), false);
        }

        [Fact]
        public void isTriangle_SumOfTwoSidesEqualTheThird_false()
        {
            Equals(Triangle.Triangle.isExist(new[] {3, 4, 7}), false);
        }

        [Fact]
        public void IsTriangle_TwoSidesEqualToZero_false()
        {
            Equals(Triangle.Triangle.isExist(new[] {1, 0, 0}), false);
        }

        [Fact]
        public void IsTriangle_LessThenThreeSides_false()
        {
            Equals(Triangle.Triangle.isExist(new[] {1, 2}), false);
        }
    }
}