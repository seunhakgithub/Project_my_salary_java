/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salary;

import java.util.Scanner;

/**
 *
 * @author Seun
 */
public class test {

    public static void main(String[] args) {
        double salary = 0;
         
        Scanner s = new Scanner(System.in);
        System.out.println("S+");
         System.out.println("S+");
        double total = 0;

        salary = s.nextDouble();
      
         total = salary++;
        System.out.println("Toal"+total);
       
    }

}
