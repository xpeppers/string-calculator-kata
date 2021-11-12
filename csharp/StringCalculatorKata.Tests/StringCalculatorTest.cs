using FluentAssertions;
using Xunit;

namespace StringCalculatorKata.Tests
{
    public class StringCalculatorTest
    {
        [Fact]
        public void EmptyStringEqualsZero()
        {
            StringCalculator.Add("").Should().Be(0);
        }
    }
}