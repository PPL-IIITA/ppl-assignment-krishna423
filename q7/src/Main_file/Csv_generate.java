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
    gift sort_gift[]=new gift[10000];
    void gift_gen(int count){
        try{
            FileWriter gift_file = new FileWriter("gift_data.csv");
            int i,tp;
            String type="";
            Random rand =new Random();
            for(i=0;i<count;i++){
                sort_gift[i]=new gift();
                sort_gift[i].value=rand.nextInt(8)+1;
                sort_gift[i].price=rand.nextInt(10)+1;
                tp=rand.nextInt(3);
                switch (tp) {
                case 0:
                    type = "Essential";
                    break;
                case 1:
                    type = "Luxury";
                    break;
                case 2:
                    type = "Utility";
                    break;
                }
                sort_gift[i].type=type;
               if(tp==1){
                    sort_gift[i].luxury_rating=rand.nextInt(10)+1;
                    sort_gift[i].difficulity_of_obtain=rand.nextInt(10)+1;
                }
                else if(tp==2){
                    sort_gift[i].utility_value=rand.nextInt(10);
                    int temp=rand.nextInt(2);
                    sort_gift[i].utility_class=(temp>0)?"GOOD":"average";
                }
            }
            gift_file.close();
        }
        catch(Exception e){}
        int i,j,k,l;
       gift tmp=new gift();
        for(i=0;i<count-1;i++){
            for(j=i+1;j<count;j++){
                if(sort_gift[i].price>sort_gift[j].price){
                    tmp=sort_gift[i];
                    sort_gift[i]=sort_gift[j];
                    sort_gift[j]=tmp;
                  }
            }
        }
    try{
        FileWriter gift_file = new FileWriter("gift_data.csv");
        for(l=0;l<count;l++)
        {
            if(sort_gift[l].type=="Luxury")
                gift_file.write(sort_gift[l].price+","+sort_gift[l].value+","+sort_gift[l].type+","+sort_gift[l].luxury_rating+","+sort_gift[l].difficulity_of_obtain+"\n");
        //        System.out.println(sort_gift[l].price+"  "+sort_gift[l].value+" "+ sort_gift[l].type+" "+sort_gift[l].luxury_rating+" "+sort_gift[l].difficulity_of_obtain);
           else if(sort_gift[l].type=="Utility")
                gift_file.write(sort_gift[l].price+","+sort_gift[l].value+","+sort_gift[l].type+","+sort_gift[l].utility_value+","+sort_gift[l].utility_class+"\n");
           else
                gift_file.write(sort_gift[l].price+","+sort_gift[l].value+","+sort_gift[l].type+"\n");
        //    System.out.println(sort_gift[l].price+"  "+sort_gift[l].value+" "+ sort_gift[l].type+" ");
        }
        gift_file.close();
    }
    catch(Exception e){}
    
    }
    
}
    

