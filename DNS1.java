import java.net.*;
class DNS1 {
public static void main(String[] args) throws Exception {
    if(args.length<1) {
        
      System.err.println("Enter URL or IP address on command line");
      System.exit(-1);
    } 
InetAddress ip;

    if(Character.isDigit(args[0].charAt(0))){
      byte[] b=new byte[4];
      String[] s=args[0].split("[.]"); 
      for(int i=0;i<s.length;i++){
        b[i]=Integer.valueOf(s[i]).byteValue();
      }
       ip=InetAddress.getByAddress(b);
       System.out.println(ip.getHostName() +"/"+ ip.getHostAddress());
      }
    else{
         ip=InetAddress.getByName(args[0]);
         System.out.println(ip.getHostName() +"/"+ ip.getHostAddress());
     }
    

}//end of main

}//end of class