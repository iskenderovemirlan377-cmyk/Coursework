import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Top Students");
            System.out.println("5. Save");
            System.out.println("6. Load");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    Student s = new Student(id, name);

                    System.out.print("Enter grade: ");
                    int grade = sc.nextInt();

                    try {
                        s.addGrade(grade);
                        manager.addStudent(s);
                    } catch (InvalidGradeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    Student found = manager.searchById(searchId);
                    if (found != null) found.display();
                    else System.out.println("Not found");
                    break;

                case 4:
                    manager.showTopStudents();
                    break;

                case 5:
                    manager.saveToFile();
                    break;

                case 6:
                    manager.loadFromFile();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}
