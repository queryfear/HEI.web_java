package LAB4.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import LAB4.checker.IListInclusionChecker;
import LAB4.checker.ListInclusionChecker;
import LAB4.util.FileUtil;

public class UI implements IUI{
	private static final Scanner scanner = new Scanner(System.in);

	@Override
	public void start(){
		while (true){

        // Запрос выбора типа данных
        System.out.println("Выберите тип данных для списков:? (введите 'число' или 'строка'): ");
        String dataType = scanner.nextLine().trim().toLowerCase();

        switch (dataType) {
					case "число":
						List<Integer> L1 = getIntegerListFromUser("Введите элементы списка L1 (через пробел): ");
						List<Integer> L2 = getIntegerListFromUser("Введите элементы списка L2 (через пробел): ");
						processSublistCheck(L1, L2);
						break;
					case "строка":
						List<String> L3 = getStringListFromUser("Введите элементы списка L1 (через пробел): ");
						List<String> L4 = getStringListFromUser("Введите элементы списка L2 (через пробел): ");
						processSublistCheck(L3, L4);
						break;
					default:
					System.out.println("Ошибка: неподдерживаемый тип данных. Пожалуйста, напишите 'число' или 'строка'.");
            
        }
		}
	}

	// Метод для получения списка чисел от пользователя
	private static List<Integer> getIntegerListFromUser(String prompt) {
		System.out.println(prompt);
		String input = scanner.nextLine();
		List<Integer> list = new ArrayList<>();
		for (String num : input.split("\\s+")) {
				try {
						list.add(Integer.parseInt(num));
				} catch (NumberFormatException e) {
						System.out.println("Ошибка: введите только целые числа.");
						return getIntegerListFromUser(prompt); // повторяем ввод при ошибке
				}
		}
		return list;
	}

	// Метод для получения списка строк от пользователя
	private static List<String> getStringListFromUser(String prompt) {
		System.out.println(prompt);
		String input = scanner.nextLine();
		List<String> list = new ArrayList<>();
		for (String item : input.split("\\s+")) {
				list.add(item); // добавляем строки без преобразования
		}
		return list;
	}

	// Метод для обработки проверки подсписка и сохранения результата
	private static <T> void processSublistCheck(List<T> L1, List<T> L2) {
			IListInclusionChecker<T> checker = new ListInclusionChecker<>();
			boolean isSublist = checker.isSublist(L1, L2);
			String resultText = "L1 является подсписком L2: " + isSublist;

			// Вывод результата на экран
			System.out.println(resultText);

			// Сохранение результата в файл с выбором опции
			saveResultToFile(resultText);

			// Используем итератор для вывода элементов списка L2
			System.out.println("Элементы списка L2:");
			ListIterator<T> iterator = L2.listIterator();
			while (iterator.hasNext()) {
					System.out.print(iterator.next() + " ");
			}
			System.out.println();
	}

	// Метод для сохранения результата в файл с выбором опции добавления или перезаписи
	private static void saveResultToFile(String resultText) {
			System.out.println("Сохранить результат в файл? (да/нет): ");
			String choice = scanner.nextLine().trim().toLowerCase();
			switch (choice) {
				case "да":
				System.out.println("Вы хотите добавить результат в файл или перезаписать его? (введите 'добавить' или 'перезаписать'): ");
				String saveOption = scanner.nextLine().trim().toLowerCase();
				boolean append = saveOption.equals("добавить");

				// Сохраняем в файл result.txt
				FileUtil.saveResult("result.txt", resultText, append);
				System.out.println("Результат успешно сохранен в файл result.txt.");
					break;
				case "нет":
				System.out.println("Результат не был сохранен.");
					break;
				default:
				System.out.println("Некорректный выбор. Пожалуйста, напишите 'да' или 'нет'.");
					break;
			}
	}
}
