import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section6 extends AbstractSection
{
	public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("Раздел 6. Задача " + task);
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
			int input = readInt("Число");
			System.out.println("Результат: " + bell(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int bell(int n)
	{
        int[][] triangle = new int[n+1][n+1]; 
        triangle[0][0] = 1; 
          
        for (int i=1; i <= n; i++) 
        { 
        	triangle[i][0] = triangle[i-1][i-1]; 
            for (int j=1; j<=i; j++) 
            	triangle[i][j] = triangle[i-1][j-1] + triangle[i][j-1]; 
        } 
          
        return triangle[n][0]; 
	}

	
	public static void task2()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + translateSentence(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String translateWord(String s)
	{
		if("aoueiy".contains(s.substring(0, 1).toLowerCase()))
		{
			return s + "yay";
		}
		else
		{
			while(!"aoueiy".contains(s.substring(0, 1).toLowerCase()))
			{
				if (Character.isUpperCase(s.charAt(0)))
					s = s.substring(1,2).toUpperCase() + s.substring(2) + s.substring(0,1).toLowerCase();
				else
					s = s.substring(1) + s.substring(0,1);
			}
			return s + "ay";
		}
	}
	
	public static String translateSentence(String s)
	{
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(s);
		int index = 0;
		while (m.find())
		{
			String word = m.group();
			index = s.indexOf(word, index);
			s = s.substring(0, index) + s.substring(index).replaceFirst(word, translateWord(word));
		}
		return s;
	}
	
 
	
	public static void task3()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: " + validColor(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean validColor(String s)
	{
		s = s.toLowerCase();
		if (s.charAt(s.length() - 1) != ')') return false;
		if (s.substring(0, 4).contentEquals("rgb(") || s.substring(0, 5).contentEquals("rgba("))
		{
			String[] sNumbers = null;
			if(s.charAt(3) == 'a')
				sNumbers = s.substring(5, s.length()-1).split(",");
			else
				sNumbers = s.substring(4, s.length()-1).split(",");
			if (sNumbers.length < 3 || sNumbers.length > 4) return false;
			for (int i = 0; i < 3; i++)
			{
				try
				{
					int iNumber = Integer.parseInt(sNumbers[i]);
					if (iNumber < 0 || iNumber > 255) return false;
				}
				catch (NumberFormatException e)
				{
					return false;
				}
			}
			if (sNumbers.length == 4)
			{
				try
				{
					double dNumber = Double.parseDouble(sNumbers[3]);
					if (dNumber < 0 || dNumber > 1) return false;
				}
				catch(NumberFormatException e)
				{
					return false;
				}
			}
			return true;
				
		}
		else return false;
	}
 
	
	public static void task4()
	{
		int cmd = 0;
		while (true)
		{
			System.out.println("Только строка - 1, Строка и массив параметров - 2");
			cmd = readInt("Команда");
			if (cmd < 1 || cmd > 2)
				System.out.println("Неверная команда");
			else
				break;
		}
		while (true)
		{
			String input = readString("Строка");
			String[] params = null;
			if(cmd == 2)
			{
				params = readStringArray("Параметры к удалению");
				System.out.println("Результат: " + stripUrlParams(input, params));
			}
			else
			{
				System.out.println("Результат: " + stripUrlParams(input));
			}
			if (!continuePrompt()) break;
		}
	}
	
	public static String stripUrlParams(String s)
	{
		int questionMarkIndex = s.indexOf("?");
		if (questionMarkIndex == -1) return s;
		String[] params = s.substring(questionMarkIndex + 1).split("&");
		String result = s.substring(0, questionMarkIndex);
		String paramsResult = "";
		for (int i = 0; i < params.length; i++)
		{
			String paramName = params[i].substring(0, params[i].indexOf("="));
			String paramValue = params[i].substring(params[i].indexOf("=") + 1);
			boolean foundEarlier = false;
			for (int j = 0; j < i; j++)
			{
				String earlierParamName = params[j].substring(0, params[j].indexOf("="));
				if(paramName.contentEquals(earlierParamName))
				{
					foundEarlier = true;
					break;
				}
			}
			if (foundEarlier) continue;
			for (int j = i + 1; j < params.length; j++)
			{
				String laterParamName = params[j].substring(0, params[j].indexOf("="));
				if(paramName.contentEquals(laterParamName))
				{
					paramValue = params[j].substring(params[j].indexOf("=") + 1);
				}
			}
			
			if (paramsResult.length() > 0) paramsResult += "&";
			paramsResult += paramName + "=" + paramValue;
		}
		if (paramsResult.length() > 0)
		{
			result += "?" + paramsResult;
		}
		return result;
	}
	
	public static String stripUrlParams(String s, String[] paramsToStrip)
	{
		printArray(paramsToStrip);
		int questionMarkIndex = s.indexOf("?");
		if (questionMarkIndex == -1) return s;
		String[] params = s.substring(questionMarkIndex + 1).split("&");
		String result = s.substring(0, questionMarkIndex);
		String paramsResult = "";
		for (int i = 0; i < params.length; i++)
		{
			String paramName = params[i].substring(0, params[i].indexOf("="));
			String paramValue = params[i].substring(params[i].indexOf("=") + 1);
			boolean foundEarlier = false;
			for (int j = 0; j < i; j++)
			{
				String earlierParamName = params[j].substring(0, params[j].indexOf("="));
				if(paramName.contentEquals(earlierParamName))
				{
					foundEarlier = true;
					break;
				}
			}
			if (foundEarlier) continue;
			for (int j = i + 1; j < params.length; j++)
			{
				String laterParamName = params[j].substring(0, params[j].indexOf("="));
				if(paramName.contentEquals(laterParamName))
				{
					paramValue = params[j].substring(params[j].indexOf("=") + 1);
				}
			}
			boolean foundInParamsToStrip = false;
			for (int j = 0; j < paramsToStrip.length; j++)
			{
				if (paramsToStrip[j].contentEquals(paramName))
				{
					foundInParamsToStrip = true;
					break;
				}
			}
			if (!foundInParamsToStrip)
			{
				if (paramsResult.length() > 0) paramsResult += "&";
				paramsResult += paramName + "=" + paramValue;
			}
		}
		
		if (paramsResult.length() > 0)
		{
			result += "?" + paramsResult;
		}
		return result;
	}
	
	public static void task5()
	{
		while (true)
		{
			String input = readString("Строка");
			System.out.println("Результат: ");
			printArray(getHashTags(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static String[] getHashTags(String s)
	{
		s = s.toLowerCase();
		String[] words = s.split("\\W");
		String first = "";
		String second = "";
		String third = "";
		for (int i = 0; i < words.length; i++)
		{
			if (words[i].length() > first.length())
			{
				third = second;
				second = first;
				first = words[i];
			}
			else if (words[i].length() > second.length())
			{
				third = second;
				second = words[i];
			}
			else if (words[i].length() > third.length())
			{
				third = words[i];
			}
		}
		String[] result = null;
		if (first.length() == 0) result = new String[0];
		else if (second.length() == 0) result = new String[1];
		else if (third.length() == 0) result = new String[2];
		else result = new String[3];
		
		if (result.length > 0) result[0] = first;
		if (result.length > 1) result[1] = second;
		if (result.length > 2) result[2] = third;
		
		for (int i = 0; i < result.length; i++)
			result[i] = "#" + result[i];
		
		return result;
	}
 
 
	public static void task6()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + ulam(input));
			if (!continuePrompt()) break;
		}
	}
	
	public static int ulam(int n)
	{
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		sequence.add(1);
		sequence.add(2);
		
		int number = 2;
		for (int i = 2; i < n; i++)
		{
			while (true)
			{
				number++;
				int count = 0;
				for (int j = 0; j < sequence.size() - 1; j++)
				{
					for (int k = j + 1; k < sequence.size(); k++)
					{
						if (sequence.get(j) + sequence.get(k) == number)
							count++;
					}
				}
				if (count == 1)
				{
					sequence.add(number);
					break;
				}
			}
		}
		return sequence.get(n - 1);
	}
	 
	
	public static void task7()
	{
	 
	}
	
	 
	
	public static void task8()
	{
 
	}
	
 
	
	public static void task9()
	{
 
	}
	
	 
	public static void task10()
	{
		while (true)
		{
			int input = readInt("Число");
			System.out.println("Результат: " + input);
			System.out.println( );
			if (!continuePrompt()) break;
		}
	}
	
 
	
	
}
