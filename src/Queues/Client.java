package Queues;

public class Client {
	
	int clientId;
	long arrivalTime;
	long leavingTime;
	int timeNeeded;
	
	public Client(int clientId, long arrivalTime, int timeNeeded){
		this.clientId = clientId;
		this.timeNeeded  = timeNeeded;
		this.arrivalTime = arrivalTime;
	}
	
	public int getClinetId(){
		return clientId;
	}

	public long getArtivalTime(){
		return arrivalTime;
	}
	
	public long getLeavingTime(){
		return leavingTime;
	}
	
	public int getTimeNeeded()
	{
		return timeNeeded;
	}
	
	public void setLeavingTime(int leavingTime)
	{
		this.leavingTime = leavingTime;
	}
	
	
	public String toString(){
		return "Client "+clientId+" arrival time "+arrivalTime+" time needed "+timeNeeded;
	}
	
}
