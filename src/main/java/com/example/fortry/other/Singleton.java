package com.example.fortry.other;

public class Singleton {
//    private static Singleton INSTANCE=new Singleton();
//
//    private Singleton(){System.out.println("Created!");}
//
//    public static Singleton getSingleton(){
//        return INSTANCE;
//    }

    private static Singleton instance;

    private Singleton(){System.out.println("go now!");}

    public static Singleton getSingleton(){
        if(instance==null)
            synchronized(Singleton.class){
            if(instance==null){
                instance=new Singleton();
            }

            }
        return instance;
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(
                    ()->{
                        Singleton s=Singleton.getSingleton();
                        System.out.println(Thread.currentThread().getName()+" : "+s);
                    }
            ).start();

        }
    }
}
