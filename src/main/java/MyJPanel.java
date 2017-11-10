import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Nov 10 14:36:32 KST 2017
 */



/**
 * @author Ho jong
 */
public class MyJPanel extends JPanel
{
	private Core core;

	public MyJPanel(Core core)
	{
		initComponents();

		String FFMPEG_LOCATION = core.FFMPEG_PATH;

		if(FFMPEG_LOCATION != null)
			txtFFmpegPath.setText(FFMPEG_LOCATION);

		this.core = core;
	}

	private void btnClickActionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnEncode)
			core.ffmpegEncode(txtFFmpegPath.getText(), txtInput.getText(), txtOutput.getText());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Ho jong
		lblFFmpegPath = new JLabel();
		txtFFmpegPath = new JTextField();
		lblInput = new JLabel();
		txtInput = new JTextField();
		lblOutput = new JLabel();
		txtOutput = new JTextField();
		btnEncode = new JButton();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new MigLayout(
			"fill,hidemode 3",
			// columns
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]",
			// rows
			"[]" +
			"[]" +
			"[]"));

		//---- lblFFmpegPath ----
		lblFFmpegPath.setText("FFmpeg Location");
		add(lblFFmpegPath, "cell 0 0,aligny top,grow 100 0");

		//---- txtFFmpegPath ----
		txtFFmpegPath.setText("here");
		txtFFmpegPath.setMinimumSize(new Dimension(120, 25));
		add(txtFFmpegPath, "cell 1 0 6 1,aligny top,grow 100 0");

		//---- lblInput ----
		lblInput.setText("Input");
		add(lblInput, "cell 0 1,aligny top,grow 100 0");

		//---- txtInput ----
		txtInput.setText("test.mp4");
		txtInput.setMinimumSize(new Dimension(120, 25));
		add(txtInput, "cell 1 1 2 1,aligny top,grow 100 0");

		//---- lblOutput ----
		lblOutput.setText("Output");
		add(lblOutput, "cell 4 1,aligny top,grow 100 0");

		//---- txtOutput ----
		txtOutput.setText("output.avi");
		txtOutput.setMinimumSize(new Dimension(120, 25));
		add(txtOutput, "cell 5 1 2 1,aligny top,grow 100 0");

		//---- btnEncode ----
		btnEncode.setText("encode");
		btnEncode.addActionListener(e -> btnClickActionPerformed(e));
		add(btnEncode, "cell 0 2 12 1,grow");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Ho jong
	private JLabel lblFFmpegPath;
	private JTextField txtFFmpegPath;
	private JLabel lblInput;
	private JTextField txtInput;
	private JLabel lblOutput;
	private JTextField txtOutput;
	private JButton btnEncode;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
