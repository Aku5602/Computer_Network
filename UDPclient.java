import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.*;

class UDPclient{

public static void main(String[] args) throws Exception { //No ip address needed

InetAddress ip=InetAddress.getLocalHost();
DatagramSocket s=new DatagramSocket(1026);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str1="",str2="";
byte[] sendData=new byte[1024];
byte[] receiveData=new byte[1024];


while(!str1.equals("Bye")) {

str1=br.readLine();
sendData=str1.getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,ip,1040);
s.send(sendPacket);

DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
s.receive(receivePacket);
str2=new String(receivePacket.getData());
System.out.println("Server says:"+str2);

}//end of while
s.close();

}//end of main
}//end of class