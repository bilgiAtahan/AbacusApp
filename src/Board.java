import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private Timer timer;
	private Bean bean;
	private ArrayList<Bean> beans = new ArrayList<Bean>();
	private final int DELAY = 10;
	private int gap;
	JLabel jlabel;

	public Board() {

		initBoard();
	}

	private void initBoard() {

		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		setSize(500, 500);
		
		String jlabelHeaderText = "You can press right cursor for start";
		
		jlabel = new JLabel(jlabelHeaderText, JLabel.CENTER);
		jlabel.setPreferredSize(new Dimension(500, 300));
		jlabel.setFont(new Font("Arial", Font.BOLD, 20));
		jlabel.setForeground(new Color(255, 255, 255));

		add(jlabel);
		// add beans in the arraylist
		for (int i = 0; i < 10; i++) {
			bean = new Bean();
			beans.add(bean);
		}
		
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);

		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		gap = 20; // space of between beans
		
		//Line
		g2d.setStroke(new BasicStroke(5));
		g2d.draw(new Line2D.Double(15, 58, 680, 58));
		//Left vertical line
		g2d.setStroke(new BasicStroke(5));
		g2d.draw(new Line2D.Double(15, 50, 15, 66));
		//Left vertical line
		g2d.setStroke(new BasicStroke(5));
		g2d.draw(new Line2D.Double(680, 50, 680, 66));

		setForeground(Color.white.brighter());

		for (int i = 0; i < beans.size(); i++) {
			
			g2d.drawImage(beans.get(i).getImage(), beans.get(i).getX() + gap, beans.get(i).getY(), this);
			
			gap += 20;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		move();
	}

	private void move() {
		repaint();
	}

	private class TAdapter extends KeyAdapter {

		int indexOfbean = 9;
		int numberOflabel = 0;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_RIGHT) {
				// It has 10 elements and elements have index between -1 and 9
				// It can't allows press left
				if (indexOfbean != -1) {
					beans.get(indexOfbean).keyPressed(e);
					indexOfbean -= 1;
					numberOflabel += 1;
					countToprint(numberOflabel);
				}

			}

			if (key == KeyEvent.VK_LEFT) {
				// It has 10 elements and elements have index between -1 and 9
				// It can't allows press left
				if (indexOfbean != 9) {
					indexOfbean += 1;
					numberOflabel -= 1;
					beans.get(indexOfbean).keyPressed(e);
					countToprint(numberOflabel);
				}

			}
		}

		public void countToprint(int number) {
			// Set number on the Label
			switch (number) {
			case 1:
				jlabel.setText(number + " - " + "ONE");
				break;
			case 2:
				jlabel.setText(number + " - " + "TWO");
				break;
			case 3:
				jlabel.setText(number + " - " + "THREE");
				break;
			case 4:
				jlabel.setText(number + " - " + "FOUR");
				break;
			case 5:
				jlabel.setText(number + " - " + "FİVE");
				break;
			case 6:
				jlabel.setText(number + " - " + "SİX");
				break;
			case 7:
				jlabel.setText(number + " - " + "SEVEN");
				break;
			case 8:
				jlabel.setText(number + " - " + "EİGHT");
				break;
			case 9:
				jlabel.setText(number + " - " + "NİNE");
				break;
			case 10:
				jlabel.setText(number + " - " + "TEN");
				break;
			}
		}

	}
}
