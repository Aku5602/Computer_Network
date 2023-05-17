import java.net.*;
public class dns{
     public static void main(String args[]) throws Exception{
InetAddress ip;
       if(args.length!=1) //Check if user entered some input;if not then this code will be executed
         {
             System.err.println("Enter URL or IP address");
             System.exit(-1);
         } 
         if(Character.isDigit(args[0].charAt(0)))    
          {
              byte[] b=new byte[4];
              String[] s=args[0].split("[.]");
              for(int i=0;i<s.length;i++)
             {
             b[i]=Integer.valueOf(s[i]).byteValue();
             }
            ip=InetAddress.getByAddress(b);
            System.out.println(ip.getHostName()+" "+ip.getHostAddress());
          }    

         else //if URL is given
         {ip=InetAddress.getByName(args[0]);
            System.out.println(ip.getHostName()+" "+ip.getHostAddress());
         }
     }//end of main
}//end of class
/*import java.net.*;
public class dns
{
public static void main(String args[])
{
if(args.length!=1)
{
System.err.println("Enter Command line argument as a Internet Address or URL");
System.exit(-1);
}
InetAddress inetAddress;
try
{
if(Character.isDigit(args[0].charAt(0)))
{
byte[] b=new byte[4];
String[] bytes=args[0].split("[.]");
for(int i=0;i<bytes.length;i++)
{
b[i]=Integer.valueOf(bytes[i]).byteValue();
}
inetAddress=InetAddress.getByAddress(b);
}
else
inetAddress=InetAddress.getByName(args[0]);
System.out.println(inetAddress.getHostName()+'/'+inetAddress.getHostAddress());
}
catch(UnknownHostException exception)
{
System.err.println("ERROR: No Internet Address for"+args[0]+"");
}
}
}*/


