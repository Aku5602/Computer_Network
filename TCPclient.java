import java.io.*;
import java.net.*;
import java.util.*;

class TCPclient { //No ip address used

public static void main(String[] args) throws Exception {
  Scanner sc=new Scanner(System.in);
  Socket s=new Socket("localhost",1030);
   DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String str1=" ";
  String str2=" ";
while(!str1.equals("Bye")) {
str1=br.readLine();
dout.writeUTF(str1);
str2=din.readUTF();
System.out.println("Server says:"+str2);
}//end of while
dout.close();
din.close();
s.close();
}//end of main


}//end of class
