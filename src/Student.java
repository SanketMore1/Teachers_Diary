import java.util.*;

public class Student implements Comparator<Student> {

    private int id;
    private String name;
    private int age;
    private int standard;
    Grades grades;


    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getStandard(){
        return standard;
    }

    public void setStandard(int val){
        this.standard=val;
    }


    Student() {

    }
    public Student(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;


    }

    public Student(int id, String name, int age,int standard) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
       this.standard= standard;

    }

    public Student(int id, String name, int age,int standard, Grades grades) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
this.standard= standard;

    }

    public Student(Grades grades) {

        this.grades = grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public String toString() {
        return "[ Student id  " + id + ",  name " + name + ",  age " + age +" ]";
    }


    Student update(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        return this;

    }


}



