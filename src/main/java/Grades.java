import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Grades {
    private List<Grade> grades;

    public Grades() {
        grades = new ArrayList<>();
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void readGrades(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNextLine()) {
            String name = scan.next().trim();
            double grade = scan.nextDouble();
            grades.add(new Grade(name, grade));
        }
    }

    public double calcAverage() {
        double total = 0.0;
        for (Grade grade : grades) {
            total += grade.getGrade();
        }
        return total / grades.size();
    }

    public double dropLowest() {
        Grade minGrade = new Grade("", Double.MAX_VALUE);
        for (Grade grade : grades) {
            if (grade.getGrade() < minGrade.getGrade()) {
                minGrade = grade;
            }
        }
        grades.remove(minGrade);
        return minGrade.getGrade();
    }

    public void addGrade(double grade) {
        grades.add(new Grade("", grade));
    }

    public boolean removeAllGrades(double gradeValue) {
        boolean removed = false;

        for (Grade grade : grades) {
            if (grade.getGrade() == gradeValue){
                grades.remove(grade);
                removed = true;
            }
        }
        return removed;
    }

    // Collections.sort sorts the input list as a side-effect, which I didn't prefer
    // So I created a copy and sorted that.
    // You could also just sort grades.
    public void printSortedGrades() {
        List<Grade> gradesCopy = new ArrayList<>(grades);
        Collections.sort(gradesCopy);

        System.out.println(gradesCopy);
    }

    public void printGradeBreakdown() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int f = 0;
        for (Grade grade: grades) {
            if (grade.getGrade() >= 90) {
                a++;
            } else if (grade.getGrade() >= 80) {
                b++;
            } else if (grade.getGrade() >= 70) {
                c++;
            } else if (grade.getGrade() >= 60) {
                d++;
            } else {
                f++;
            }
        }
        System.out.println("A: " + a + ", B: " + b + ", C: " + c + "D: " + d + ", F: " + f);
    }

    public String getStudentWithHighestGrade() {
        double highestGrade = Double.MIN_VALUE;
        String highestStudent = "";

        for (Grade grade: grades) {
            if (grade.getGrade() > highestGrade) {
                highestGrade = grade.getGrade();
                highestStudent = grade.getStudent();
            }
        }

        return highestStudent;
    }

    // Simplest version of toString() for this method
//    public String toString() {
//        return grades.toString();
//    }

    // Using StringBuilder rather than less efficient string concatentation
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < grades.size() - 1; i++) {
            result.append(grades.get(i));
            result.append(", ");
        }
        result.append(grades.get(grades.size() - 1));
        result.append("]");

        return result.toString();
    }

}

