import java.util.*;

class Link1{
  int distance[]=new int[10];
  int cost[][]=new int[10][10];
  
public void calc(int n,int s) {
   int minimum,minpos=1;
   int flag[]=new int[n+1];
   int c=0;

   for(int i=1;i<=n;i++){ flag[i]=0; distance[i]=cost[s][i];}
c=2;
while(c<=n){
minimum=99;
   for(int i=1;i<=n;i++) {
        if(minimum>distance[i]) {
          minimum=distance[i];
          minpos=i;
        }
    }
   c++;
   flag[minpos]=1;
    
   for(int i=1;i<=n;i++) {

      if((distance[minpos]+cost[minpos][i])<distance[i] && flag[i]!=1)
      {
       distance[i]=distance[minpos]+cost[minpos][i];
      }
    }

 }
}

public static void main(String args[]) {


   int source,nodes;
  

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Number of Nodes \n");
    nodes = sc.nextInt();

    System.out.println("Enter the Source Vertex :\n");
    source=sc.nextInt();

    Link1 d=new Link1();
    
    for(int i=1;i<=nodes;i++)
      {
            for(int j=1;j<=nodes;j++)
       {
              d.cost[i][j]=sc.nextInt();
              
               if(d.cost[i][j]==0)
               d.cost[i][j]=999;

       }

     }

    d.calc(nodes,source);
    System.out.println("Source : "+source);
    for(int i=1;i<=nodes;i++) {
      if ( i != source ) {
      System.out.println("Destination : " + i + "Minimum Distance : " + d.distance[i]);
      }
    }


}

}//end of class