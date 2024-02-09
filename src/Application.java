import sun.org.mozilla.javascript.internal.ast.SwitchCase;

import javax.sound.midi.SysexMessage;
import java.util.*;

public class Application {




    int id;
    String name;
    int operation;
    int search;
    int age;

    HashSet<Student> record = new HashSet<>();
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args){

       Application app = new Application();

       boolean state = true;

       try {

           do {
               app.getMsg();

               switch (app.operation) {

                   case 1:
                       app.add();
                       break;

                   case 2:
                       app.view_all();
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


//int choice=10;
//        while(choice!=0){
//        // Choice menu for user
//        System.out.println("_________Student Management System________");
//
//        System.out.println(" 1. Add Student ");
//
//        System.out.println(" 2. View All Students ");
//
//        System.out.println(" 3. Update Student ");
//
//        System.out.println(" 4. Delete Student ");
//
//        System.out.println(" 5. Sort Students ");
//
//        System.out.println(" 6. Search Student ");
//
//        System.out.println(" 7. Display Statistics ");
//
//        System.out.println("8. Exit ");
//
//        System.out.println("Enter your choice: ");
//
//   choice = sc.nextInt();
//
//


//
//        switch (choice){
//
//            case 1 :
//                System.out.println("Enter Student Name : ");
//                String name = sc.next();
//
//                System.out.println("Enter Student Age : ");
//                int age = sc.nextInt();
//
//                System.out.println("Enter grades : ");
//                int grades = sc.nextInt();
//
//                Student student = new Student(name,age,grades);
//                record.add(student);
//                System.out.println("Student added sucess!!");
//                break;
//
//            case 2:
//                System.out.println(" View All Students ");
//                while(iter.hasNext()){
//                    System.out.println(iter.next());
//                }
//                break;
//
//            case 3:
//                System.out.println("update success ");
//                break;
//
//            case 4:
//                System.out.println("delete success ");
//                break;
//
//            case 5:
//                System.out.println("sorted success ");
//                break;
//
//            case 6:
//                System.out.println("found/not success ");
//                break;
//
//            case 7:
//                System.out.println("here is stat success ");
//                break;
//
//            case 8:
//                System.out.println("Thanks for using our application");
//                System.exit(1);
//                break;
//
//        }
//


//            if(choice==1) {
//                System.out.println("Enter Student Name : ");
//                String name = sc.next();
//
//                System.out.println("Enter Student Age : ");
//                int age = sc.nextInt();
//
//
//
//                 student = new Student(name, age);
//                record.add(student);
//                System.out.println("Student added sucess!!");
//
//            }
//            else if(choice==2) {
//
//Iterator<Student> iter = record.iterator();
//                System.out.println(" View All Students ");
//                while (iter.hasNext()) {
//                     student = iter.next();
//                    System.out.println(student.toString());
//
//                }
//
//
//
//
//
//            }
//            else if(choice==3){
//                System.out.println("Enter the id of Student you want update");
//                int id = sc.nextInt();
//
//                if(record.contains(student.id==id)){
//
//                    System.out.println("Enter updated Student Name : ");
//                    String name = sc.next();
//
//                    System.out.println("Enter updated Student Age : ");
//                    int age = sc.nextInt();
//
//
//                    record.add(student.update(id,name,age));
//                }else{
//
//                    System.out.println("Student with given id not exists !");
//                }
//
//
//
//
//
//            }else if(choice==5){
//
//
//            }
//
//
//
//
//


           } while (state);
       }catch (Exception e){
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

int p,c,m;
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


     Grades gd = new Grades(p,c,m);

     stu.setGrades(gd);





            record.add(stu);
            System.out.println("Student added succesfully");
        }
    }

    private void view_all() {

        int count = 0;
        for (Student stud : record) {
            if (record.contains(stud)) {

                System.out.print(stud );

                stud.grades.getGrades();
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


    void update(){

        if(record.isEmpty()){
            System.out.println("No data available to update ");

            System.out.println("Enter data to get started ");
        }
        else{
            System.out.println("Enter your id for update ");
               try {
                   id = sc.nextInt();
               }catch(Exception e){
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



               for(Student stu : record){
                   if(stu.getId() == id){

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
//                       stu.setAge(age);
//                       stu.setName(name);

                       System.out.println("Student updated as :"+student.toString() );

//                       record.add(stu);
                       state = true;
                       break;
                   }
               }if(state==false){
                   System.out.println("No record with id :"+ id);
                   System.out.println();
            }
        }
    }


    void delete(){

        System.out.println("Enter the id of student you want to delete:");
        id = sc.nextInt();

        if(record.isEmpty()){
            System.out.println("Data is not available.");
            return;
        }
        else{boolean flag = false;
            for(Student stu : record){

                if(stu.getId()==id){

                    System.out.println("To confirm enter student id again :");
                    int confirm=sc.nextInt();
                    if(confirm==id){
                    record.remove(stu);
                    System.out.println("Student with given id deleted Successfully ");
                  flag=true;}
                }
            }
            if(!flag)
            {
                System.out.println("Data is not available for given id :");
                return;
            }
        }
    }

void sort(){

        // using iterator to print hashset
//    Iterator<Student> iter = record.iterator();
//    while (iter.hasNext()) {
//        System.out.println(iter.next()
//        );
//    }

    // coverting hashset to arraylist
    // Pass hashset to arraylist constructor
//    ArrayList<Student> flower_array
//            = new ArrayList<>(record);
//
//    // all elements from hashset are copied to arraylist
//
//    System.out.println(flower_array);


}

void search(){

       Support_Search();

}





void dump_data(){
        Student st1 = new Student(1,"Sanket",23);
    Student st2 = new Student(2,"Arjun",18);
    Student st3 = new Student(3,"Ram",23);
    Student st4 = new Student(4,"Krishna",24);
    Student st5 = new Student(5,"Govind",19);
    record.add(st1); record.add(st2); record.add(st4); record.add(st3);
    record.add(st5);
}

void Support_Search(){
    System.out.println("Search using :");
        System.out.println("1. ID");
    System.out.println("2. Name");
    System.out.println("3. Age");
    int choice=sc.nextInt();
    ArrayList<Student> temp = new ArrayList<>();

    // searching using ID
    if(choice==1){
        boolean flag =true;
        System.out.println("Enter the ID to search :");
        int id = sc.nextInt();

        for(Student stu: record){
            if(stu.getId()==id){
                System.out.println("Student found with given id as :");
                System.out.println(stu.toString());
               flag= false;
                break;
            }
        }
        if(flag){
   System.out.println("No Student found with given id!");}
    }

    // searching using name

    else if(choice==2){
        System.out.println("Enter the Name to search :");
        String name = sc.next();
        boolean flag= true;
        for(Student stu: record){
            if(stu.getName().equals(name)){

                temp.add(stu);

                flag= false;

            }
        }
        System.out.println("Student found with given name as :");
        for (Student stud:temp
             ) {
            System.out.println(stud.toString());

        }
        if(flag){
            System.out.println("No Student found with given name!");}
    }




    else if(choice==3){
        System.out.println("Enter the age to search :");
        int age = sc.nextInt();
        boolean flag= true;
        for(Student stu: record){

            if(stu.getAge()==age){
                temp.add(stu);
//                System.out.println("Student found with given age as :");
//                System.out.println(stu.toString());
                flag= false;

            }
        }
        System.out.println("Student found with given age as :");
        for (Student stud:temp
             ) {
            System.out.println(stud.toString());

        }

        if(flag){
            System.out.println("No Student found with given age!");}
    }






}

//
//void Support_grades(){
//        System.out.println("Do you want to fill student grades :");
//    System.out.println("1. Yes");System.out.println("2. No");
//
//    int choice =sc.nextInt();
//    if(choice==1){
//        System.out.println("Please enter student Physics Score");
//        int p= sc.nextInt();
//
//        System.out.println("Please enter student Chemistry Score");
//        int c= sc.nextInt();
//
//        System.out.println("Please enter student's Maths Score");
//        int m= sc.nextInt();
//
//        Grades gd = new Grades();
//        gd.setGrades(p,c,m);
//
//
//
//    }
//
//
//
//
//    }



    void getMsg(){

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
