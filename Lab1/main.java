package com.mycompany.lab1_java;

public class main {
        
        public static boolean validate(String s)
        {
            try
            {
                Integer.parseInt(s);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Numarul nu este integer");
                return false;
            }
            return true;
        }
    
        public static void main(String[] args){
            /*
            String[] strArray = { "C", "C#", "C++", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java" };
            int n= (int) (Math.random() * 1_000_000);
            n*=3;
            n+=Integer.parseInt("10101",2);
            n+=Integer.parseInt("FF",16);
            System.out.println(Integer.parseInt("FF",16));
            n*=6;
            while(n>9)
            {
                int n1=0;
                while(n!=0){
                    n1+=n%10;
                    n/=10;
                }
                n=n1;
            }
            System.out.println(n);  
            System.out.print("Willy-nilly, this semester I will learn " + strArray[n]);
            */
            //pana aici tine compulsory
            /*
            long startTime = System.nanoTime();
            long finalTime;
            if(args.length==0)System.out.println("Nu ati introdus nicio valoare");
            else if(validate(args[0])==false);
            else if(Integer.parseInt(args[0])>=15)
            {
                graph graphObj= new graph(args[0]);
                finalTime = System.nanoTime();
                System.out.print(finalTime-startTime + " nanosecunde");

            }
            else 
            {
                graph graphObj= new graph(args[0]);
                System.out.println();
            }
            */
            //pana aici tine optional
            //random_tree tree= new random_tree(); //asta este partea de bonus
        }
}
