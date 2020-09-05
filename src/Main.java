import java.util.Scanner;

public class Main {
	private static int currentSection = 0;
	private static int currentTask = 0;
	
	
	public static void main(String[] args)
	{
		System.out.println("Задачи по предмету ТП");
		System.out.println("Выполнил студент группы БСТ1702 Заздравнов Вячеслав");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true)
		{
			while (true)
			{
				System.out.println("===============================");
				System.out.print("Введите номер раздела (0 - выход) >");
				currentSection = scanner.nextInt();
				if (currentSection == 0) System.exit(0);
				if (currentSection < 1 || currentSection > 6)
					System.out.println("Неверный номер раздела");
				else
					break;
			}
			while (true)
			{
				System.out.print("Введите номер задачи >");
				currentTask = scanner.nextInt();
				if (currentTask < 1 || currentTask > 10)
					System.out.println("Неверный номер задачи");
				else
					break;
			}
			
			switch(currentSection)
			{
			case 1:
				Section1.start(currentTask);
				break;
			case 2:
				Section2.start(currentTask);
				break;
			case 3:
				Section3.start(currentTask);;
				break;
			case 4:
				Section4.start(currentTask);
				break;
			}
			
		}
	}
			
}
