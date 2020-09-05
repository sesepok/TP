

public class Section1 extends AbstractSection
{

	public static void start(int task)
	{
		System.out.println("===============================");
		System.out.println("������ 1. ������ " + task);
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
			int a = readInt("������ ����� >");
			int b = readInt("������ ����� >");
			System.out.println("���������: " + remainder(a,b));
			if (!continuePrompt()) break;
		}
	}
	
	public static int remainder(int a, int b)
	{
		return a % b;
	}
	
	public static void task2()
	{
		while (true)
		{
			double a = readDouble("���������");
			double h = readDouble("������");
			System.out.println("���������: " + triArea(a, h));
			if (!continuePrompt()) break;
		}
	}
	
	public static double triArea(double a, double h)
	{
		return a * h / 2;
	}
	
	public static void task3()
	{
		while (true)
		{
			int chickens = readInt("���������� �����");
			int cows = readInt("���������� �����");
			int pigs = readInt("���������� ������");
			System.out.println("���������: " + animals(chickens, cows, pigs));
			if (!continuePrompt()) break;
		}
	}
	
	public static int animals(int chickens, int cows, int pigs)
	{
		return chickens * 2 + cows * 4 + pigs * 4;
	}
	
	public static void task4()
	{
		while (true)
		{
			double prob = readDouble("����������� (prob)");
			double prize = readDouble("���� (prize)");
			double pay = readDouble("����� (pay)");
			System.out.println("���������: " + profitableGamble(prob, prize, pay));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean profitableGamble(double prob, double prize, double pay)
	{
		return prob * prize > pay;
	}
	
	public static void task5()
	{
		while (true)
		{
			int N = readInt("N");
			int a = readInt("a");
			int b = readInt("b");
			System.out.println("���������: " + operation(N, a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static String operation(int N, int a, int b)
	{
		if (N == a + b)
			return "added";
		else if (N == a - b)
			return "subtracted";
		else if (N == a * b)
			return "multiplied";
		else if (N == a / b)
			return "divided";
		else
			return "none";
	}
	
	public static void task6()
	{
		while (true)
		{
			char c = readChar("������");
			System.out.println("���������: " + ctoa(c));
			if (!continuePrompt()) break;
		}
	}
	
	public static int ctoa(char c)
	{
		return (int) c;
	}
	
	public static void task7()
	{
		while (true)
		{
			int n = readInt("�����");
			System.out.println("���������: " + addUpTo(n));
			if (!continuePrompt()) break;
		}
	}
	
	public static int addUpTo(int a)
	{
		return a * (a + 1) / 2;
	}
	
	public static void task8()
	{
		while (true)
		{
			int a = readInt("������ �������");
			int b = readInt("������ �������");
			System.out.println("���������: " + nextEdge(a, b));
			if (!continuePrompt()) break;
		}
	}
	
	public static int nextEdge(int a, int b)
	{
		return a + b - 1;
	}
	
	public static void task9()
	{
		while (true)
		{
			int arr[] = readIntArray("������");
			System.out.println("���������: " + sumOfCubes(arr));
			if (!continuePrompt()) break;
		}
	}
	
	public static int sumOfCubes(int[] arr)
	{
		int res = 0;
		for (int element : arr)
		{
			res += element * element * element;
		}
		return res;
	}
	
	public static void task10()
	{
		while (true)
		{
			int a = readInt("a");
			int b = readInt("b");
			int c = readInt("c");
			System.out.println("���������: " + abcmath(a,b,c));
			if (!continuePrompt()) break;
		}
	}
	
	public static boolean abcmath(int a, int b, int c)
	{
		for (int i = 0; i < b; i++)
			a += a;
		return a % c == 0;
		
	}

}
