import java.util.Scanner;

public class SortAndStatistics {

    private String textStr = "";
    private String intStr = "";
    private String floatStr = "";

    private int textCount = 0;
    private int intCount = 0;
    private int floatCount = 0;

    private Long maxInt = Long.MIN_VALUE;
    private Long minInt = Long.MAX_VALUE;
    private Double maxFloat = Double.MIN_VALUE;
    private Double minFloat = Double.MAX_VALUE;

    private Double sumInt = 0.0;
    private Double sumFloat = 0.0;
    private Double meanInt;
    private Double meanFloat;

    private int maxLength = Integer.MIN_VALUE;
    private int minLength = Integer.MAX_VALUE;


    SortAndStatistics(String str){
        long tempInt;
        double tempFloat;
        Scanner scanner = new Scanner(str);
        String line;

        while (scanner.hasNext()){
            line = scanner.nextLine();
            if(line.isEmpty())
                continue;

            try {
                tempInt = Long.parseLong(line);
                intCount++;
                sumInt +=tempInt;
                maxInt = Long.max(tempInt, maxInt);
                minInt = Long.min(tempInt, minInt);
                intStr += line + '\n';
                continue;
            } catch (NumberFormatException e){
            }

            try {
                tempFloat = Double.parseDouble(line);
                floatCount++;
                sumFloat += tempFloat;
                maxFloat = Double.max(tempFloat, maxFloat);
                minFloat = Double.min(tempFloat, minFloat);
                floatStr += line + '\n';
                continue;
            } catch (NumberFormatException e){
            }

            textCount++;
            maxLength = Integer.max(maxLength, line.length());
            minLength = Integer.min(minLength, line.length());
            textStr += line + '\n';
        }

        meanInt = sumInt / intCount;
        meanFloat = sumFloat / floatCount;

        if (!textStr.isEmpty())
            textStr = textStr.substring(0, textStr.length() - 1);
        else {
            maxLength = 0;
            minLength = 0;
        }
        if (!intStr.isEmpty())
            intStr = intStr.substring(0, intStr.length() -1);
        else {
            maxInt = 0L;
            minInt = 0L;
            meanInt = 0.0;
        }
        if (!floatStr.isEmpty())
            floatStr = floatStr.substring(0, floatStr.length() -1);
        else {
            maxFloat = 0.0;
            minFloat = 0.0;
            meanFloat = 0.;
        }
    }

    public String getTextStr(){
        return textStr;
    }
    public String getIntStr(){
        return intStr;
    }
    public String getFloatStr(){
        return floatStr;
    }

    public String getFullTextStat(){
        return "Количество строк: " + getTextCount() + '\n' +
                "Максимальная и минимальная длина строки соответствено равна: " +
                getMaxLength() + ", " + getMinLength();
    }
    public String getFullIntStat(){
        return "Количество целых чисел: " + getIntCount() + '\n' +
                "Максимальное и минимальное число: " + getMaxInt() + ", " + getMinInt() + '\n' +
                "Сумма всех целых чисел и их среднее значение: " + getSumInt() + ", " + getMeanInt();
    }
    public String getFullFloatStat(){
        return "Количество дробных чисел: " + getFloatCount() + '\n' +
                "Максимальное и минимальное число: " + getMaxFloat() + ", " + getMinFloat() + '\n' +
                "Сумма всех дробных чисел и их среднее значение: " + getSumFloat() + ", " + getMeanFloat();
    }

    public String getTextCount() {
        return Integer.toString(textCount);
    }
    public String getIntCount() {
        return Integer.toString(intCount);
    }
    public String getFloatCount() {
        return Integer.toString(floatCount);
    }
    public String getMaxInt() {
        return Long.toString(maxInt);
    }
    public String getMinInt() {
        return Long.toString(minInt);
    }
    public String getMaxFloat() {
        return Double.toString(maxFloat);
    }
    public String getMinFloat() {
        return Double.toString(minFloat);
    }
    public String getSumInt() {
        return Double.toString(sumInt);
    }
    public String getSumFloat() {
        return Double.toString(sumFloat);
    }
    public String getMeanInt() {
        return Double.toString(meanInt);
    }
    public String getMeanFloat() {
        return Double.toString(meanFloat);
    }
    public String getMaxLength() {
        return Integer.toString(maxLength);
    }
    public String getMinLength() {
        return Integer.toString(minLength);
    }
}
