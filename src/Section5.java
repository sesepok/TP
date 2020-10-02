import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Section5 extends AbstractSection
{
	public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("Раздел 5. Задача " + task);
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
			int cmd = 0;
			while (true)
			{
				System.out.println("Введите команду");
				System.out.println("1 - строка в массив, 2 - массив в строку");
				cmd = readInt("Команда");
				if (cmd == 1 || cmd == 2) break;
				else System.out.println("Неверная команда");
			}
			if (cmd == 1)
			{
				String input = readString("Строка");
				System.out.println("Результат: ");
				printArray(encrypt(input));
				if (!continuePrompt()) break;
			}
			else
			{
				int[] input = readIntArray("Массив");
				System.out.println("Результат: ");
				System.out.println(decrypt(input));
				if (!continuePrompt()) break;
			}
		}
	}
	
	public static int[] encrypt(String str)
	{
		if (str.length() == 0) return new int[0];
		int charCode = (int) str.charAt(0);
		int[] res = new int[str.length()];
		res[0] = charCode;
		for (int i = 1; i < str.length(); i++)
		{
			res[i] = (int)str.charAt(i) - charCode; 
			charCode = (int)str.charAt(i);
		}
		return res;
	}
	
	public static String decrypt(int[] arr)
	{
		if (arr.length == 0) return "";
		int charCode = arr[0];
		String res = Character.toString((char)charCode);
		for (int i = 1; i < arr.length; i++)
		{
			res += (char)(charCode + arr[i]);
			//System.out.println("charCode = " + (charCode + arr[i]));
			charCode += arr[i];
		}
		return res;
	}
	
	public static void task2()
	{
		while (true)
		{
			String piece = readString("Фигура");
			String from = readString("Начальная позиция");
			String to = readString("Целевая позиция");
			System.out.println("Результат: " + canMove(piece, from, to));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean canMove(String piece, String from, String to)
	{
		int fileFrom = "ABCDEFGH".indexOf(from.charAt(0));
		int fileTo = "ABCDEFGH".indexOf(to.charAt(0));
		int rankFrom = (int)from.charAt(1) - (int)'0';
		int rankTo = (int)to.charAt(1) - (int)'0';
		
		switch (piece)
		{
		case "Rook":
			return (fileFrom == fileTo) || (rankFrom == rankTo);
		case "Bishop":
			return Math.abs(fileTo - fileFrom) == Math.abs(rankFrom - rankTo);
		case "Queen":
			return (fileFrom == fileTo) || (rankFrom == rankTo) 
					|| Math.abs(fileTo - fileFrom) == Math.abs(rankFrom - rankTo);
		case "Pawn":
			return Math.abs(rankTo - rankFrom) == 1;
		case "Knight":
			return (Math.abs(rankTo - rankFrom) == 2) && (Math.abs(fileTo - fileFrom) == 1)
			|| (Math.abs(rankTo - rankFrom) == 1) && (Math.abs(fileTo - fileFrom) == 2);
		case "King":
			return Math.abs(rankTo - rankFrom) == 1 || Math.abs(fileTo - fileFrom) == 1;
		default:
			return false;
		}
	}
	
	public static void task3()
	{
		while (true)
		{
			String from = readString("Начальная строка");
			String to = readString("Целевая строка");
			System.out.println("Результат: " + canComplete(from, to));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean canComplete(String from, String to)
	{
		int fromIndex = 0;
		int toIndex = 0;
		while (fromIndex < from.length() && toIndex < to.length())
		{
			if (from.charAt(fromIndex) == to.charAt(toIndex))
			{
				fromIndex++;
				toIndex++;
			}
			else
			{
				toIndex++;
			}
		}
		return toIndex < to.length() || fromIndex == from.length();
		
	}
	
	public static void task4()
	{
		while (true)
		{
			int[] input = readIntArray("Числа");
			System.out.println("Результат: " +subDigProd(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int subDigProd(int ... args)
	{
		int sum = 0;
		for (int x : args)
			sum += x;
		
		while (sum > 10)
		{
			int temp = sum;
			int product = 1;
			while (temp > 0)
			{
				product *= (temp % 10);
				temp /= 10;
			}
			sum = product;
		}
		return sum;
	}
	
	
	public static void task5()
	{
		while (true)
		{
			String[] input = readStringArray("Строки");
			System.out.println("Результат: ");
			printArray(sameVowelGroup(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean sameChars(String a, String b)
	{
		for (int i = 0; i < a.length(); i++)
			if (!b.contains(a.substring(i, i+1)))
				return false;
		for (int i = 0; i <b.length(); i++)
			if (!a.contains(b.substring(i, i+1)))
				return false;
		return true;
	}
	
	public static String[] sameVowelGroup(String[] strs)
	{
		if (strs.length == 0) return new String[0];
		String vowels = "";
		for (int i = 0; i < strs[0].length(); i++)
		{
			String letter = strs[0].substring(i, i+1).toUpperCase();
			if ("AOUIEY".contains(letter)
					&& !vowels.contains(letter))
				vowels += letter;
		}
		ArrayList<String> res = new ArrayList<String>();
		for (String word : strs)
		{
			String vowelsHere = "";
			for (int i = 0; i < word.length(); i++)
			{
				String letter = word.substring(i, i+1).toUpperCase();
				if ("AOUIEY".contains(letter))
					vowelsHere += letter;
			}
			if (sameChars(vowels, vowelsHere))
				res.add(word);
		}
		return res.toArray(new String[0]);
	}
	
	
	public static void task6()
	{
		while (true)
		{
			long input = readLong("Номер");
			System.out.println("Результат: " + validateCard(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean validateCard(long n)
	{
		String s = Long.toString(n);
		if (s.length() < 14 || s.length() > 19) return false;
		int check = Integer.parseInt(s.substring(s.length() - 1));
		int sum = 0;
		for (int i = 0; i < s.length() - 1; i++)
		{
			int num = Integer.parseInt(s.substring(s.length() - i - 2, s.length() - i - 1));
			if (i % 2 == 0)
			{
				int doubled = num * 2;
				if (doubled > 9)
					num = (doubled / 10) + (doubled % 10);
				else
					num = doubled;
			}
			sum += num;
		}
		int res = 10 - (sum % 10);
		return res == check;		
	}
	
	public static void task7()
	{
		int cmd = 0;
		while (true)
		{
			System.out.println("English - 1, Русский - 2");
			cmd = readInt("Команда");
			if (cmd < 1 || cmd > 2)
				System.out.println("Неверная команда");
			else
				break;
		}
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + ((cmd == 1) ? numToEng(input) : numToRus(input)));
			if (!continuePrompt()) break;
		}
	}
	
	public static String numToEng(int n)
	{
		if (n == 0) return "zero";
		
		int[] digits = {n / 100, (n % 100) / 10, n % 10};
		String[] singleDigitNums = {"zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine"};
		String[] tens = {"zero", "ten", "twenty", "thirty", "fourty", "fifty", "sixty",
				"seventy", "eighty", "ninety"};
		String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
				"sixteen", "seventeen", "eighteen", "nineteen"};
		
		String result = "";
		if (digits[0] > 0)
		{
			result += singleDigitNums[digits[0]] + " hundred";
		}
		
		if (digits[1] == 1)
		{
			if (result.length() > 0) result += " ";
			result += teens[digits[2]];
			return result;
		}
		else if (digits[1] > 1)
		{
			if (result.length() > 0) result += " ";
			result += tens[digits[1]];
		}
		
		if (digits[2] > 0)
		{
			if (result.length() > 0) result += " ";
			result += singleDigitNums[digits[2]];
		}
		
		return result;
	}
	
	public static String numToRus(int n)
	{
		if (n == 0) return "ноль";
		
		int[] digits = {n / 100, (n % 100) / 10, n % 10};
		String[] singleDigitNums = {"ноль", "один", "два", "три", "четыре",
				"пять", "шесть", "семь", "восемь", "девять"};
		String[] hundreds = {"ноль", "сто", "двести", "триста", "четыреста",
				"пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
		String[] tens = {"ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
				"семьдесят", "восемьдесят", "девяносто"};
		String[] teens = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
				"шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать"};
		
		String result = "";
		if (digits[0] > 0)
		{
			result += hundreds[digits[0]];
		}
		
		if (digits[1] == 1)
		{
			if (result.length() > 0) result += " ";
			result += teens[digits[2]];
			return result;
		}
		else if (digits[1] > 1)
		{
			if (result.length() > 0) result += " ";
			result += tens[digits[1]];
		}
		
		if (digits[2] > 0)
		{
			if (result.length() > 0) result += " ";
			result += singleDigitNums[digits[2]];
		}
		
		return result;
	}
	
	public static void task8()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + getSha256Hash(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String getSha256Hash(String s)
	{
		byte[] bytes = null;
		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			bytes = md.digest(s.getBytes(StandardCharsets.UTF_8));
		}
		catch(Exception e) {};
		BigInteger number = new BigInteger(1, bytes);
		StringBuilder result = new StringBuilder(number.toString(16));
		while (result.length() < 32)  
        {  
            result.insert(0, '0');  
        }  
        return result.toString();
		 
		
	}
	
	public static void task9()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + correctTitle(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String correctTitle(String s)
	{
		s = s.toLowerCase();
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++)
		{
			if (!(words[i].contentEquals("and") || words[i].contentEquals("of")
					|| words[i].contentEquals("the") || words[i].contentEquals("in")))
			{
				String newWord = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
				words[i] = newWord;
			}
		}
		return String.join(" ", words);
	}
	
	public static void task10()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: ");
			System.out.println(hexLattice(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String hexLattice(int n)
	{
		int size = 1;
		while(true)
		{
			if (3 * size * (size - 1) + 1 == n) break;
			if (3 * size * (size - 1) + 1 > n) return "Invalid";
			size++;
		}
		int lines = size * 2 - 1;
		String result = "";
		for (int line = 0; line < lines / 2; line++)
		{
			String newLine = "";
			for (int i = 0; i < size - line; i++)
				newLine += " ";
			for (int cell = 0; cell < size + line; cell++)
				newLine += "o ";
			for (int i = 0; i < size - line -1; i++)
				newLine += " ";
			newLine += "\n";
			result += newLine;
		}
		for (int line = lines / 2; line < lines; line++)
		{
			String newLine = "";
			for (int i = 0; i < size - (lines - line) + 1; i++)
				newLine += " ";
			for (int cell = 0; cell < size + (lines - line) - 1; cell++)
				newLine += "o ";
			for (int i = 0; i < size - (lines - line); i++)
				newLine += " ";
			newLine += "\n";
			result += newLine;
		}
		
		return result;
		
	}
	
	
}
