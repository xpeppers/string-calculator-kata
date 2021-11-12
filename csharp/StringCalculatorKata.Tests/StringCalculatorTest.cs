using FluentAssertions;
using Xunit;

namespace StringCalculatorKata.Tests
{
    public class StringCalculatorTest
    {       

        [Fact]
        public void ReturnsZeroIfEmpty()
        {
            int res = StringCalculator.Add(string.Empty);

            res.Should().Be(0);
        }

        [Fact]
        public void ReturnsSameNumberIfSingleNumber()
        {
            int res = StringCalculator.Add("5");

            res.Should().Be(5);
        }
    }
}