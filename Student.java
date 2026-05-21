import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Integer> grades;

    public Student(int id, String name) {
        super(id, name);
        grades = new ArrayList<>();
    }

    public void addGrade(int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Grade must be between 0 and 100");
        }
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    @Override
    public void display() { // Polymorphism
        super.display();
        System.out.println("Average Grade: " + calculateAverage());
    }
}
