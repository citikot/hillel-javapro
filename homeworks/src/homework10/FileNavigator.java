package homework10;

import java.util.*;

public class FileNavigator {

    private Map<String, List<FileData>> fileStorage;

    public FileNavigator() {
        fileStorage = new HashMap<>();
    }

    public void add(String filePath, FileData fileInfo) {
        if (!Objects.equals(filePath, fileInfo.getFilePath())) {
            System.out.printf("File path %s to store is not equal to the actual file data!%n", filePath);
        } else {
            if (fileStorage.containsKey(filePath)) {
                fileStorage.get(filePath).add(fileInfo);
            } else {
                List<FileData> section = new ArrayList<>();
                section.add(fileInfo);
                fileStorage.put(filePath, section);
            }
        }
    }

    public List<String> find(String path) {
        List<String> namesToReturn = new ArrayList<>();

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
        Collection<List<FileData>> values;
        values = fileStorage.values();

        for (List<FileData> elem : values) {
            for (FileData entry : elem) {
                if (entry.getFileSize() <= sizeLimit) {
                    namesToReturn.add(entry.getFileName());
                }
            }
        }
        return namesToReturn;
    }

    public List<FileData> sortBySize() {
        Collection<List<FileData>> collection = fileStorage.values();
        List<FileData> files = new ArrayList<>();
        for (List<FileData> arr : collection) {
            files.addAll(arr);
        }

        files.sort(Comparator.comparing(FileData::getFileSize));
        return files;
    }

    public boolean remove(String path) {
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
