package task5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.ser";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveStudents();
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    private void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing student data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student student = new Student(name, rollNumber, grade, age);
                    sms.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollNumberToRemove = scanner.nextInt();
                    sms.removeStudent(rollNumberToRemove);
                    System.out.println("Student removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int rollNumberToSearch = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(rollNumberToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

