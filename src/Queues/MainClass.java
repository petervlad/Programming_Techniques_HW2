package Queues;

public class MainClass {

	
	/*
	public static Server selectServer(Server[] s)
	{
		int min = s[0].getNrClients();
		int idx = 0;
		for (int i=1; i<s.length; i++)
		{
			if (s[i].getNrClients()<min)
			{
				min=s[i].getNrClients();
				idx=i;
			}
		}
		return s[idx];
	}
	*/
	
	public static void main(String[] args)
	{	
		GUI gui = new GUI();
		
		/*
		Server []s = new Server [3];
		
		s[0]= new Server(111);
		s[1]= new Server(222);
		s[2]= new Server(333);
		
		for (Server x:s)
			x.start();
		
		int nrClients=5;	
		Client [] c = new Client[nrClients];
		for (int i=0; i<nrClients; i++)
		{
			try {
				Thread.sleep((long)(Math.random()*5*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c[i]=new Client(i,getTime(),(int)(Math.random()*10)+3);
			System.out.println(c[i]);
			Server best= selectServer(s);
			try {
				best.addClient(c[i]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
	}
}
