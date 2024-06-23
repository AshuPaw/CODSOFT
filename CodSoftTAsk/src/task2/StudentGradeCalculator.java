package task2;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static int calculateTotal(int[] marks) {
		int total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return total;
	}

	public static double calculateAveragePercentage(int total, int numSubjects) {
		return (double) total / numSubjects;
	}

	public static String calculateGrade(double averagePercentage) {
		if (averagePercentage >= 90) {
			return "A+";
		} else if (averagePercentage >= 80) {
			return "A";
		} else if (averagePercentage >= 70) {
			return "B";
		} else if (averagePercentage >= 60) {
			return "C";
		} else {
			return "F";
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of subjects: ");
		int numSubjects = sc.nextInt();
		int[] marks = new int[numSubjects];
		for (int i = 0; i < numSubjects; i++) {
			System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
			marks[i] = sc.nextInt();
		}

		int totalMarks = calculateTotal(marks);

		double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

		String grade = calculateGrade(averagePercentage);

		System.out.println("\t***Marksheet***\t");
		System.out.println("Total Marks \t: " + totalMarks);
		System.out.println("Percentage \t: " + averagePercentage + "%");
		System.out.println("Grade \t\t: " + grade);

	}

}
