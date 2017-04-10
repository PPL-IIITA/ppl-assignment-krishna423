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
    gift gft[]=new gift[10000];
    girls cpl[]=new girls[10000];
    void boys_read(int num){
        int i=0;
        String check="";
	BufferedReader buffer = null;
		try{
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
                int j;
        boys tmp =new boys();
        for(i=0;i<y-1;i++){
            for(j=i+1;j<y;j++){
                if(b[i].attractiveness>b[j].attractiveness){
                    tmp=b[i];
                    b[i]=b[j];
                    b[j]=tmp;
                  }
            }
        }
        
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
        girls tmp =new girls();
        int i;
        for(i=0;i<y-1;i++){
            for(j=i+1;j<y;j++){
                if(g[i].maintenancebudget>g[j].maintenancebudget){
                    tmp=g[i];
                    g[i]=g[j];
                    g[j]=tmp;
                  }
            }
        }  
    }
        void couple_read(){
        //    System.out.println(b[0].attractiveness +"  "+ g[0].attractiveness);
                      logged couple=new logged();
                      int i=0,j=0,k=0,count=0,chk=0;
                      for(i=0;i<y/2;i++){
                          for(j=0;j<y;j++)
                          {
                              if(g[j].status.equals("single")){
                                  g[j].status="couple";
                                  cpl[count]=g[i];
                                  break;
                              }
                          }
                          for(k=0;k<x;k++){
                            if(g[j].maintenancebudget <= b[k].budget && b[k].attractiveness >= g[j].req_attractivenes && b[k].status.equals("single")){
                                  g[j].assign_boy=k;
                                  b[k].status="couple";
                                  couple.assign_boy(count++,b[k].name,g[j].name);
                                  break;
                           }
                          
                          }
                          for(j=0;j<x;j++)
                          {
                              if(b[j].status.equals("single")){
                                  b[j].status="couple";
                                  cpl[count]=g[i];
                                  break;
                              }
                          }
                          int tmp=0,att=0,t=0;
                          for(k=0;k<y;k++){
                            if(g[k].attractiveness>att && g[k].maintenancebudget <= b[j].budget && b[j].attractiveness >= g[k].req_attractivenes && g[k].status.equals("single")){
                                t=1;
                                tmp=k;
                                att=g[k].attractiveness;
                             }
                          }
                          if(t==1){
                                g[tmp].assign_boy=j;
                                g[tmp].status="couple";
                                couple.assign_boy(count++,b[j].name,g[tmp].name);
                          }
                         
                }
                couple.assign_boy(99999, "a", "b");
             //   System.out.println(count);
                cpl_num=count;
        }
        void gift_exchange()
        {
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
                    cpl[j].tot_happy=Math.abs(cpl[j].happiness+b[a].happiness);
                    if( cpl[j].tot_happy<0)
                        System.out.println( cpl[j].tot_happy);
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
        
    //    System.out.println("Enter happist couple num  k= ");
    //    Scanner sc=new Scanner(System.in);
     //   int kkk=sc.nextInt();
     //   if(kkk>cpl_num)
            //kkk=cpl_num;
            int kkk=8;
            try{
                FileWriter pair = new FileWriter("Happy_couple.csv");
                pair.write("happiness            compatibility"+"\n");
                for(j=0;j<kkk;j++){
                    pair.write(cpl[j].tot_happy + ",                " + cpl[j].tot_com + "\n");
                }
                pair.close();
            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }
        
            
         //   System.out.println(cpl_num);
    }
        
    
}         
     
