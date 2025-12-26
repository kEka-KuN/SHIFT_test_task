
public class CUI {

    private WriteFiles storage;
    private SortAndStatistics work;
    private String newPath = null; //-o
    private String namePrefix = ""; //-p
    private boolean addModeFlag = false; //-a
    private boolean shortStatFlag = false; //-s
    private boolean fullStatFlag = false; //-f

    CUI(String[] args){
        ReadFiles source = new ReadFiles();

        for(int i=0; i < args.length; i++) {

            switch (args[i]) {
                case "-o":
                    newPath = args[i+1];
                    i++;
                    break;
                case  "-p":
                    namePrefix = args[i+1];
                    i++;
                    break;
                case "-a":
                    addModeFlag = true;
                    break;
                case "-s":
                    if (!fullStatFlag)
                        shortStatFlag = true;
                    break;
                case  "-f":
                    shortStatFlag = false;
                    fullStatFlag = true;
                    break;
                default:
                    if(args.length == i+1){
                        System.out.println("Отсутствует второй файл");
                    }
                    else {
                        source = new ReadFiles(args[i], args[i+1]);
                        i++;
                    }
            }
        }
        if (source.getContent() != null)
            work = new SortAndStatistics(source.getContent());
        else {
            System.exit(1);
        }
        storage = new WriteFiles(addModeFlag);
    }

    public void start(){
        
        boolean newPathSuccess = true;
        
        if (shortStatFlag){
            System.out.println("Количество строк: " + work.getTextCount());
            System.out.println("Количество целых чисел: " + work.getIntCount());
            System.out.println("Количество дробных чисел: " + work.getFloatCount());
        }
        if (fullStatFlag){
            System.out.println(work.getFullTextStat());
            System.out.println(work.getFullIntStat());
            System.out.println(work.getFullFloatStat());
        }
        if (newPath != null){
            newPathSuccess = storage.createFile(work.getTextStr(), newPath, namePrefix + "strings.txt") && newPathSuccess;
            newPathSuccess = storage.createFile(work.getIntStr(), newPath, namePrefix + "integers.txt") && newPathSuccess;
            newPathSuccess = storage.createFile(work.getFloatStr(), newPath, namePrefix + "floats.txt") && newPathSuccess;
        } else {
            storage.createFile(work.getTextStr(),  namePrefix + "strings.txt");
            storage.createFile(work.getIntStr(), namePrefix + "integers.txt");
            storage.createFile(work.getFloatStr(), namePrefix + "floats.txt");
        }
        if (!newPathSuccess)
            System.out.println("Путь для выходных файлов задан не верно, файлы созданы в текущей папке");
    }
}
