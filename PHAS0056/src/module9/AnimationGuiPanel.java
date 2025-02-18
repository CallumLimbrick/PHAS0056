package module9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Panel with start, stop and exit buttons for rotating square
animation.
 */
public class AnimationGuiPanel extends JPanel
implements ActionListener {
	private AnimationPanel animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	/** Create JPanel containing animation panel and buttons. */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(800,900));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		animPanel = new AnimationPanel(700,700,10.0);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		add(animPanel);
		add(buttonPanel);
	}
	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}
	/** Start animation */
	public void start() {animPanel.start();}
	/** Stop animation */
	public void stop() {animPanel.stop();}
	/**
	 * Rotating square animation with start, stop and exit buttons.
	 */

}