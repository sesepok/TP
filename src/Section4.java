import java.util.ArrayList;

public class Section4 extends AbstractSection
{
	public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("Раздел 4. Задача " + task);
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
			int n = readInt("N (кол-во строк) (не влияет на алгоритм)");
			int k = readInt("k (допустимое количество букв в стркое)");
			String input = readString("Строка");
			System.out.println("Результат: ");
			System.out.println(essay(n, k, input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String essay(int words, int lineWidth, String str)
	{
		String[] lines = str.split(" ");
		String res = "";
		int currentLine = 0;
		for (String line: lines)
		{
			if (line.length() + currentLine <= lineWidth)
			{
				res += " " + line;
				currentLine += line.length();
			}
			else
			{
				res += "\n" + line;
				currentLine = line.length();
			}
		}
		return res;
	}
	
	public static void task2()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: ");
			printArray(split(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String[] split(String str)
	{
		ArrayList<String> res = new ArrayList<String>();
		
		int opened = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == '(')
				opened++;
			else
				opened--;
			if (opened == 0)
			{
				end = i + 1;
				res.add(str.substring(start, end));
				start = end;
			}
		}
		return res.toArray(new String[0]);
	}
	
	public static void task3()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("toCamelCase: " + toCamelCase(input));
			System.out.println("toSnakeCase: " + toSnakeCase(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String toCamelCase(String str)
	{
		String[] words = str.split("_");
		String res = words[0];
		for (int i = 1; i < words.length; i++)
		{
			res += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
		}
		return res;
	}
	
	public static String toSnakeCase(String str)
	{
		String res = "";
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++)
		{
			if (Character.isUpperCase(str.charAt(i)))
			{
				end = i;
				if (start == 0)
					res += str.substring(start, end);
				else
					res += "_" + Character.toLowerCase(str.charAt(start)) + str.substring(start + 1, end);
				start = end;
			}
		}
		if (start != 0) res += "_";
		res += Character.toLowerCase(str.charAt(start)) + str.substring(start + 1);
		return res;
	}
	
	public static void task4()
	{
		while (true)
		{
			double[] input = readDoubleArray("Массив входных значений");
			System.out.println("Результат: " + overTime(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String overTime(double[] input)
	{
		double start = input[0];
		double end = input[1];
		double perHour = input[2];
		double multiplier = input[3];
		
		double earned = 0;
		if (start < 17 && end <= 17)
			earned = (end - start) * perHour;
		else if (start >= 17 && end > 17)
			earned = (end - start) * perHour * multiplier;
		else
			earned = ((17 - start) + (end - 17) * multiplier) * perHour;
		
		int dollars = (int)earned;
		int cents = (int)Math.round((earned % 1) * 100);
		return "$" + dollars + "." + cents + ((cents == 0 ? "0" : ""));
	}
	
	public static void task5()
	{
		while (true)
		{
			String weight = readString("Введие вес (строка с ед. измерения)");
			String height = readString("Введие рост (строка с ед. измерения)");
			System.out.println("Результат: " + BMI(weight, height));
			if (!continuePrompt()) break;
		}
	}
	
	public static String BMI(String weight, String height)
	{
		double w = Double.parseDouble(weight.split(" ")[0]);
		if (weight.endsWith("pounds"))
			w *= 0.45359237;
		double h = Double.parseDouble(height.split(" ")[0]);
		if (height.endsWith("inches"))
			h *= 0.0254;
		double index = w / (h*h);
		System.out.println(index);
		index = Math.round(index * 10) / 10.0;
		String category = "";
		if (index < 18.5)
			category = "Underweight";
		else if (index < 25)
			category = "Normal weight";
		else category = "Overweight";
		return index + " " + category;
			
	}
	
	public static void task6()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + bugger(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int bugger(int n)
	{
		int count = 0;
		while (n > 10)
		{
			int temp = n;
			int product = 1;
			while (temp > 0)
			{
				product *= (temp % 10);
				temp /= 10;
			}
			n = product;
			count++;
		}
		return count;
	}
	
	public static void task7()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + toStarShorthand(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String toStarShorthand(String str)
	{
		String res = "";
		char lastChar = ' ';
		int count = 0;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == lastChar)
				count++;
			else
			{
				if (lastChar != ' ')
				{
					if (count > 1)
						res += lastChar + "*" + count;
					else
						res += lastChar;
				}
				lastChar = str.charAt(i);
				count = 1;
			}
		}
		if (count > 1)
			res += lastChar + "*" + count;
		else
			res += lastChar;
		return res;
	}
	
	public static void task8()
	{
		while (true)
		{
			String a = readString("Первая строка");
			String b = readString("Вторая строка");
			System.out.println("Результат: " + doesRhyme(a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean doesRhyme(String a, String b)
	{
		String lastA = a.substring(a.lastIndexOf(" ") + 1).toUpperCase();
		String lastB = b.substring(b.lastIndexOf(" ") + 1).toUpperCase();
		
		String vowelsA = "";
		String vowelsB = "";
		for (int i = 0; i < lastA.length(); i++)
			if ("AEIOUY".contains(lastA.substring(i, i+1)))
				vowelsA += lastA.charAt(i);
		for (int i = 0; i < lastB.length(); i++)
			if ("AEIOUY".contains(lastB.substring(i, i+1)))
				vowelsB += lastB.charAt(i);
		return vowelsA.equals(vowelsB);
				
	}
	
	public static void task9()
	{
		while (true)
		{
			long a = readLong("Первое число");
			long b = readLong("Второе число");
			System.out.println("Результат: " + trouble(a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean trouble(long a, long b)
	{
		String strA = Long.toString(a);
		String strB = Long.toString(b);
		int[] repeatsA = new int[10];
		int[] repeatsB = new int[10];
		for (int i = 0; i < strA.length(); i++)
			repeatsA[Integer.parseInt(strA.substring(i, i+1))]++;
		for (int i = 0; i < strB.length(); i++)
			repeatsB[Integer.parseInt(strB.substring(i, i+1))]++;
		for (int i = 0; i < 10; i++)
			if (repeatsA[i] == 3 && repeatsB[i] == 2)
				return true;
		return false;
		
	}
	
	public static void task10()
	{
		while (true)
		{
			String str = readString("Строка");
			char c = readChar("Символ");
			System.out.println("Результат: " + countUniqueBooks(str, c));
			if (!continuePrompt()) break;
		}
	}
	
	public static int countUniqueBooks(String str, char c)
	{
		boolean bookOpen = false;
		String uniqueChars = "";
		String currentBook = "";
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == c)
			{
				if (bookOpen)
					uniqueChars += currentBook;
				bookOpen = !bookOpen;
			}
			else
			{
				if (bookOpen)
					if (!uniqueChars.contains(str.substring(i, i+1))
							&& !currentBook.contains(str.substring(i, i+1)))
						uniqueChars += str.charAt(i);
			}
		}
		return uniqueChars.length();
		
	}
	
}
