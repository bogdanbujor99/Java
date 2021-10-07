package com.mycompany.lab1_java;
import java.util.Random;
import java.util.Vector;

public class random_tree {
    random_tree()
    {
        int k=1;
        Random random= new Random();
        while(random.nextInt(10)!=0)k++;
        int n=random.nextInt(k);
        Vector father = new Vector();
        for(int i=1;i<=n-1;i++)
            father.add(random.nextInt(i));//am gasit cine este tatal fiecaruia
        //trebuie sa caut daca fiecare nod mai are vreun fiu, adica daca se gaseste in father
        // caut daca exista in father cu functia contains
        String space="";
        for(int i=0;i<=n-1;i++)
        {
            if(father.contains(i))
            {
                System.out.println(space+"+node"+i);
                space+=" ";
            }
            else 
            {
                System.out.println(space+"-node"+i);
                if(space.length()>1)
                {
                    String aux=space.substring(0,space.length()-1);
                    space=aux;
                }
            }
        }
    }
}
