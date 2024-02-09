import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private int age;
    Grades grades;

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






Student(){

}

//public Student(String name,int age,Grades grades){
//    this.id=++id;
//    this.name=name;
//    this.age=age;
//    this.grades=grades;
//
//}

    public Student(int id,String name,int age){
    super();
    this.id=id;
        this.name=name;
        this.age=age;


    }


//boolean update(int id,String name,int age, int grades){
//
//
//}
public Student(int id,String name,int age,Grades grades){
    super();
    this.id=id;
    this.name=name;
    this.age=age;
    this.grades=grades;


}

public Student(Grades grades){

        this.grades=grades;
}

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public String toString(){
        return "[ Student id  "+ id + ",  name "+ name+ ",  age "+ age +" ]";
    }


    Student update(int id, String name, int age){
    this.id=id;
    this.name=name;
    this.age =age;
return this;

    }
}



class Grades{
    int physics;
    int chemistry;
    int maths;
    int total;
    int average;

Grades(){}

    public Grades(int physics,int chemistry,int maths){
        this.physics=physics;
        this.chemistry=chemistry;
        this.maths=maths;
        this.total= physics+chemistry+maths;
        this.average= total/3;
    }
    public void setGrades(int physics,int chemistry,int maths){
        this.physics=physics;
        this.chemistry=chemistry;
        this.maths=maths;
        this.total= physics+chemistry+maths;
        this.average= total/3;
    }

    public void getGrades(){
        int total = physics+chemistry+maths;
        int avg = (total/3);
        System.out.println("[ physics = "+physics+ ", Chemistry = "+chemistry +",Maths = "+maths+",Total Marks = "+total +",Average = "+ avg+"% ]");
    }

}