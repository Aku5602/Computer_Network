import java.io.*;
import java.net.*;
import java.util.*;

class GOserver
{
 public static void main(String args[]) throws Exception
 {
   InetAddress ip=InetAddress.getByName("Localhost");
   ServerSocket ss=new ServerSocket(1029);
   Socket s=ss.accept();
   BufferedInputStream din=new BufferedInputStream(s.getInputStream());
   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
   Scanner sc=new Scanner(System.in);
   int p=din.read(); //p has no. of frames
   int pc=din.read();
 int a;
   boolean f[]=new boolean[p];
   if(pc==0)
   { 
    for(int i=0;i<p;i++)
    {
      dout.write(i); //i is the frame sent
      System.out.println("Sent frame number : "+i);
      try
      {
       Thread.sleep(7000);
      }catch(Exception e){}
      a=din.read();
       System.out.println("Received Acknowledgement for frame number : "+i);
    } 
   }
   else
   {
    for(int i=0;i<p;i++)
    {
      if(i==2)
      {
        System.out.println("Sent frame number : "+i);
      }
      else
      {
       dout.write(i); //i is the frame sent
      System.out.println("Sent frame number : "+i);
      try
      {
       Thread.sleep(7000);
      }catch(Exception e){}
       a=din.read();
      if(a!=255)
      {
      f[i]=true;
       System.out.println("Received Acknowledgement for frame number : "+i);
       }//end of if
      }//end of inner else
    }//end of for

   for(int i=0;i<p;i++)
    {
     if(f[i]==false)
       {//
       dout.write(i); //i is the frame sent
      System.out.println("RESent frame number : "+i);
         try
          {
          Thread.sleep(7000);
          }catch(Exception e){}
         a=din.read();
         if(a!=255)
         {
         f[i]=true;
         System.out.println("Received Acknowledgement for frame number : "+i);
         }//end of inner if
        }//end of outer if

    }//end of for
   
   } //end of else
   dout.close();
   din.close();
   sc.close();
 }
}