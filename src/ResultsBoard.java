import java.util.*;

//Написать программу для отслеживания успеваемости студентов:
//a. Каждая запись содержит имя студента и его средний балл.
//b. Реализовать структуру, которая хранит записи в порядке возрастания среднего балла.
//c. Вывести имена 3-х самых успешных студентов в порядке убывания среднего балла.

public class ResultsBoard {
    private TreeMap<Float, List<String>> studentMap;

    public ResultsBoard() {
        studentMap = new TreeMap<>(Collections.reverseOrder());
    }

    void addStudent(String name, Float score) {
        if (!studentMap.containsKey(score)) {
            studentMap.put(score, new ArrayList<>());
        }
        studentMap.get(score).add(name);
    }

    List<String> top3() {
        List<String> top3Students = new ArrayList<>();
        int count = 0;
        for (Map.Entry<Float, List<String>> entry : studentMap.entrySet()) {
            List<String> names = entry.getValue();
            for (String name : names) {
                top3Students.add(name);
                count++;
                if (count == 3) {
                    return top3Students;
                }
            }
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

