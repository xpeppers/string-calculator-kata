using System;

namespace StringCalculatorKata
{
    public static class StringCalculator
    {
        public static int Add(string numbers)
        {
            if (numbers.Equals(string.Empty)) 
                return 0;

            string[] numbersToSum = numbers.Split(",");
            int sum = 0;

            foreach (string number in numbersToSum)
            {
                sum += int.Parse(number);
            }

            return sum;
        }
    }
}