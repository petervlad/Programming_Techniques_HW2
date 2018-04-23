package Queues;
import java.util.Vector;

public class Server extends Thread{

	private int serverId;
	private Vector<Client> clients = new Vector();
	
	private Shop shop;
	
	public Server(int id, Shop s)
	{
		serverId=id;
		shop =s;
	}
	
	public void setId(int id){
		this.serverId = id;
	}
	
	public int getServerId(){
		return serverId;
	}
	
	public void run(){
		try{
			while(true){
				delClient();
			}
		}
		catch(Exception e){
			
		}
	}
	
	
	
	public synchronized void addClient(Client client) throws InterruptedException 
	{
		clients.addElement(client);
		System.out.println("SERVER "+serverId+ " : Client queued! Time "+ shop.getTime() +" -> "+client);		
		shop.updateTextGUI();
		notify();
	}
	
	

	public synchronized void delClient() throws InterruptedException
	{
		if(clients.size() == 0)
		{
			wait();
		}
		
		Client c = (Client)clients.elementAt(0);
		sleep(c.getTimeNeeded()*1000);
		System.out.println("SERVER "+serverId+ " : Client served! Time "+ shop.getTime() +" -> "+c);
		clients.remove(0);
		
		shop.updateTextGUI();
		
		
		//String outString = Integer.toString(this.c.getClientId() + this.c.getClientArrivalTime() + this.c.getLeavingTime());
	}
	
	public int getNrClients()
	{
		return clients.size();
	}
	
}
