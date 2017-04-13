package cn.soft1010.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangjifu on 2017/4/13.
 */
public class FileTest {

    public static void main(String[] args) {
        new FileTest().test();
    }

    private void test() {

        //文件不存在则创建
        File file = new File("tmp.tmp");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println("read:" + file.canRead() + "  write:" + file.canWrite() + "  exe:" + file.canExecute());

        System.out.println(File.separator + " " + File.pathSeparator);


        try {
            //创建 临时文件
            File tmpfile = File.createTempFile("zhang", "txt");
            System.out.println(tmpfile.getAbsolutePath());
            tmpfile.delete();
            System.out.println(tmpfile.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dir = new File("tmp/dir");
        if (!dir.exists()) {
            dir.mkdirs();

        }
        File filet1 = new File(dir, "t1.txt");
        try {
            filet1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File filet2 = new File(dir, "t2.txt");
        try {
            filet2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] files = dir.list();
        for (String fileName : files
                ) {
            System.out.println(fileName);
        }

        File[] files1 = dir.listFiles();
        for (File fileq : files1
                ) {
            System.out.println(fileq.getName());
        }


    }
}
