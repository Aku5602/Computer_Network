import java.io.*;
import java.net.*;
import java.util.*;

class GO1server{
     public static void main(String args[]) throws Exception{

    InetAddress ip=InetAddress.getByName("Localhost");    
    ServerSocket ss=new ServerSocket(1050);
    Socket s=ss.accept();
    BufferedInputStream din=new BufferedInputStream(s.getInputStream());
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    
    System.out.println("Connection established");

    int p=din.read();
    int pc=din.read();
    int ack;
    boolean f[]=new boolean[p];
    if(pc==0)
    {
    for(int i=0;i<p;i++){
    dout.write(i);
    System.out.println("Sending frame :"+i);
    try{Thread.sleep(2000);} catch(Exception e){}
    ack=din.read();
    System.out.println("Received ack for frame :"+i);
      }
    }//end of if
    else{
      for(int i=0;i<p;i++){
      if(i==2)
       System.out.println("Sending frame :"+i);
      else
      {
        dout.write(i);
        System.out.println("Sending frame :"+i);
       
       try{Thread.sleep(2000);} catch(Exception e){}
       ack=din.read();
      
       if(ack!=255)
       {
         f[i]=true;
         System.out.println("Received ack for frame :"+i);
       }
      }
      
     }//end of for
    }//end of else


   for(int i=0;i<p;i++)
   {
     if(f[i]==false)
     {
       dout.write(i);
        System.out.println("Resending frame :"+i);
        try{Thread.sleep(2000);} catch(Exception e){}
        ack=din.read();
       if(ack!=255)
       {
         f[i]=true;
         System.out.println("Received ack for frame :"+i);
       }
     }
   }

   dout.close();
   din.close();
   


   }//end of main
}