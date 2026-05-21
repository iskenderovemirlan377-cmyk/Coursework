import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void sortByAverage() {
        students.sort(Comparator.comparingDouble(Student::calculateAverage).reversed());
    }

    public void showTopStudents() {
        sortByAverage();
        System.out.println("Top Students:");
        for (int i = 0; i < Math.min(3, students.size()); i++) {
            students.get(i).display();
        }
    }

    public double calculateOverallAverage() {
        double sum = 0;
        for (Student s : students) {
            sum += s.calculateAverage();
        }
        return students.size() == 0 ? 0 : sum / students.size();
    }

    // File Save
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.calculateAverage());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    // File Load
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(Integer.parseInt(data[0]), data[1]);
                students.add(s);
            }
        } catch (IOException e) {
            System.out.println("Error loading file");
        }
    }
}
