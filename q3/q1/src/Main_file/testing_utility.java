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
import static jdk.nashorn.internal.objects.NativeMath.log;

/**
 *
 * @author root
 */
public class testing_utility {
    int b_count,g_count,size=0,x,y,temp=0;
    boys b[] = new boys[10000];
    girls g[] = new girls[10000];
    boys cpl_b[]=new boys[10000];
    girls cpl_g[]=new girls[10000];
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
                      int i,j,count=0,chk=0;
                    //  System.out.printf(x +""+ y);
                     for(i=0;i<y;i++){
                            for(j=0;j<x;j++){
                                if(g[i].maintenancebudget <= b[j].budget && b[j].attractiveness >= g[i].req_attractivenes && b[j].status.equals("single")){      
     //                               System.out.println(b[j].attractiveness +"  "+ g[i].attractiveness);
                                    cpl_b[temp]=b[j];
                                    cpl_b[temp].happiness=0;
                                    
                                    cpl_g[temp]=g[i];
                                    cpl_g[temp].happiness=0;
                                    temp++;
                                    b[j].status="assign_boyfriend";
                                    couple.assign_boy(count++,b[j].name,g[i].name);
                                    chk=count;
                                    break;
                                }
                            }
                        }
                       couple.assign_boy(99999, "a", "b");
                 
        //  gift_exchange();
        }
 
}         
     
