using FluentAssertions;
using Xunit;

namespace StringCalculatorKata.Tests
{
    public class StringCalculatorTest
    {       
        [Theory]
        [InlineData("", 0)]
        [InlineData("5", 5)]
        [InlineData("1,2", 3)]
        [InlineData("1,2,3,4", 10)]
        public void ReturnsSumOfNumbers(string numbersToSum, int sum)
        {
            int res = StringCalculator.Add(numbersToSum);

            res.Should().Be(sum);
        }
    }
}