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
				return Convert.ToInt32(addends[0]) + Convert.ToInt32(addends[1]);

			return Int32.Parse(numbers);
		}
	}
}