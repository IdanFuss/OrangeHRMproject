package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps
{
    @DataProvider(name = "Data provider - Login")
    public Object[][] getLoginDataObject() {
        return getDataFromCSV(getData("DDTLoginFile"));
    }

    @DataProvider(name = "Data provider - My info pic upload")
    public Object[][] getPicUploadDataObject() {
        return getDataFromCSV(getData("DDTUploadMyInfoPhoto"));
    }

    //Read csv file and return it lines as a list
    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    //Read lines and split each line for it ",". regardless lines and in line size
    public static Object[][] getDataFromCSV(String filePath) {
        List<String> csvData = readCSV(filePath);
        Object[][] data = new Object[csvData.size()][csvData.get(0).split(",").length];
        for (int i = 0; i < csvData.size(); i++) {
            for (int j = 0; j < csvData.get(0).split(",").length; j++){
                data[i][j] = csvData.get(i).split(",")[j];
            }
        }
        return data;
    }
}
