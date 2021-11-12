using System;

namespace StringCalculatorKata
{
    public static class StringCalculator
    {
        public static int Add(string numbers)
        {
            if (string.Empty == numbers)
                return 0;

            string[] numbersToSum = numbers.Split(",");
            if (numbersToSum.Length == 2)
                return int.Parse(numbersToSum[0]) + int.Parse(numbersToSum[1]);

            return int.Parse(numbers);
        }
    }
}