import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.*;

class SE1client{

   public static void main(String[] args) throws Exception{
   InetAddress ip=InetAddress.getByName("Localhost");
   Socket s=new Socket(ip,1050);
   BufferedInputStream din=new BufferedInputStream(s.getInputStream());
   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    int c=din.read();
    System.out.println("no. of frames : "+c);
    int []v=new int[c];

for(int i=0;i<c;i++){
v[i]=din.read();
v[2]=-1;
 System.out.println("Received data packet is :"+v[i]);
  
}


for(int i=0;i<c;i++){
 if(v[i]==-1)
 {
 dout.write(i);
 System.out.println("Sending negative acknowledgement");
 v[i]=din.read();
  System.out.println("Received correct data packet :"+v[i]);
 }

}

 din.close();
dout.close();
 s.close();   

}//end of main

}//end of class