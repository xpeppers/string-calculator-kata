using System;
namespace StringCalculatorKata
{
	public static class StringCalculator
	{
		public static int Add(string numbers)
        {
            if (string.IsNullOrEmpty(numbers))
                return 0;

            string[] addends = numbers.Split(@",");
            if (addends.Length == 2)
                return ToNumber(addends[0]) + ToNumber(addends[1]);

            return ToNumber(numbers);
        }

        private static int ToNumber(string number)
        {
            return Int32.Parse(number);
        }
    }
}