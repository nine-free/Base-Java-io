package cn.soft1010.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by zhangjifu on 2017/4/27.
 */
public class FileFilterTest {

    public static void main(String[] args) {
        File file = new File("tmp/zhang");
        file.delete();
        if (!file.exists()) {
            file.mkdir();
        }
        File file1 = new File(file.getPath(), "1.txt");
        File file2 = new File(file.getPath(), "2.tmp");
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] files = file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
        for (File fil : files
                ) {
            if (fil.isFile()) {
                System.out.println(fil.getName());
                fil.delete();
            }
        }


    }

}
