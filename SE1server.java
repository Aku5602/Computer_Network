import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.*;

class SE1server{

   public static void main(String[] args) throws Exception{
   InetAddress ip=InetAddress.getByName("Localhost");
   ServerSocket ss=new ServerSocket(1050);
   Socket s=ss.accept();
   BufferedInputStream din=new BufferedInputStream(s.getInputStream());
   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
   
   int a[]={10,20,30,40,50,60,70,80,90};
   int p=a.length;
   int i;
   dout.write(p); //Sending no. of frames
   for(i=0;i<p;i++){
    dout.write(a[i]);
    System.out.println("Sending data packet :"+a[i]);
    }
  
    i=din.read();
    System.out.println("Received negative ack");
    dout.write(a[i]);
    System.out.println("Resending data packet :"+a[i]);
 din.close();
dout.close();
 ss.close(); 

}//end of main

}//end of class