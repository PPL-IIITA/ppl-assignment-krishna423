/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_file;

import java.io.FileWriter;

/**
 *
 * @author root
 */
public class logged {
    int x=-1;
    String str1[]=new String[10000];
    String str2[]=new String[10000];
    
    void assign_boy(int i,String sa,String sb)
    { 
//        String str1[]=new String[10];
 //       String str2[]=new String[10];
        String s="is boyfriend of";
        if(i!=99999){
            str1[i]=sa;
            str2[i]=sb;
            x=i;
  //           System.out.println(i);
  //      System.out.println(str1[i]+ ""+str2[i]);
        }
        else{
            try{
                int j=0;
                
                FileWriter pair = new FileWriter("couple.csv");
                for(j=0;j<=x;j++){
                    pair.write(str1[j] + "," +s +","+ str2[j] +"\n");
                }
                pair.close();
            }
            catch(Exception e)
            {}
            
        }
       
    }
}

    

