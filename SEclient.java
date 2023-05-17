import java.io.*;
import java.net.*;
import java.util.*;

class SEclient
{
  public static void main(String[] args) throws Exception
  {
   InetAddress ip=InetAddress.getByName("Localhost");
Socket s=new Socket(ip,1039);
   BufferedInputStream din=new BufferedInputStream(s.getInputStream());
   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
   int p=din.read();
   System.out.println("No. of frames:"+ p);
   int arr[]=new int[p];
   for(int i=0;i<p;i++)
   {
   arr[i]=din.read();
   if(i!=3)
   System.out.println("Received :"+ arr[i]);
   }//end of for
   arr[3]=-1;
    for(int i=0;i<p;i++)
   {
   System.out.println( arr[i]);
   }
int n=3;
   dout.write(n);
   arr[n]=din.read();

   for(int i=0;i<p;i++)
   {
   System.out.println( arr[i]);
   }
   dout.close();
din.close();
s.close();
  }
}