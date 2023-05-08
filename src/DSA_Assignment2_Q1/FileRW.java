package DSA_Assignment2_Q1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author flynn
 */
public class FileRW {

    /**
     * @return the all
     */
    private String all;
    public String name;
    public String[] lineData;
    public int lineNumber;
    StringBuilder sb = new StringBuilder();

    BinaryTree<Student> tree = new BinaryTree();

    public StringBuilder getAll() {
        System.out.println(all);
        return sb;
    }

    public FileRW() {
        lineData = new String[1000];
    }

    public void readFile(String fileName) {
        File f = new File(fileName);
        try {
            Scanner myScanner = new Scanner(f);
            lineNumber = 0;
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                
//                lineData[lineNumber] = line;
//                sb.append(line);
//                System.out.println(sb);
//                all = sb.toString();

                String[] tokens = myScanner.nextLine().split(", ");
                int mark = Integer.parseInt(tokens[1]);
                String name = tokens[0];
                Student student = new Student(name, mark);
                student.setKey(name);
                tree.add(student);
                lineNumber++;
            }
            myScanner.close();
        } catch (IOException e) {
            System.out.println("Cannot read the file " + e.getMessage());
        }
    }

    //System.getProperty("line.separator");
    public void writeFile(String fileName, String c) {
        File f = new File(fileName);

        try {
            f.createNewFile();
            FileWriter writer = new FileWriter(f);
            writer.write(c);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot write to the file" + e.getMessage());
        }
    }
}
