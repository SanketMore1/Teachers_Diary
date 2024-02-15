import java.util.*;
import java.util.concurrent.Callable;

public class Application {


    int id;
    String name;
    int operation;
    int search;
    int age;

    ArrayList<Student> record = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        Application app = new Application();




        try {

            do {
                app.getMsg();

                switch (app.operation) {

                    case 1:
                        app.add();
                        break;

                    case 2:
                        app.view_all();
                        // Print the list sorted by age

                        break;

                    case 3:
                        app.update();
                        break;

                    case 4:
                        app.delete();
                        break;


                    case 5:
                        app.sort();
                        break;

                    case 6:
                        app.search();
                        break;

                    case 7:
                        // app.display();
                        break;

                    case 8:
                        System.out.println("Thanks for using our application..");
                        System.exit(0);

                    case 9:
                        app.dump_data();
                        break;

                }


            } while (true);
        } catch (Exception e) {
            System.out.println("Invalid input");

        }


    }

    void add() {
        System.out.println("Please enter student ID");
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println(" Ignore below message and please enter input of integer type only");
            return;
        }

        for (Student stud : record) {

            if (stud.getId() == id) {
                System.out.println("Please enter different id");
                return;
            }
        }

        Student stu = new Student();
        stu.setId(id);

        System.out.println("Please enter student Name:");
        try {
            name = sc.next();
        } catch (Exception e) {
            System.out.println(" Ignore below message and please enter name in words  only");
        }

        System.out.println("Please enter student Age:");
        try {
            age = sc.nextInt();
        } catch (Exception e) {
            System.out.println(" Ignore below message and please enter name in words  only");
        }


        stu.setName(name);
        stu.setAge(age);

        int p, c, m;
        System.out.println("Do you want to fill student grades :");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Please enter student Physics Score");
            p = sc.nextInt();

            System.out.println("Please enter student Chemistry Score");
            c = sc.nextInt();

            System.out.println("Please enter student's Maths Score");

            m = sc.nextInt();


            Grades gd = new Grades(p, c, m);

            stu.setGrades(gd);


            record.add(stu);

            System.out.println("Student added successfully");
        } else if (choice == 2) {
            record.add(stu);
           // studentHashSet.add(stu);
            System.out.println("Student added successfully");
            //return;
        }
    }

    private void view_all() {

        int count = 0;
        for (Student stud : record) {
            if (record.contains(stud)) {

                System.out.println(stud);
                if (stud.grades != null) {
                    stud.grades.getGrades();
                }
                System.out.println("--------------------------------------------------------------------------------------");
            } else {
                count++;

            }
        }
        if (count == record.size()) {
            System.out.println("No Data available");
            System.out.println();

        }
    }


    void update() {

        if (record.isEmpty()) {
            System.out.println("No data available to update ");

            System.out.println("Enter data to get started ");
        } else {
            System.out.println("Enter your id for update ");
            try {
                id = sc.nextInt();
            } catch (Exception e) {
                System.out.println(" Ignore below message and please enter input of integer type only");
                return;
            }
            boolean state = false;

            state = false;
            if (record.size() == 0) {
                System.out.println("Record is empty");
                System.out.println();
                return;
            }


            for (Student stu : record) {
                if (stu.getId() == id) {

                    System.out.println("Please enter new name :");
                    name = sc.next();

                    System.out.println("Please enter new age :");
                    age = Integer.parseInt(sc.next());
                    Student student = new Student();
                    student.setName(name);

                    student.setAge(age);
                    student.setId(id);

                    record.remove(stu);
                    record.add(student);


                    System.out.println("Student updated as :" + student.toString());


                    state = true;
                    break;
                }
            }
            if (state == false) {
                System.out.println("No record with id :" + id);
                System.out.println();
            }
        }
    }


    void delete() {

        System.out.println("Enter the id of student you want to delete:");
        id = sc.nextInt();

        if (record.isEmpty()) {
            System.out.println("Data is not available.");
            //return;
        } else {
            boolean flag = false;
            for (Student stu : record) {

                if (stu.getId() == id) {

                    System.out.println("To confirm enter student id again :");
                    int confirm = sc.nextInt();
                    if (confirm == id) {
                        record.remove(stu);
                        System.out.println("Student with given id deleted Successfully ");
                        flag = true;
                    }
                }
            }
            if (!flag) {
                System.out.println("Data is not available for given id :");
               // return;
            }
        }
    }

    void sort() {



        System.out.println("To Sort the records enter adjacent number :");
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Age");
int ch = sc.nextInt();

if(ch==3) {
// by age
    System.out.println("Sorting by age");
    Comparator byAge = Comparator.comparingInt(Student::getAge);
    Collections.sort(record, byAge);

    for (Student stu : record
    ) {
        System.out.println(stu);
    }
}else if(ch==1) {
// by id
    System.out.println("Sorting by id");
    Comparator byId = Comparator.comparingInt(Student::getId);
    Collections.sort(record, byId);

    for (Student stu : record
    ) {
        System.out.println(stu);
    }
}
else if(ch==2) {
// by name
    System.out.println("Sorting by Name");
    Comparator byName = Comparator.comparing(Student::getName);
    Collections.sort(record, byName);

    for (Student stu : record
    ) {
        System.out.println(stu);
    }
}
    }

    void search() {

        Support_Search();

    }


    void dump_data() {
        Student st1 = new Student(1, "Sanket", 23);
        Student st2 = new Student(2, "Arjun", 18);
        Student st3 = new Student(3, "Ram", 23);
        Student st4 = new Student(4, "Krishna", 24);
        Student st5 = new Student(5, "Govind", 19);
        record.add(st1);
        record.add(st2);
        record.add(st4);
        record.add(st3);
        record.add(st5);
    }

    void Support_Search() {
        System.out.println("Search using :");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Age");
        int choice = sc.nextInt();
        ArrayList<Student> temp = new ArrayList<>();

        // searching using ID
        if (choice == 1) {
            boolean flag = true;
            System.out.println("Enter the ID to search :");
            int id = sc.nextInt();

            for (Student stu : record) {
                if (stu.getId() == id) {
                    System.out.println("Student found with given id as :");
                    System.out.println(stu.toString());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("No Student found with given id!");
            }
        }

        // searching using name

        else if (choice == 2) {
            System.out.println("Enter the Name to search :");
            String name = sc.next();
            boolean flag = true;
            for (Student stu : record) {
                if (stu.getName().equals(name)) {

                    temp.add(stu);

                    flag = false;

                }
            }
            System.out.println("Student found with given name as :");
            for (Student stud : temp
            ) {
                System.out.println(stud.toString());

            }
            if (flag) {
                System.out.println("No Student found with given name!");
            }
        } else if (choice == 3) {
            System.out.println("Enter the age to search :");
            int age = sc.nextInt();
            boolean flag = true;
            for (Student stu : record) {

                if (stu.getAge() == age) {
                    temp.add(stu);
//                System.out.println("Student found with given age as :");
//                System.out.println(stu.toString());
                    flag = false;

                }
            }
            System.out.println("Student found with given age as :");
            for (Student stud : temp
            ) {
                System.out.println(stud.toString());

            }

            if (flag) {
                System.out.println("No Student found with given age!");
            }
        }


    }

    void getMsg() {

        System.out.println("_________Student Management System________");

        System.out.println(" 1. Add Student ");

        System.out.println(" 2. View All Students ");

        System.out.println(" 3. Update Student ");

        System.out.println(" 4. Delete Student ");

        System.out.println(" 5. Sort Students ");

        System.out.println(" 6. Search Student ");

        System.out.println(" 7. Display Statistics ");

        System.out.println("8. Exit ");

        System.out.println("9. Dump Data ");

        System.out.println("Enter your choice: ");
        operation = sc.nextInt();
    }





}
