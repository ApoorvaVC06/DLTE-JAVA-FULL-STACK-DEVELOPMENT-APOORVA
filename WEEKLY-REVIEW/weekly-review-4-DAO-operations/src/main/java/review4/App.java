package review4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Operations operations=new Operations();
//        Students students=new Students(116,"Razak",30,"razak@gmail.com");
//        Adresses adresses1=new Adresses(34,67,"Springstreet","BANglore",97,"current");
//        Adresses adresses2=new Adresses(37,67,"winterstreet","ooty",66,"permanent");
//        students.getMyaddress().add(adresses1);
//        students.getMyaddress().add(adresses2);
//        operations.insertDB(students);
//        System.out.println("working");
        System.out.println(operations.fetchStudentdetails());
        System.out.println(operations.fetchCurAddress(116));
    }
}
