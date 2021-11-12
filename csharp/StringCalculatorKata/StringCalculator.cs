using System;

namespace StringCalculatorKata
{
    public static class StringCalculator
    {
        public static int Add(string numbers)
        {
            if (string.Empty == numbers)
                return 0;
            return int.Parse(numbers);
        }
    }
}