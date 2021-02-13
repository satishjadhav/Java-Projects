package com.concurrent.executer;

import java.util.*;
import java.text.*;
public class MyThread implements Runnable {
	
	private String myName;
	private int count;
	private final long timeSleep;
                static boolean CONTROLL=true;
                static Long pckNo1=10000L;
                static Long pckNo2=10000L;
	MyThread(String name, int newcount, long newtimeSleep) 
                {
	         this.myName = name;
	         this.count = newcount;
	         this.timeSleep = newtimeSleep;
	}
	
	@Override
	/*public void run() 
                {
		// TODO Auto-generated method stub

		int sum = 0;
                               for (int i = 1; i <= this.count; i++) {
                                          sum = sum + i;
                               }
	    System.out.println(myName + " thread has sum = " + sum + " and is going to sleep for " + timeSleep);
	    try {
			Thread.sleep(this.timeSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
               public void run()
               {
                     try
                     {
                     	while(CONTROLL)
                              {
                                    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                                    Calendar cal = Calendar.getInstance();
                                    System.out.println(dateFormat.format(cal.getTime()));
                                    String time=dateFormat.format(cal.getTime());
                                    

                                    if(myName.equals("Add1") || myName.equals("Add2"))
                                    {
                                          ExecutorServiceTest.map.put(pckNo1, Message.getInstance());
                                          
                                          System.out.println("=====>  Added "+pckNo1);
                                          pckNo1++;
                                    }
                                    else if(myName.equals("Del1") || myName.equals("Del2"))
                                    {
                                          //if(ExecutorServiceTest.map.containsKey(pckNo2))
                                          {
                                                ExecutorServiceTest.map.remove(pckNo2, Message.getInstance());
                                                 System.out.println("==============>Removed "+pckNo2);
                                                pckNo2++;
                                          }
                                    }
                                    else if(myName.equals("GC"))
                                    {
                                                System.gc();
                                                System.out.println("========>Call of GC");
                                    }
                                    if(time.equals("22:41:00"))//21:49:44
                                          CONTROLL=false;
                                    Thread.sleep(10);
                              }
                     }
                     catch (Exception e)
                     {
                           e.printStackTrace();
                     }
               }


}