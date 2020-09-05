

public class Section2 extends AbstractSection
{
	protected static int sectionNum = 2;
	

	public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("Раздел 2. Задача " + task);
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
			String s = readString("Строка");
			int n = readInt("n");
			System.out.println("Результат: " + repeat(s, n));
			if (!continuePrompt()) break; 
		}
	}
	
	public static String repeat(String str, int n)
	{
		String res = "";
		for (int i = 0; i < str.length(); i++)
			for (int j = 0; j < n; j++)
				res += str.charAt(i);
		return res;
	}
	
	public static void task2()
	{
		while (true)
		{
			int arr [] = readIntArray("Массив");
			System.out.println("Результат: " + differenceMaxMin(arr));
			if (!continuePrompt()) break;
		}
	}
	
	public static int differenceMaxMin(int[] arr)
	{
		int min = arr[0];
		int max = arr[0];
		for (int element : arr)
		{
			if (element < min)
				min = element;
			if (element > max)
				max = element;
		}
		return max - min;
	}
	
	public static void task3()
	{
		while (true)
		{
			int[] arr = readIntArray("Массив");
			System.out.println("Результат: " + isAvgWhole(arr));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isAvgWhole(int[] arr)
	{
		double avg = 0;
		for (int e : arr)
			avg += e;
		avg /= arr.length;
		return avg % 1 == 0;
	}
	
	public static void task4()
	{
		while (true)
		{
			int[] arr = readIntArray("Массив");
			System.out.println("Результат:");
			printArray(cumulativeSum(arr));
			if (!continuePrompt()) break;
		}
	}
	
	public static int[] cumulativeSum(int[] arr)
	{
		int[] res = new int[arr.length];
		int accumulated = 0;
		for (int i = 0; i < arr.length; i++)
		{
			accumulated += arr[i];
			res[i] = accumulated;
		}
		return res;
	}
	
	public static void task5()
	{
		while (true)
		{
			String input = readString("Число в виде строки:");
			System.out.println("Результат: " + getDecimalPlaces(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int getDecimalPlaces(String str)
	{
		int index = str.indexOf(".");
		if (index == -1) return 0;
		return str.length() - index - 1;
	}
	
	public static void task6()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + Fibonacci(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int Fibonacci(int n)
	{
		int a = 1;
		int b = 1;
		for (int i = 2; i <= n; i++)
		{
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
	
	public static void task7()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + isValid(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isValid(String str)
	{
		if (str.length() > 5) return false;
		for (int i = 0; i < str.length(); i++)
			if (!Character.isDigit(str.charAt(i))) return false;
		return true;
	}
	
	public static void task8()
	{
		while (true)
		{
			String a = readString("Первая строка");
			String b = readString("Вторая строка");
			System.out.println("Результат: " + isStrangePair(a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isStrangePair(String a, String b)
	{
		if (a.equals("") && b.equals("")) return true;
		return a.charAt(0) == b.charAt(b.length()-1) && b.charAt(0) == a.charAt(a.length() - 1);
	}
	
	public static void task9()
	{
		while (true)
		{
			String a = readString("Слово");
			String b = readString("Префикс/Суффикс");
			System.out.println("isPrefix: " + isPrefix(a, b));
			System.out.println("isSuffix: " + isSuffix(a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean isPrefix(String word, String prefix)
	{
		return word.startsWith(prefix.substring(0, prefix.length()-1));
	}
	
	public static boolean isSuffix(String word, String suffix)
	{
		return word.endsWith(suffix.substring(1, suffix.length()));
	}
	
	public static void task10()
	{
		while (true)
		{
			int n = readInt("Число");
			System.out.println("Результат " + boxSeq(n));
			if (!continuePrompt()) break;
		}
	}
	
	public static int boxSeq(int n)
	{
		if (n % 2 == 0) return n;
		else return n + 2;
	}
	
}
