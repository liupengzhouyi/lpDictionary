package lpDictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class readFile {
    public static void main(String [] args) {

        String filePath = "C:\\Users\\liupe\\IdeaProjects\\javaObject\\src\\lpDictionary\\tempFile.txt";

        readTxtFile(filePath);

    }

    public static void readTxtFile(String filePath){
        try {
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file));//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    //System.out.println(lineTxt);
                    char[] a = lineTxt.toCharArray();
                    int k = 0;
                    int j = 0;
                    int length = a.length;
                    char[] word = new char[length];
                    char[] translation = new char[length];
                    for (int i=0;i<length;i++) {
                        if (k == 0) {
                            word[i] = a[i];
                        }
                        if (k == 1) {
                            translation[j] = a[i];
                            j ++ ;
                        }
                        if (a[i] == '\t' || a[i] == ' ') {
                            k = 1;
                        }
                    }
                    System.out.print(word);
                    System.out.print(translation);
                    System.out.println();
                    k = 0;
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
