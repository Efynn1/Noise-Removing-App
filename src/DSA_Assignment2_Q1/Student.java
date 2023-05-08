package DSA_Assignment2_Q1;

/**
 *
 * @author flynn
 */
public class Student <E extends Comparable> implements Comparable <Student> {
        public E key;
        public String name;
        public int mark;
        
        public Student(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }
        
        public int compareTo(Student student) {
            return key.compareTo(student.key);
        }
        
        public void setKey(E key) {
            this.key = key;
        }
        
        public String toString() {
            return "Name: " + name + " Mark: " + mark;
        }
    
}
