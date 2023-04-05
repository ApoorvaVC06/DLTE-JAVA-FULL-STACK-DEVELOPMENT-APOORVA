package bank;

public class ImplemetingHierachy extends parent{
    void run(){
        System.out.println("Inside child");
        super.run();
    }
    public static void main(String[] args) {
        ImplemetingHierachy obj=new ImplemetingHierachy();
            obj.run();

    }

}
class parent{
    void run(){
        System.out.println("inside parent class");
    }
}

//class child1 extends parent{
//      void run(){
//          System.out.println("inside child1");
//      }
//}