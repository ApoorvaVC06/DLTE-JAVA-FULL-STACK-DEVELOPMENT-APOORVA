package banking;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GenericsImplementation {
    public static void main(String[] args) {
//        List<String> object=new ArrayList<>();
        Generics<String> object=new Generics<>();
        String[] store={"federal","yes","canara"};
//        object.setArray(new String[]{"federal","yes","canara"});
        object.Addobjects();
        System.out.println(store);
//        System.out.println(Arrays.toString(object.getArray()));
//        object.setArray(new String[]{"sbi","icici","canara","yes"});
//        object.Addobjects();

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Generics<T> {
    private T array;
    Scanner scanner = new Scanner(System.in);
    List list = new ArrayList<>();

    public void setArray(T[] array) {
        this.array = (T) array;
    }

    public T[] getArray() {
        return (T[]) array;
    }

    public void Addobjects() {
        //System.out.println(array.toString());
        Scanner scanner = new Scanner(System.in);
        Array[] S=new Array[3];
        System.out.println("Enter the String obj to be added");
        String s = (String) scanner.nextLine();
        list.add(s);
        System.out.println(list);
//        for (int index = 0; index <array.length; index++) {
//            if (array[index] instanceof String) {
//                System.out.println("the new string is");
//                array+=array;            }
//        Integer n = array.length;
//        array[n] = (T) s;

//        if(array[n+1] instanceof String){
//        System.out.println("Array along with added element:"+array.toString());}
//        }

//            else if(array[index] instanceof Double){
//                System.out.println("Enter the interest rates of loans ");
//                array[index]= (T)(Double) scanner.nextDouble();
//            }
//        }
//        array.toString();
        }
    }


//    public void FindandReplace() {
//       // Integer index=0;
//        System.out.println("Enter the element to be found");
//
//
//        for (Integer index = 0; index < array.length; index++) {
//            if(array[index].equals(scanner.next())){
////            array[index] = (T) scanner.toString();}}
//               array[index].
//            if (value.equals(array[index])) {
//                System.out.println("The entered element is at" + index);
//                System.out.println("Enter the element to be placed");
//                T newvalue = (T) scanner.next();
//
//                String updated = Arrays.toString(array);
//
//                //updated = newvalue.replace(value, newvalue);
////            value=(T)value.replace(newvalue);
//            } else
//                System.out.println("Entered element not found");
//        }
//    }}