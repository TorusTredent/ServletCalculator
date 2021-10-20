package by.tms.storage;

import java.util.ArrayList;
import java.util.List;

public class CalculatorStorage {
    private static final List<String> historyList = new ArrayList<>();

    public static void addOperation (String operation) {
        historyList.add(operation);
    }

    public static List<String> getHistoryList() {
        return historyList;
    }
}
