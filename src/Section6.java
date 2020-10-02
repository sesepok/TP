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
		 
	}
 
	
	public static void task5()
	{
 
	}
	
 
 
	public static void task6()
	{
 
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
