public class Circular_LinkList {

    Student first;
    Student last;

    Circular_LinkList(){
        this.first = null;
        this.last = null;
    }

    public boolean isempty(){

        if(first == null){
            return true;
        }
        else {
            return false;
        }
    }

    //INSERTING NODE AT FIRST

    public void AddNode(String name , String address , int reg_num , double cgpa){

        Student newNode = new Student(name, address , reg_num , cgpa);

        newNode.name = name;
        newNode.address = address;
        newNode.reg_num = reg_num;
        newNode.cgpa = cgpa;

        if(isempty()){
            first = newNode;
            last = newNode;
            last.next = first;

        }
        else{
            newNode.next = first;
            first = newNode;
            last.next = first;
        }

    }

    //INSERTING AT THE END

    public void Add_last(String name , String address , int reg_num , double cgpa){

        Student newNode = new Student(name,address,reg_num,cgpa);
        newNode.name = name;
        newNode.address =address;
        newNode.reg_num = reg_num;
        newNode.cgpa = cgpa;

        if(isempty()){

            first = newNode;
            last = newNode;
            last.next = first;
        }
        else {

            Student current = first;

            while(current != last){
                current = current.next;
            }
            last.next = newNode;
            last = newNode;
            last.next = first;

        }

    }


    // INSERTING AT THE MIDDLE

    public void Add_middle(String name, String address , int reg_num , double cgpa ,int position ){

        Student newNode = new Student(name,address,reg_num,cgpa);

        if (position <= 0){
            System.out.println("InValid Position.");
        }


        if(isempty()){

            first = newNode;
            last = newNode;
            last.next = first;

        }

        else {
            int count = 1 ;
            Student current = first;

            while (current != first && count < position-1){

                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        System.out.println("\nUPDATED SUCCESSFULLY. New List is:\n");


    }

    // DElETE DATA FROM LIST
        public void Delete (int reg_num){


            if(isempty()){
                System.out.println("LiST IS EMPTY!");
            }
            boolean found = false;
            Student current = first;
            while (true){
                if(current.next.reg_num == reg_num){
                    current.next= current.next.next;
                    found = true;
                    break;

                }
                current = current.next;
                if(current == first){
                    break;
                }
            }


            if(found){

                System.out.println("\nData Deleted Successfully:");
                Print();
            }

            else {

                System.out.println("\nData Not found");
            }


        }



        // DELETE FROM START


    public void Delete_Start(){

        if(isempty()){

            System.out.println("List is Empty.");
        }

        Student current = first;
        first = first.next;
        last.next = first;

    }


    // DELETE FROM END

    public void Delete_end(){

        if(isempty()){

            System.out.println("List is empty.");

        }

        Student current = first;

        while(current.next.next!=first){

            current = current.next;
        }

        current.next= first;

    }


    //REVERSE

    public void reverse() {
        if (isempty()) {
            return; // List is empty, nothing to reverse
        }

        Student prev = null;
        Student current = first;
        Student next = first.next; // Start from the second node

        do {
            current.next = prev; // Reverse the link
            prev = current;      // Move prev to current
            current = next;      // Move current to next
            next = (next != first) ? next.next : first; // Update next
        } while (current != first);

        first.next = prev; // Connect the last node back to the new head
        first = prev; // Update head to the new first node
    }


        //SEARCHING NODE

    public void Search( int reg_num ){

        if(isempty()){
            System.out.println("List is Empty:");
        }


        boolean found = false;
        int pos = 1;
        Student current = first;

        while (current.next!= first){
            if(current.reg_num == reg_num ){
                found = true;
                break;
            }
            current = current.next;
            pos++;

        }

        if(found){
            System.out.println("\n Student Data is present at Index: "+ (pos-1));

        }

        else{

            System.out.println(" Student Data Not Found.");
        }

    }




// MAXIMUM NUMBER
     public void MAX (){

        if(isempty()){

            System.out.println("List is Empty.");
        }

         Student current = first;
        int max = first.reg_num;
        while(current.next!=first){
            if(current.reg_num>max);
            max = current.reg_num;
            current = current.next;
        }
         System.out.println("The Maximum Reg number is:" + max);


     }

// MINIMUM NUMBER

    public void Min(){

        if(isempty()){
            System.out.println("List is Empty.");
        }

        int min = first.reg_num;
        Student current = first;
        while (current.next!=first){
            if(current.reg_num < min){
                min = current.reg_num;
            }
            current = current.next;
        }

        System.out.println("The Minimum Reg Number is:"+min);

    }




    //DISPLAYING DATA
    public void Print(){

        if(first == null){
            System.out.println("List is Empty");
        }

        Student current = first;
        while (true){

            System.out.println("{Name:"+current.name+
                     " ID:"+current.reg_num +
                    " Address:"+current.address +
                    " CGPA:"+current.cgpa +"}");
            current = current.next;

            if(current == first){
                break;

            }
        }
    }


}
