package Queues;
import java.util.ArrayList;

public class Shop extends Thread{

	private int minTimeInterval;
	private int maxTimeInterval;
	private int minServiceTime;
	private int maxServiceTime;
	private int simInterval;
	private int nrOfQueues;

	private ArrayList<Server> servers = new ArrayList<Server>();
	
	private long initialTime;
	
	private GUI gui;
	
	public long getTime()
	{
		return System.currentTimeMillis()/1000 - initialTime;
	}

	public Server selectServer()
	{
		int min = servers.get(0).getNrClients();
		int idx = 0;
		for (int i=1; i<servers.size(); i++)
		{
			if (servers.get(i).getNrClients()<min)
			{
				min=servers.get(i).getNrClients();
				idx=i;
			}
		}
		return servers.get(idx);
	}

	public Shop(int nrOfQueues, int simInterval, int minIntervalTime, int maxTimeInterval, int minServiceTime, int maxServiceTime, GUI gui){
		initialTime= System.currentTimeMillis()/1000;
		
		this.minTimeInterval = minIntervalTime;
		this.maxTimeInterval  = maxTimeInterval;
		this.minServiceTime = minServiceTime;
		this.maxServiceTime = maxServiceTime;
		this.simInterval = simInterval;
		this.nrOfQueues = nrOfQueues;
		
		this.gui=gui;
	}
	
	public String listQueue(){
		
		String string = new String("");
		
		for(int i = 0; i < this.nrOfQueues; i++){
			string = string + "Queue" + (i + 1) + " ";
			for (int j=0;j<servers.get(i).getNrClients();j++)
				string+="*";
			string+="\n";
		}
		
		return string;
	}
	
	public void run(){
		for(int i = 0 ; i < nrOfQueues; i++){
			Server s = new Server(i, this);
			s.start();
			servers.add(s);
		}


		long currTime;
		while ((currTime=getTime())<simInterval)
		{
			long maxWait = simInterval - currTime;
			if (maxWait<minTimeInterval)
				break;
			try {
				Thread.sleep(minTimeInterval+(long)(Math.random()*(Math.min(maxWait, maxTimeInterval)-minTimeInterval)*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Client c = new Client((int)(Math.random()*100),getTime(),(int)(minServiceTime+(maxServiceTime-minServiceTime)*Math.random()));
			Server best= selectServer();
			try {
				best.addClient(c);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
		}
	}
	
	public void updateTextGUI()
	{
		gui.updateTxtQueues();
	}
}