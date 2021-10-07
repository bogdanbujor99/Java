package com.mycompany.lab1_java;
import java.util.Arrays;
import java.util.Vector;
import java.util.Random;

public class graph {
    int n;
    int m;
    int nr=0;
    int[][] matrix;
    boolean[] visited;
    graph(String s){
        n=Integer.parseInt(s);
        matrix= new int[n][n];
        visited=new boolean[n];
        for(int i=0;i<=n-1;i++)
                for(int j=0;j<=n-1;j++)
                    matrix[i][j]=0;
        Random random= new Random(); 
        m=random.nextInt(n*(n-1)/2+1);
        for(int k=1;k<=m;k++)
        {
            int i,j;
            boolean ok=true;
            while(ok==true)
            {
                i=random.nextInt(n);
                j=random.nextInt(n);
                ok=ExistEdge(i,j);
            }
        }
        if(n<15)
        {
            Arrays.fill(visited,false);
            DFS(0);
            if(conex()==true)
            {
                Arrays.fill(visited,false);
                DFStree(0);
            }
            else
            {
                Arrays.fill(visited,false);
                componenteconexe(1);
            }
            System.out.println();
            print();
        }
    }
    public boolean ExistEdge(int i ,int j)
    {
        if(matrix[i][j]==0 && i!=j ){
            NewEdge(i,j);
            return false;
        }
        else return true;
    }
    public void NewEdge(int i ,int j) //adauga o noua muchie
    {
        matrix[i][j]=1;
        matrix[j][i]=1;
    }
    public void DFS(int start) //parcurgere DFS
    {
        visited[start]=true;
        for(int i=0;i<=n-1;i++)
            if(matrix[start][i]==1 && visited[i]==false)
                DFS(i);
    }
    public void DFStree(int start) //este apelata pentru a gasi un arbore partial in caz ca graful este conex
    {
        visited[start]=true;
        for(int i=0;i<=n-1;i++)
            if(matrix[start][i]==1 && visited[i]==false)
            {
                System.out.print(start);
                System.out.print(i+ "\n");
                DFStree(i);
            }
    }
    public void DFSconexe(int start) //afiseaza componenta conexa cu nr i
    {
        visited[start]=true;
        System.out.print(start);
        for(int i=0;i<=n-1;i++)
            if(matrix[start][i]==1 && visited[i]==false)
                DFSconexe(i);
    }
    public void componenteconexe(int nr) //afiseaza componentele conexe cu ajutorul lui DFSconexe
    {
        
        for(int i=0;i<=n-1;i++)
            if(visited[i]==false)
            {
                System.out.print("\n");
                System.out.print("Componenta conexa cu numarul " + nr + ":");
                DFSconexe(i);
                nr++;
            }
    }
    public boolean conex() // verifica daca graful este conex
    {
        for(int i=0;i<=n-1;i++)
            if(visited[i]==false)return false;
        return true;
    }
    
    public void print() //afiseaza matricea de adiacenta 
    {
        for(int i=0;i<=n-1;i++){
            for(int j=0;j<=n-1;j++)
                System.out.print(matrix[i][j]);
                System.out.print("\n");
            }
    }
}
