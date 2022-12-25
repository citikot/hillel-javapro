package homework9.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Record> records;

    public Phonebook() {
        records = new ArrayList<>();
    }

    public void add(String name, String number) {
        records.add(new Record(name, number));
    }

    public Record find(String name) {
        for (Record elem : records) {
            if (elem.getName().equals(name)) {
                return elem;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> result = new ArrayList<>();
        for (Record elem : records) {
            if (elem.getName().equals(name)) {
                result.add(elem);
            }
        }

        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }
}
