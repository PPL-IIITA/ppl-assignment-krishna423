/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeMath.log;

/**
 *
 * @author root
 */
public class testing_utility {
    int b_count,g_count,size=0,x,y,temp=0,cpl_num=0;
    boys b[] = new boys[10000];
    girls g[] = new girls[10000];
    boys cpl_b[]=new boys[10000];
    girls cpl_g[]=new girls[10000];
    girls cpl[]=new girls[10000];
    gift gft[]=new gift[10000];
    couple_ex coupled[]=new couple_ex[10000];
    void boys_read(int num){
    //void read_csv_file(int boy_num,int girl_num){
    //    boys b[] = new boys[boy_num+1];
        int i=0;
        String check="";
	BufferedReader buffer = null;
		try{
                   //     int i=0;
			buffer = new BufferedReader(new FileReader("boys_data.csv"));
			while((check = buffer.readLine() )!= null){
				String[] read_boy_csv = check.split(",");
				b[i] = new boys();
                                b[i].name = read_boy_csv[0];
				b[i].attractiveness = Integer.parseInt(read_boy_csv[1]);
                                b[i].intelligence = Integer.parseInt(read_boy_csv[2]);
				b[i].req_attractivenes = Integer.parseInt(read_boy_csv[3]);
				b[i].budget = Integer.parseInt(read_boy_csv[4]);
                                b[i].type=read_boy_csv[5];
				b[i].status = read_boy_csv[6];
				i++;
			}
                        x=i;
                }
                catch(Exception e){
                    
                }
    //  int l;
    //  for( l=0;l<10;l++)   
    //                System.out.println(b[l].attractiveness);
    //  System.out.println("a");
    }
        void girls_read(int num){        
    //    girls g[] = new girls[girl_num+1];
        String check_g="";
        int j=0;
	BufferedReader buffer_g = null;
		try{
                //        int j=0;
			buffer_g = new BufferedReader(new FileReader("girls_data.csv"));
			while((check_g = buffer_g.readLine() )!= null){
				String[] read_girl_csv = check_g.split(",");
				g[j] = new girls();
                                g[j].name = read_girl_csv[0];
				g[j].attractiveness = Integer.parseInt(read_girl_csv[1]);
                                g[j].intelligence = Integer.parseInt(read_girl_csv[2]);
				g[j].req_attractivenes = Integer.parseInt(read_girl_csv[3]);
				g[j].maintenancebudget = Integer.parseInt(read_girl_csv[4]);
                                g[j].type=read_girl_csv[5];
				g[j].status = read_girl_csv[6];
				j++;
			}
                        y=j;
                }
                catch(Exception e){
                    
                }
    }
        void couple_read(){
        //    System.out.println(b[0].attractiveness +"  "+ g[0].attractiveness);
                      logged couple=new logged();
                      int i,j,count=0,chk=0,k=0;
                      
                    //  System.out.printf(x +""+ y);
                     for(i=0;i<y;i++){
                         g[i].assign_boy=0;
                            for(j=0;j<x;j++){
                                if(g[i].maintenancebudget <= b[j].budget && b[j].attractiveness >= g[i].req_attractivenes && b[j].status.equals("single")){      
     //                               System.out.println(b[j].attractiveness +"  "+ g[i].attractiveness);
                                    cpl_b[temp]=b[j];
                                    cpl_b[temp].happiness=0;
                                    
                                    cpl_g[temp]=g[i];
                                    cpl_g[temp].happiness=0;
                                    temp++;
                                    b[j].status="assign_boyfriend";
                                    g[i].assign_boy=j;
                                    cpl[k++]=g[i];
                                    
                                    couple.assign_boy(count++,b[j].name,g[i].name);
                                    chk=count;
                                    break;
                                }
                            }
                        }
                     cpl_num=k;
                       couple.assign_boy(99999, "a", "b");
                 
          gift_exchange();
        }
        void gift_exchange()
        {
    //        int i;
    //        for(i=0;i<temp;i++)
    //                System.out.println(cpl_g[i].type+" "+cpl_g[i].happiness+" "+cpl_g[i].name+" "+cpl_g[i].intelligence);      
         int i=0,j=0,k;
         String check="";
         BufferedReader buffer = null;
		try{
                   //     int i=0;
			buffer = new BufferedReader(new FileReader("gift_data.csv"));
			while((check = buffer.readLine() )!= null){
				String[] read_gft_csv = check.split(",");
				gft[i] = new gift();
				gft[i].price = Integer.parseInt(read_gft_csv[0]);
                                gft[i].value = Integer.parseInt(read_gft_csv[1]);
				gft[i].type = read_gft_csv[2];
				i++;
			}
                        x=i-1;
                }
                catch(Exception e){
                    
                }
                for(j=0;j<cpl_num;j++){
                   // System.out.println("ss"+cpl[j].type);
                    int g_bgt=cpl[j].maintenancebudget,sum=0;
                    for(k=0;k<i;k++){
                        if(g_bgt-gft[k].price>=0)
                        {
                           
                            g_bgt=g_bgt-gft[k].price;
                            cpl[j].gift=k;
                            if(cpl[j].type.equals("choosy")){
                                sum=sum+gft[k].price;
                        //    System.out.println("c");
                            }
                            if(cpl[j].type.equals("Desperate")){
                                sum=sum+gft[k].price+gft[k].value;
                        //     System.out.println("d");
                            }
                            if(cpl[j].type.equals("normal")){
                                sum=sum+gft[k].price;
                        //     System.out.println("n");
                            }
                       }  
                    }
                //    System.out.println(sum);
                    if(cpl[j].type.equals("choosy")){
                                cpl[j].happiness=(int)Math.log((double)sum)%1000000;
                            }
                    if(cpl[j].type.equals("Desperate")){
                                cpl[j].happiness=sum%1000000;
                            }
                   if(cpl[j].type.equals("normal")){
                                cpl[j].happiness=(int)Math.exp((double)sum)%1000000;
                            }
                    int a=cpl[j].assign_boy;
                    if(b[a].type.equals("Miser")){
                        b[a].happiness=b[a].budget-cpl[j].maintenancebudget;
                    }
                    if(b[a].type.equals("Geek")){
                        b[a].happiness=cpl[j].intelligence;
                    }
                    if(b[a].type.equals("Generous")){
                        b[a].happiness=cpl[j].happiness;
                    }
                    cpl[j].tot_happy=cpl[j].happiness+b[a].happiness;
                    cpl[j].tot_com=Math.abs(cpl[j].intelligence-b[a].intelligence)+Math.abs(cpl[j].attractiveness-b[a].attractiveness);
                }
        
       girls tmp =new girls();
        for(i=0;i<cpl_num-1;i++){
            for(j=i+1;j<cpl_num;j++){
                if(cpl[i].tot_happy>cpl[j].tot_happy){
                    tmp=cpl[i];
                    cpl[i]=cpl[j];
                    cpl[j]=tmp;
                  }
            }
        }     
    //    System.out.println("Enter value of k---     who are most happist couple");
    //    Scanner sc=new Scanner(System.in);
    //    int kk=sc.nextInt();
    //    if(kk>cpl_num)
    //        kk=cpl_num;
    int kk=8;
   // System.out.println("let k=8");
            try{
                FileWriter pair = new FileWriter("Happy_couple.csv");
                pair.write("happiness            compatibility"+"\n");
                for(j=0;j<kk;j++){
                    pair.write(cpl[j].tot_happy + ",                " + cpl[j].tot_com + "\n");
                }
                pair.close();
            }
            catch(Exception ee)
            {}

        }  
        
}         
     
