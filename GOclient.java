import java.io.*;
import java.net.*;
import java.util.*;

class GOclient
{
 public static void main(String args[]) throws Exception
 {
InetAddress ip=InetAddress.getByName("localhost");
Socket s=new Socket(ip,1029);
BufferedInputStream din=new BufferedInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of frames to be requested from Server: ");
int c=sc.nextInt();
dout.write(c);
System.out.println("Enter choice : 0] Without Error 1] With Error");
int choice=sc.nextInt();
dout.write(choice);
int check=0;
int i=0; //i for receiving frames and sending acknowledgement
  if(choice==0)
  {                          
    for(int j=0;j<c;j++)
    {
     i=din.read();
      System.out.println("Received frame number : "+i);
     dout.write(i);
    }
  
  }
  else
  {
    for(int j=0;j<c;j++)
    {
     i=din.read();
    if(check==i)
    {
     System.out.println("Received frame number : "+i);
     dout.write(i);
     check++;
    }
    else
    { 
     j--;
    System.out.println("Sending -ve acknowledgement: ");
    dout.write(-1);
    }

    }

  }
  dout.close();
   din.close();
   sc.close();

 }
}