import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName: replaceFilenameChar
 * @Description: �滻ָ��Ŀ¼�µ��ļ����е��ַ�
 * @Author: atnibamaitay
 * @CreateTime: 2023-01-21 14:47
 * @Version: 1.0
 **/
public class FileRename {
    /**
     * �滻�ļ����е��ַ�
     * @param path �ļ�����Ŀ¼·��
     * @param oldChar ��Ҫ���滻���ַ�
     * @param newChar �滻����ַ�
     */
    public static void replaceFilenameChar(String path, String oldChar, String newChar) {
        // ��·��ת��Ϊ Path ����
        Path pathObj = Paths.get(path);
        // ��ȡĿ¼��Ӧ�� File ����
        File directory = pathObj.toFile();

        // �ж�Ŀ¼�Ƿ����
        if (directory.exists()) {
            // ����Ŀ¼�µ������ļ�
            for (File file : directory.listFiles()) {
                // �жϵ�ǰ�������Ķ����Ƿ�Ϊ�ļ�
                if (file.isFile()) {
                    // ��ȡ�ļ���
                    String fileName = file.getName();
                    // �ж��ļ������Ƿ������Ҫ�滻���ַ�
                    if (fileName.contains(oldChar)) {
                        // �滻�ַ�
                        String newFileName = fileName.replace(oldChar, newChar);
                        // ��ȡ���ļ���·��
                        String newFilePath = pathObj.resolve(newFileName).toString();
                        // �������ļ�
                        file.renameTo(new File(newFilePath));
                        // �����������Ϣ
                        System.out.println(fileName + " -> " + newFileName);
                    } else {
                        // �������Ҫ����������Ϣ
                        System.out.println(fileName + " ����ƥ���ַ���������");
                    }
                }
            }
        } else {
            System.out.println("Ŀ¼�����ڣ�����·���Ƿ���ȷ��");
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Atnibam Aitay\\Downloads\\�½��ļ���";
        String oldChar = "����";
        String newChar = "�滻��";
        replaceFilenameChar(path, oldChar, newChar);
    }
}