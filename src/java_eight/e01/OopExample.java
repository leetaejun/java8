package java_eight.e01;

/*
 * OOP 및 람다 연습
 */

public class OopExample {
	public static void main(String args[]) {
		final FpCalculatorService fpCalculatorService = new FpCalculatorService();
		final Calculation addition = (i1, i2) -> i1 + i2;
		System.out.println("       additon: " + fpCalculatorService.calculate(addition, 11, 4));
		System.out.println("   subtraction: " + fpCalculatorService.calculate((i1, i2) -> i1 - i2, 11, 1));
		System.out.println("multiplication: " + fpCalculatorService.calculate((i1, i2) -> i1 * i2, 11, 2));
		System.out.println("      division: " + fpCalculatorService.calculate((i1, i2) -> i1 / i2, 20, 4));
		System.out.println("   custom calc: " + fpCalculatorService.calculate((i1, i2) -> ((i1 + i2) * 2) / i2, 20, 4));
	}
}

interface Calculation {
	int calculate(final int num1, final int num2);
}

class Addition implements Calculation {
	@Override
	public int calculate(final int num1, final int num2) {
		return num1 + num2;
	}
}

class Subtraction implements Calculation {
	@Override
	public int calculate(final int num1, final int num2) {
		return num1 - num2;
	}
}

class Multiplication implements Calculation {
	@Override
	public int calculate(final int num1, final int num2) {
		return num1 * num2;
	}
}

class Division implements Calculation {
	@Override
	public int calculate(final int num1, final int num2) {
		return num1 / num2;
	}
}

class FpCalculatorService {
	public int calculate(final Calculation calculation, final int num1, final int num2) {
		if (num1 > 10 && num2 < num1) {
			return calculation.calculate(num1, num2);
		} else {
			throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
		}
	}
}