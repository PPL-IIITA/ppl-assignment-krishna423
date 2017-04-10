/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_file;

import java.io.*;
import java.util.*;

/**
 *
 * @author root
 */
public class Csv_generate {
    
    void boys_gen(int count){
        
        try{
            FileWriter boy_file = new FileWriter("boys_data.csv");
            String name,type="",status="single";
            int i,attractiveness,intelligence,req_attractivenes,budget,tp;
            Random rand =new Random();
            for(i=0;i<count;i++){
                attractiveness=rand.nextInt(10)+1;
                intelligence=rand.nextInt(10)+1;
                req_attractivenes=rand.nextInt(4)+1;
                budget =rand.nextInt(400)+99;
                tp=rand.nextInt(3);
                switch (tp) {
                case 0:
                    type = "Miser";
                    break;
                case 1:
                    type = "Geek";
                    break;
                case 2:
                    type = "Generous";
                    break;
                }
                int h=rand.nextInt(26);
                h=h%26;
             //   char ss[25]={a,b,c,d,e,f,g,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
                boy_file.write("B"+i+","+attractiveness+","+intelligence+","+req_attractivenes+","+budget+","+type+","+status+"\n");
            }
            boy_file.close();
        }
        catch(Exception e){}
       }
      
    void girls_gen(int count){
        try{
            FileWriter girl_file = new FileWriter("girls_data.csv");
            String name,type="",status="single";
            int i,attractiveness,intelligence,req_attractivenes,maintenancebudget,tp;
            Random rand =new Random();
            for(i=0;i<count;i++){
                attractiveness=rand.nextInt(10)+1;
                intelligence=rand.nextInt(10)+1;
                req_attractivenes=rand.nextInt(4)+1;
                maintenancebudget =rand.nextInt(800)+99;
                tp=rand.nextInt(3);
                switch (tp) {
                case 0:
                    type = "choosy";
                    break;
                case 1:
                    type = "normal";
                    break;
                case 2:
                    type = "Desperate";
                    break;
                }
                girl_file.write("G"+i+","+attractiveness+","+intelligence+","+req_attractivenes+","+maintenancebudget+","+type+","+status+"\n");
            }
            girl_file.close();
        }
        catch(Exception e){}
       }
 
    
}
    

