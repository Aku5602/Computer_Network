import java.io.*;
import java.net.*;
import java.util.*;

class SEserver
{
  public static void main(String[] args) throws Exception
  {
   InetAddress ip=InetAddress.getByName("Localhost");
   ServerSocket ss=new ServerSocket(1039);
   Socket s=ss.accept();
   BufferedInputStream din=new BufferedInputStream(s.getInputStream());
   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
   int a[]={10,20,30,40,50,60,70,80};
   int p=a.length;
    dout.write(p);
   for(int i=0;i<p;i++)
   {
   dout.write(a[i]);
   }//end of for
    int k=din.read();
System.out.println("Resending frame no:"+k);
     dout.write(a[k]);
        dout.close();
      din.close();
     ss.close();
     }//end of main
}//end of class