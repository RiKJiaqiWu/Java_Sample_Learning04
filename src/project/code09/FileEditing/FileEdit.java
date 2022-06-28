package project.code09.FileEditing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileEdit {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner in2 = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        while(true) {
            System.out.println("请选择要对哪个文件进行编辑：");
            System.out.println("01：生成新文件" + "\n" + "02：对已有文件进行修改");
            int i = in2.nextInt();
            if (i == 1) {
                File targetFile = createFile();
                System.out.println("请选择要执行的功能：");
                System.out.println("01：读取功能" + "\n" + "02：写入功能");
                i = in2.nextInt();
                switch (i) {
                    case 1: {
                        classicWay(targetFile);
                        break;
                    }
                    case 2: {
                        writeToFile(targetFile);
                        break;
                    }
                }
            }
            else if (i == 2) {
                System.out.println("请选择要对哪个文件进行编辑：");
                String SOURCE_FILE_NAME = str.next() + ".txt";
                File sourceFile = new File("." + File.separator + SOURCE_FILE_NAME);
                System.out.println("请选择要执行的功能：");
                System.out.println("01：读取功能" + "\n" + "02：写入功能" );
                i = in2.nextInt();
                switch (i) {
                    case 1: {
                        classicWay(sourceFile);
                        break;
                    }
                    case 2: {
                        writeToFile(sourceFile);
                        break;
                    }
                }
            }
        }
    }

    private static void writeToFile(File targetFile) throws IOException {

        try (
                FileOutputStream fos = new FileOutputStream(targetFile);

                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                String lineToWrite = in.nextLine().trim();
                System.out.println("输入内容为" + lineToWrite);
                if (lineToWrite.trim().isBlank()) {
                    System.out.println("输入结束");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static File createFile() throws IOException {
        System.out.println("请输入文件名：");
        String fileName = in.nextLine().trim();
        File f = new File("." + File.separator + fileName + ".txt");
        if (f.isFile()) {
            System.out.println("目标文件存在，删除：" + f.delete());
        }
        System.out.println(f.createNewFile());
        return f;
    }

    private static void classicWay(File sourceFile) {
        System.out.println("---------文件的内容为-------------");
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.trim().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
