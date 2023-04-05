package org.example;

import dependency.DaoOperations;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       // System.out.println( "Hello World!" );
        String s=null;
       // System.out.println(s.length());
        Adreess adreess=null;
        System.out.println(adreess.street);
    }
    public Adreess getadress(){
        Adreess adreess=new Adreess();
    }
}
