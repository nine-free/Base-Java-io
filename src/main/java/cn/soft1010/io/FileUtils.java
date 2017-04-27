package cn.soft1010.io;

import java.io.File;

/**
 * Created by zhangjifu on 2017/4/27.
 */
public class FileUtils {

    /**
     * 删除文件OR目录
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files
                    ) {
                deleteFile(file1);
            }
            file.delete();
        } else {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        FileUtils.deleteFile(new File("tmp"));
    }
}
