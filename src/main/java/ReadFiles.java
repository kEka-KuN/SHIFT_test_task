import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ReadFiles {

    private File file1;
    private File file2;
    private String str;

    ReadFiles(){}

    ReadFiles(String firstFile, String secondFile){

        String firstFileContent;
        String secondFileContent;

        file1 = new File(firstFile);
        file2 = new File(secondFile);

        if (!file1.isFile() || !file2.isFile()){
            System.out.println("Входные файлы не найдены");
            return;
        }

        try {
            firstFileContent = Files.readString(file1.toPath());
            secondFileContent = Files.readString(file2.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(firstFileContent.charAt(firstFileContent.length() -1) == '\n')
            str = firstFileContent + secondFileContent;
        else
            str = String.join("\n",firstFileContent, secondFileContent);
    }

    public String getContent() {
        return str;
    }
}
