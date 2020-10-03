

import java.util.Locale;
import java.util.Scanner;

public abstract class AbstractSection 
{
	protected static int sectionNum;
	
	protected static Scanner scanner;
	
	static
	{
		scanner = new Scanner(System.in).useLocale(Locale.US);;
	}
	
	/*public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("Раздел " + sectionNum + ". Задача " + task);
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
	}*/
	
	public static int readInt(String prompt)
	{
		while (true)
		{
			System.out.print(prompt + " >");
			String input = scanner.nextLine();
			try
			{
				return Integer.parseInt(input);
			}
			catch(Exception e)
			{
				System.out.println("Ошибка: требуется ввести число");
			}
		}
	}
	
	public static long readLong(String prompt)
	{
		while (true)
		{
			System.out.print(prompt + " >");
			String input = scanner.nextLine();
			try
			{
				return Long.parseLong(input);
			}
			catch(Exception e)
			{
				System.out.println("Ошибка: требуется ввести число");
			}
		}
	}
	
	
	public static double readDouble(String prompt)
	{
		while (true)
		{
			System.out.print(prompt + " >");
			String input = scanner.nextLine();
			try
			{
				return Double.parseDouble(input);
			}
			catch(Exception e)
			{
				System.out.println("Ошибка: требуется ввести число");
			}
		}
	}
	
	public static String readString(String prompt)
	{
		System.out.print(prompt + " >");
		return scanner.nextLine();
	}
	
	public static int [] readIntArray(String prompt)
	{
		while (true)
		{
			System.out.print(prompt + " >");
			String input = scanner.nextLine();
			if (input.equals("")) return new int[0];
			String[] strs = input.split(" ");
			try
			{
				int[] arr = new int[strs.length];
				for (int i = 0; i < strs.length; i++) arr[i] = Integer.parseInt(strs[i]);
				return arr;
			}
			catch (Exception e)
			{
				System.out.println("Ошибка: требуется ввести массив чисел");
			}
		}
	}
	
	public static double [] readDoubleArray(String prompt)
	{
		while (true)
		{
			System.out.print(prompt + " >");
			String input = scanner.nextLine();
			if (input.equals("")) return new double[0];
			String[] strs = input.split(" ");
			try
			{
				double[] arr = new double[strs.length];
				for (int i = 0; i < strs.length; i++) arr[i] = Double.parseDouble(strs[i]);
				return arr;
			}
			catch (Exception e)
			{
				System.out.println("Ошибка: требуется ввести массив чисел");
			}
		}
	}
	
	public static String[] readStringArray(String prompt)
	{
		System.out.print(prompt + " >");
		String input = scanner.nextLine();
		if (input.equals("")) return new String[0];
		String[] strs = input.split(" ");
		return strs;
	}
	
	public static void printArray(int[] arr)
	{
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		if (arr.length > 0)
			System.out.println(arr[arr.length-1] + "]");
		else
			System.out.println("]");
	}
	
	public static void printArray(String[] arr)
	{
		if (arr.length == 0)
		{
			System.out.println("[ ]");
			return;
		}
		System.out.print("[\"");
		for (int i = 0; i < arr.length - 1; i++)
		{
			System.out.print(arr[i] + "\", \"");
		}
		System.out.println(arr[arr.length-1] + "\"]");
	}
	
	public static char readChar(String prompt)
	{
		while (true)
		{
			System.out.print(prompt + " >");
			String input = scanner.nextLine();
			if (input.length() != 1)
			{
				System.out.println("Ошибка: требуется ввести один символ");
			}
			else
			{
				return input.charAt(0);
			}
		}

			
	}
	
	public static boolean continuePrompt()
	{
		System.out.print("Продолжить? (y/n) >");
		return (!scanner.nextLine().equalsIgnoreCase("N"));
	}
	
}
