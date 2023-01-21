import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName: replaceFilenameChar
 * @Description: 替换指定目录下的文件名中的字符
 * @Author: atnibamaitay
 * @CreateTime: 2023-01-21 14:47
 * @Version: 1.0
 **/
public class FileRename {
    /**
     * 替换文件名中的字符
     * @param path 文件所在目录路径
     * @param oldChar 需要被替换的字符
     * @param newChar 替换后的字符
     */
    public static void replaceFilenameChar(String path, String oldChar, String newChar) {
        // 将路径转化为 Path 对象
        Path pathObj = Paths.get(path);
        // 获取目录对应的 File 对象
        File directory = pathObj.toFile();

        // 判断目录是否存在
        if (directory.exists()) {
            // 遍历目录下的所有文件
            for (File file : directory.listFiles()) {
                // 判断当前遍历到的对象是否为文件
                if (file.isFile()) {
                    // 获取文件名
                    String fileName = file.getName();
                    // 判断文件名中是否包含需要替换的字符
                    if (fileName.contains(oldChar)) {
                        // 替换字符
                        String newFileName = fileName.replace(oldChar, newChar);
                        // 获取新文件的路径
                        String newFilePath = pathObj.resolve(newFileName).toString();
                        // 重命名文件
                        file.renameTo(new File(newFilePath));
                        // 输出重命名信息
                        System.out.println(fileName + " -> " + newFileName);
                    } else {
                        // 输出不需要重命名的信息
                        System.out.println(fileName + " 中无匹配字符，跳过。");
                    }
                }
            }
        } else {
            System.out.println("目录不存在，请检查路径是否正确。");
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Atnibam Aitay\\Downloads\\新建文件夹";
        String oldChar = "副本";
        String newChar = "替换后";
        replaceFilenameChar(path, oldChar, newChar);
    }
}