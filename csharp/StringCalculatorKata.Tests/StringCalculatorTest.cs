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

		[Fact]
		public void ZeroEqualsZero()
		{
			StringCalculator.Add("0").Should().Be(0);
		}

		[Fact]
		public void InputEqualsNumberIdentity()
		{
			StringCalculator.Add("1").Should().Be(1);
		}

		[Fact]
		public void InputContainsTwoNumbers()
		{
			StringCalculator.Add("1,2").Should().Be(3);
		}

		[Fact]
		public void InputContainsThreeNumbers()
		{
			StringCalculator.Add("1,2,3").Should().Be(6);
		}
	}
}