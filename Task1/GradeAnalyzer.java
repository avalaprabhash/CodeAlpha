import java.util.Scanner;

public class GradeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        double[] grades = new double[numStudents];
       
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }
        
        double sum = 0;
        double highestGrade = Double.MIN_VALUE;
        double lowestGrade = Double.MAX_VALUE;

        for (double grade : grades) {
            sum += grade;
            highestGrade = Math.max(highestGrade, grade);
            lowestGrade = Math.min(lowestGrade, grade);
        }

        double averageGrade = sum / numStudents;
        
        System.out.println("\nAverage grade: " + averageGrade);
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);

        scanner.close();
    }
}