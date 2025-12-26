import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFiles {
    private boolean addModeFlag = true;

    WriteFiles(boolean flag){
        addModeFlag = flag;
    }

    public void createFile(String content, String fileName){
        if (content.isEmpty())
            return;

        File file = new File(fileName);
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try(FileWriter fileWriter = new FileWriter(file))
        {
            if(addModeFlag)
                fileWriter.append("\n" + content);
            else
                fileWriter.append(content);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean createFile(String content, String path, String fileName){
        if (content.isEmpty())
            return true;

        File file = new File(path, fileName);
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            createFile(content, fileName);
            return false;
        }
        try(FileWriter fileWriter = new FileWriter(file, addModeFlag))
        {
            if(addModeFlag)
                fileWriter.append("\n" + content);
            else
                fileWriter.append(content);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
