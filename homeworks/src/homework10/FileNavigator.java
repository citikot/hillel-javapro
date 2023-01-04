package homework10;

import java.util.*;

public class FileNavigator {

    private Map<String, ArrayList<FileData>> fileStorage;

    public FileNavigator() {
        fileStorage = new HashMap<>();
    }

    public void add(String filePath, FileData fileInfo) {
        if (!filePath.equals(fileInfo.getFilePath())) {
            System.out.printf("File path %s to store is not equal to the actual file data!%n", filePath);
        } else {
            if (fileStorage.containsKey(filePath)) {
                fileStorage.get(filePath).add(fileInfo);
            } else {
                ArrayList<FileData> section = new ArrayList<>();
                section.add(fileInfo);
                fileStorage.put(filePath, section);
            }
        }
    }

    public List<String> find(String path) {
        ArrayList<String> namesToReturn = new ArrayList<>();

        if (fileStorage.containsKey(path)) {
            for (FileData elem : fileStorage.get(path)) {
                namesToReturn.add(elem.getFileName());
            }
        } else {
            System.out.printf("File path %s is not found in the file storage!%n", path);
        }
        return namesToReturn;
    }

    public List<String> filterBySize(int sizeLimit) {
        List<String> namesToReturn = new ArrayList<>();
        Collection<ArrayList<FileData>> values;
        values = fileStorage.values();

        for (ArrayList<FileData> elem : values) {
            for (FileData entry : elem) {
                if (entry.getFileSize() <= sizeLimit) {
                    namesToReturn.add(entry.getFileName());
                }
            }
        }
        return namesToReturn;
    }

    public boolean remove(String path){
        if (fileStorage.containsKey(path)) {
            fileStorage.remove(path);
        } else {
            System.out.printf("File path %s is not found in the file storage!%n", path);
        }
        return false;
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileStorage=" + fileStorage +
                '}';
    }

}
