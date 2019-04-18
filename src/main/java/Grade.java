public class Grade implements Comparable<Grade> {
    private String student;
    private double grade;

    Grade(String student, double grade) {
        this.student = student;
        this.grade = grade;
    }

    public String toLetterGrade() {
        if (this.grade >= 90) {
            return "A";
        } else if (this.grade >= 80) {
            return "B";
        } else if (this.grade >= 70) {
            return "C";
        } else if (this.grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getStudent() {
        return this.student;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return this.student + ": " + this.grade;
    }

    @Override
    public int compareTo(Grade other) {
        return Double.compare(this.getGrade(), other.getGrade());
    }

}
