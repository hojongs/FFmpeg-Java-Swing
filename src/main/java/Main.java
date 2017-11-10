import javax.swing.*;

public class Main
{
	public static void main(String[] args)
	{
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(() -> {
			//Create and set up the window.
			JFrame frame = new JFrame("JavaFFmpeg");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			JPanel panel = new MyJPanel(new Core( "JavaFFmpeg.conf"));
			frame.add(panel);

			//Display the window.
			frame.pack();
			frame.setVisible(true);
		});
	}
}
