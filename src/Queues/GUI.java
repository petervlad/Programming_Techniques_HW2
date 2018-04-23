package Queues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private int minIntervalTime;
	private int maxTimeInterval;
	private int minServiceTime;
	private int maxServiceTime;
	private int simInterval;
	private int nrOfQueues;
	JLabel lblNrOfQueues = new JLabel("Enter the number of queues: ");
    JTextField textNrOfQueues = new JTextField(5); 
	JLabel lblIntervalMin = new JLabel("Enter the minimum time between customers: ");
	JTextField textMinTimeInterval = new JTextField(5);
	JLabel lblIntervalMax = new JLabel("Enter the maximum time between customers: ");
	JTextField textMaxTimeInterval = new JTextField(5);
	JLabel lblServiceMin = new JLabel("Enter the minimum service time:");
	JTextField txtMinServiceTime = new JTextField(5);
	JLabel lblServiceMax = new JLabel("Enter the maximum service time:");
	JTextField txtMaxServiceTime = new JTextField(5);
	JLabel lblSimInterval = new JLabel("Enter the simulation interval: ");
	JTextField txtsimulationInterval = new JTextField(5);
	
	JTextArea txtQueues = new JTextArea(10,50);

	private Shop shop;

	public int getNrOfQueues(){
		return this.nrOfQueues;
	}
	
	public GUI() {
		JFrame frame = new JFrame("Queue");

		// exiting when closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(lblNrOfQueues);
		panel.add(textNrOfQueues);
		panel.add(lblIntervalMin);
		panel.add(textMinTimeInterval);
		panel.add(lblIntervalMax);
		panel.add(textMaxTimeInterval);
		panel.add(lblServiceMin);
		panel.add(txtMinServiceTime);
		panel.add(lblServiceMax);
		panel.add(txtMaxServiceTime);
		panel.add(lblSimInterval);
		panel.add(txtsimulationInterval);
		
		
		JButton simulationButton = new JButton("Start Simulation");
		simulationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				minIntervalTime = Integer.parseInt(textMinTimeInterval.getText());
				maxTimeInterval = Integer.parseInt(textMaxTimeInterval.getText());
				minServiceTime = Integer.parseInt(txtMinServiceTime.getText());
				maxServiceTime = Integer.parseInt(txtMaxServiceTime.getText());
				simInterval = Integer.parseInt(txtsimulationInterval.getText());
				nrOfQueues = Integer.parseInt(textNrOfQueues.getText());
			    shop = new Shop(nrOfQueues, simInterval, minIntervalTime, maxTimeInterval, minServiceTime, maxServiceTime, GUI.this);
				shop.start();
			}
		});
		
	
		
		panel.add(simulationButton);
		panel.add(txtQueues);
		frame.add(panel);
		frame.setSize(600, 500);
		frame.setVisible(true);
	}
	
	
	
	public void updateTxtQueues()
	{
		txtQueues.setText(shop.listQueue());
	}
	
}

/*
 * Minimum and maximum interval of arriving time between customers; - Minimum
 * and maximum service time; - Number of queues; - Simulation interval; - Other
 * information you may consider necessary;
 */
