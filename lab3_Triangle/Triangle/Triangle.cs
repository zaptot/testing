using System;

namespace Triangle
{
    public class Triangle
    {
        public static bool isExist(int[] sides)
        {
            int size = sides.Length;
            if (size != 3) return false;
            for (int i = 0; i < size; i++)
            {
                if (sides[i] < 1) return false;
                if (sides[i] >= sides[(i + 1) % size] + sides[(i + 2) % size]) return false;
            }
            return true;
        }
    }
}