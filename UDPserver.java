import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.*;

class UDPserver{

public static void main(String[] args) throws Exception {


DatagramSocket ds=new DatagramSocket(1040);
InetAddress ra=InetAddress.getLocalHost();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str1="",str2="";
byte[] buffer1=new byte[1024];
byte[] buffer2=new byte[1024];


while(!str1.equals("Bye")) {


DatagramPacket Packet1 = new DatagramPacket(buffer2,buffer2.length);
ds.receive(Packet1);
str2=new String(Packet1.getData());
System.out.println("Client says:"+str2);

str1=br.readLine();
buffer1=str1.getBytes();
DatagramPacket Packet2 = new DatagramPacket(buffer1,buffer1.length,ra,1026);
ds.send(Packet2);

}//end of while
ds.close();



}//end of main


}//end of class