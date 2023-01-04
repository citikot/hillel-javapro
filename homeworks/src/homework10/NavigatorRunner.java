package homework10;

public class NavigatorRunner {
    public static void main(String[] args) {
        FileData testFile1 = new FileData("abc", 185, "/dir1/dir2/");
        FileData testFile2 = new FileData("dfg", 135, "/dir1/dir2/");
        FileData testFile3 = new FileData("hij", 135, "/dir2/dir1/");
        FileData testFile4 = new FileData("klm", 135, "/dir2/dir1/");
        FileData testFile5 = new FileData("nop", 145, "/dir3/dir1/");
        FileData testFile6 = new FileData("qrs", 145, "/dir3/dir1/");
        FileData testFile7 = new FileData("tuv", 155, "/dir3/dir1/");
        FileData testFile8 = new FileData("xyz", 165, "/dir4/dir1/");



        FileNavigator fileStorage = new FileNavigator();

        fileStorage.add("/dir1/dir2/", testFile1);
        fileStorage.add("/dir1/dir2/", testFile2);
        fileStorage.add("/dir2/dir1/", testFile3);
        fileStorage.add("/dir3/dir1/", testFile5);
        fileStorage.add("/dir2/dir1/", testFile4);
        fileStorage.add("/dir3/dir1/", testFile6);
        fileStorage.add("/dir3/dir1/", testFile7);
        fileStorage.add("/dir4/dir1/", testFile8);

        System.out.println(fileStorage);
        System.out.println(fileStorage.find("/dir3/dir1/"));
        System.out.println(fileStorage.find("/dir10/dir1/"));
        System.out.println(fileStorage.filterBySize(145));
        System.out.println(fileStorage.filterBySize(130));
        System.out.println(fileStorage.sortBySize());
        System.out.println(fileStorage.remove("adsdf"));
        System.out.println(fileStorage.remove("/dir4/dir1/"));
        System.out.println(fileStorage);
    }
}
