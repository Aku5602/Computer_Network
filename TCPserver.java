import java.io.*;
import java.net.*;
import java.util.*;

class TCPserver{

public static void main(String[] args) throws Exception {
  
Scanner sc=new Scanner(System.in);
  ServerSocket ss=new ServerSocket(1030);
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String str1=" ";
  String str2=" ";
while(!str2.equals("Bye")) {
 str1=din.readUTF();
 System.out.println("Client says:"+str1);
 str2=br.readLine();
 dout.writeUTF(str2);
}//end of while
dout.close();
din.close();
s.close();

}//end of main


}//end of class