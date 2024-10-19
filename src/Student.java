public class Student {

    String name,address;
    int reg_num;
    double cgpa;
    Student next;


   Student( String name, String address, int reg_num , double cgpa  ) {

       this.name = name;
       this.address = address;
       this. reg_num = reg_num;                 // parametrized constructor
       this.cgpa = cgpa;
       this.next = null;

   }

}
