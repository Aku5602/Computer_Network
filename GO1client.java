import java.io.*;
import java.net.*;
import java.util.*;

class GO1client{
    public static void main(String args[]) throws Exception{
    Scanner sc=new Scanner(System.in);
    InetAddress ip=InetAddress.getByName("Localhost");    
    Socket s=new Socket(ip,1050);
    BufferedInputStream din=new BufferedInputStream(s.getInputStream());
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());

    System.out.println("Enter number of frames:");
    int c=sc.nextInt();
    dout.write(c);
    System.out.println("Enter choice:");
    int choice=sc.nextInt();
    dout.write(choice);
    int i=0,check=0;
    int val;
    if(choice==0)
    {
     for(int j=0;j<c;j++)
     {
      i=din.read();
       
       System.out.println("Received frame :"+i);
       dout.write(i);
       System.out.println("Sending ack for frame :"+i);
     }
     
    }
    else
    {
      for(int j=0;j<c;j++)
      {
        i=din.read();
        if(i==check)
        {
          System.out.println("Received frame :"+i);
          dout.write(i);
          System.out.println("Sending ack for frame :"+i);
          check++;
        }
        else{
            j--;
            
            System.out.println("Sending negative ack for frame :"+i);
            dout.write(-1);
         }
       }

    }

   
   dout.close();
   din.close();
   sc.close();


   }//end of main

}