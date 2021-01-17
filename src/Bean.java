
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bean {

	private int x;
	private int y = 50;
	private int w;
	private int h;
	private Image image;

	public Bean() {

		loadImage();
	}

	private void loadImage() {

		ImageIcon ii = new ImageIcon("src/beans3.png");
		image = ii.getImage();

		w = image.getWidth(null);
		h = image.getHeight(null);
	}

	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public int getWidth() {

		return w;
	}

	public int getHeight() {

		return h;
	}

	public Image getImage() {

		return image;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.x = this.x - 450;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.x = 450;
		}

	}

}