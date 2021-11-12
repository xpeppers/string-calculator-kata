using System;
using System.Collections.Generic;
using System.Linq;
namespace StringCalculatorKata
{
    public static class StringCalculator
    {
        public static int Add(string numbers)
        {
            if (string.IsNullOrEmpty(numbers))
                return 0;

            return numbers.Split(@",").ToList()
                          .Select(n => ToNumber(n))
                          .Sum();
        }

        private static int ToNumber(string number)
        {
            return Int32.Parse(number);
        }
    }
}