import java.util.*;
import java.net.*;
import java.io.*;

class LinkState {

  public int distance[]=new int[10];
  public int cost[][]=new int [10][10];

  public void calc(int n,int s) {
   int flag[] = new int[n+1];
    int minpos=1,c,minimum;

    for(int i=1;i<=n;i++) {
      flag[i]=0;
      distance[i]=cost[s][i];
    }

  c=2;

    while(c<=n) {

    minimum=99;

      for(int i=1;i<=n;i++) {

        if(minimum>distance[i] && flag[i] != 1){
          minimum=distance[i];
          minpos=i;
        }

      }
    flag[minpos]=1;
    c++;
     for(int i=1;i<=n;i++) {
       
       if (( distance[minpos] + cost[minpos][i] ) < distance[i] && flag[i] != 1) {
          distance[i] = distance[minpos] + cost[minpos][i];
       }

     }

    }//end of while
  }//end of function
  
  public static void main(String[] args){
    int nodes,source;

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Number of Nodes \n");
    nodes = sc.nextInt();

    System.out.println("Enter the Source Vertex :\n");
    source=sc.nextInt();

    LinkState d=new LinkState();
    
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

}