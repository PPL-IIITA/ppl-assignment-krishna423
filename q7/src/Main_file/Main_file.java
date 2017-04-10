/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_file;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Main_file {
    public int boy_num,girl_num,gift_num;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main_file assign=new Main_file();
    //    Scanner scan=new Scanner(System.in);
    //    assign.boy_num=scan.nextInt();
    //    assign.girl_num =scan.nextInt();
    //    assign.gift_num=scan.nextInt();
        assign.boy_num=70;
        assign.girl_num=50;
        assign.gift_num=100;
        Csv_generate generate=new Csv_generate();
        generate.boys_gen(assign.boy_num);
        generate.girls_gen(assign.girl_num);
        generate.gift_gen(assign.gift_num);
        testing_utility test=new testing_utility();
        test.boys_read(assign.boy_num);
        test.girls_read(assign.girl_num);
         Scanner sc=new Scanner(System.in);
        System.out.println(" 1 for default    \n 2 for array    \n 3 for sortrd array \n 4 for hash table\n");
        int a=sc.nextInt();
        if(a==1){
            test.couple_read();  
        }
        else if(a==2){
            test.couple_read();
        }
        else if(a==3){
            test.couple_read();
            test.sort();
            
        }
        else if(a==4){
            test.couple_read();
            test.hasht();
            
        }
        else {
            System.exit(0);
                    
        }
       
               
    }
    
}
