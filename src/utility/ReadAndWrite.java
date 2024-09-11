package utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<String> readFileCSVToListString(String pathFile) {
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + pathFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + pathFile, e);
        }

        return stringList;
    }

    public static void writeStringListToFile(String pathFile, List<String> stringList, boolean append) {
        File file = new File(pathFile);

        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (String s : stringList) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
