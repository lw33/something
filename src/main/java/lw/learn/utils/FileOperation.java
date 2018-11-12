package lw.learn.utils;

import com.sun.istack.internal.Nullable;
import lw.learn.ds.Graph;
import lw.learn.ds.wg.WeightGraph;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Author lw
 * @Date 2018-11-05 15:26:56
 **/
public class FileOperation {

    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static boolean readFile(String filename, ArrayList<String> words) {

        if (filename == null || words == null) {
            System.out.println("filename is null or words is null");
            return false;
        }

        // 文件读取
        Scanner scanner = getScanner(filename);
        if (scanner == null)
            return false;
        /*try {
            URL resource = FileOperation.class.getClassLoader().getResource(filename);
            File file = new File(resource.getFile());
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else
                return false;
        } catch (IOException ioe) {
            System.out.println("Cannot open " + filename);
            return false;
        }*/

        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }

        return true;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }

    public static Graph readGrap(Class< ? extends Graph> graph,boolean directed, String filename)  {


        // 文件读取
        Scanner scanner = getScanner(filename);
        if (scanner == null)
            return null;

        String matedata = scanner.nextLine();
        String[] strs = matedata.split(" ");
        int n = Integer.parseInt(strs[0]);
        Graph g = null;
        try {
            g = graph.getDeclaredConstructor(int.class, boolean.class).newInstance(n, directed);
            while (scanner.hasNextLine()) {
                String edge = scanner.nextLine();
                String[] s = edge.split(" ");
                int v = Integer.parseInt(s[0]);
                int w = Integer.parseInt(s[1]);
                g.addEdge(v, w);
            }
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static WeightGraph readWeightGrap(Class< ? extends WeightGraph> graph, boolean directed, String filename)  {
        Scanner scanner = getScanner(filename);
        if (scanner == null) return null;
        String matedata = scanner.nextLine();
        String[] strs = matedata.split(" ");
        int n = Integer.parseInt(strs[0]);
        WeightGraph g = null;
        try {
            g = graph.getDeclaredConstructor(int.class, boolean.class).newInstance(n, directed);
            while (scanner.hasNextLine()) {
                String edge = scanner.nextLine();
                String[] s = edge.split(" ");
                int v = Integer.parseInt(s[0]);
                int w = Integer.parseInt(s[1]);
                double weight = Double.parseDouble(s[2]);
                g.addEdge(v, w, weight);
            }
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Scanner getScanner(String filename) {
        if (filename == null) {
            System.out.println("filename is null or words is null");
            return null;
        }

        // 文件读取
        Scanner scanner;

        try {
            URL resource = FileOperation.class.getClassLoader().getResource(filename);
            File file = new File(resource.getFile());
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else
                return null;
        } catch (IOException ioe) {
            System.out.println("Cannot open " + filename);
            return null;
        }
        return scanner;
    }


    @Test
    public void test() {
        System.out.println(Double.parseDouble(".21"));
    }
}
