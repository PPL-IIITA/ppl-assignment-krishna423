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
        test.couple_read();
        test.gift_exchange();
    }
    
}
