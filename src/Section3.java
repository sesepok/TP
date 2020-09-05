
public class Section3 extends AbstractSection
{
	public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("Раздел 1. Задача " + task);
		switch(task)
		{
		case 1:
			task1();
			break;
		case 2:
			task2();
			break;
		case 3:
			task3();
			break;
		case 4:
			task4();
			break;
		case 5:
			task5();
			break;
		case 6:
			task6();
			break;
		case 7:
			task7();
			break;
		case 8:
			task8();
			break;
		case 9:
			task9();
			break;
		case 10:
			task10();
			break;
		}
	}
	
	
	public static void task1()
	{
		while (true)
		{
			double a = readInt("a");
			double b = readInt("b");
			double c = readInt("c");
			System.out.println("Результат: " + solutions(a,b,c));
			if (!continuePrompt()) break;
		}
	}
	
	public static int solutions(double a, double b, double c)
	{
		double D = b * b - 4 * a * c;
		if (D < 0) return 0;
		else if (D == 0) return 1;
		else return 2;
	}
	
	public static void task2()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + findZip(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int findZip(String str)
	{
		int index = str.indexOf("zip");
		if (index == -1 || index == str.length() - 1) return -1;
		return str.indexOf("zip", index + 1);
	}
	
	public static void task3()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + checkPerfect(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean checkPerfect(int n)
	{
		int sum = 0;
		for (int i = 1; i < n; i++)
		{
			if (n % i == 0) sum += i;
		}
		return n == sum;
	}
	
	public static void task4()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + flipEndChars(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String flipEndChars(String str)
	{
		if (str.length() < 2) return "Incompatible.";
		if (str.charAt(0) == str.charAt(str.length() - 1)) return "Two's a pair.";
		return str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
	}
	
	public static void task5()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + isValidHexCode(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isValidHexCode(String str)
	{
		if (str.length() != 7 || str.charAt(0) != '#') return false;
		for (int i = 1; i < str.length(); i++)
		{
			if (!( Character.isDigit(str.charAt(i)) 
					|| "ABCDEFabcdef".contains(Character.toString((str.charAt(i))))))
				return false;
		}
		return true;
	}
	
	public static void task6()
	{
		while (true)
		{
			int[] a = readIntArray("Первый массив");
			int[] b = readIntArray("Второй массив");
			System.out.println("Результат: " + same(a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static int uniquesInArray(int[] arr)
	{
		int uniques = 0;
		for (int i = 0; i < arr.length - 1; i++)
		{
			boolean unique = true;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[i] == arr[j]) unique = false;
			}
			if (unique) uniques++;
		}
		return uniques;
	}
	
	public static boolean same(int[] a, int[] b)
	{
		return uniquesInArray(a) == uniquesInArray(b);
	}
	
	public static void task7()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + isKaprekar(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isKaprekar(int n)
	{
		String square = Integer.toString(n * n);
		String first = ""; String last = "";
		first = square.substring(0, square.length() / 2);
		last = square.substring(square.length() / 2, square.length());
		int a = first.equals("") ? 0 : Integer.parseInt(first);
		int b = last.equals("") ? 0 : Integer.parseInt(last);
		return a + b == n;
	}
	
	public static void task8()
	{
		while (true)
		{
			String input = readString("Число");
			System.out.println("Результат: " + longestZero(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String longestZero(String str)
	{
		int longest = 0;
		int current = 0;
		boolean zeroes = false;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == '0')
			{
				current++;
				zeroes = true;
			}
			else if (zeroes)
			{
				if (current > longest) longest = current;
				zeroes = false;
				current = 0;
			}
		}
		String res = "";
		for (int i = 0; i < longest; i++)
			res += "0";
		return res;
	}
	
	public static void task9()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + nextPrime(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isPrime(int n)
	{
		for (int i = 2; i < Math.sqrt(n) + 1; i++)
		{
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static int nextPrime(int n)
	{
		if (isPrime(n)) return n;
		while (true)
		{
			n++;
			if (isPrime(n)) return n;
		}
	}
	
	public static void task10()
	{
		while (true)
		{
			double a = readDouble("a");
			double b = readDouble("b");
			double c = readDouble("c");
			System.out.println("Результат: " + rightTriangle(a, b, c));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean rightTriangle(double a, double b, double c)
	{
		return (a*a + b*b == c*c)
				|| (a*a + c*c == b*b)
				|| (b*b + c*c == a*a);
	}

}
