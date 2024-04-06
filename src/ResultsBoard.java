import java.util.*;

//Написать программу для отслеживания успеваемости студентов:
//a. Каждая запись содержит имя студента и его средний балл.
//b. Реализовать структуру, которая хранит записи в порядке возрастания среднего балла.
//c. Вывести имена 3-х самых успешных студентов в порядке убывания среднего балла.
public class ResultsBoard {
    private TreeMap<Float, String> studentMap;

    public ResultsBoard() {
        studentMap = new TreeMap<>(Collections.reverseOrder());
    }
    void addStudent(String name, Float score) {
        studentMap.put(score, name);
    }

    List<String> top3() {
        List<String> top3Students = new ArrayList<>();
        int count = 0;
        for (String name : studentMap.values()) {
            top3Students.add(name);
            count++;
            if (count == 3)
                break;
        }
        return top3Students;
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();

        resultsBoard.addStudent("Иван", 4.5f);
        resultsBoard.addStudent("Мария", 4.0f);
        resultsBoard.addStudent("Петр", 4.8f);
        resultsBoard.addStudent("Анна", 4.2f);
        resultsBoard.addStudent("Сергей", 3.9f);

        System.out.println("Топ-3 самых успешных студентов:");
        List<String> top3 = resultsBoard.top3();
        for (String name : top3) {
            System.out.println(name);
        }
    }
}
