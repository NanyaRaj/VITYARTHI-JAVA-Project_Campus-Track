package campustracker;

public class Student extends Person {

    private String course;
    private int semester;

    public Student(String name, int id, String course, int semester) {
        super(name, id);
        this.course = course;
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Course: " + course);
        System.out.println("Semester: " + semester);
    }
}