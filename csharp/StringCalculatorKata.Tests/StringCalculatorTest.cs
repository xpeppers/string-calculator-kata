using FluentAssertions;
using Xunit;

namespace StringCalculatorKata.Tests
{
    public class StringCalculatorTest
    {
        [Fact]
        public void ExampleTest()
        {
            true.Should().Be(false);
        }

        [Fact]
        public void Test0()
        {
            int res = StringCalculator.Add(string.Empty);

            res.Should().Be(0);
        }
    }
}