package tilltactoe;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javaCode.ISpielbrett;

import javax.swing.JPanel;

import scalaCode.Spielbrett;
import scalaCode.Spieler;

public class UIField extends JPanel {

	private int offset = 15;
	private final int zeilennummer;
	private final int spaltennummer;
	private ISpielbrett spielbrett;
	private BasicStroke smallStroke = new BasicStroke(2);
	private BasicStroke bigStroke = new BasicStroke(3);
	private boolean gameOver = false;

	public UIField(ISpielbrett spielbrett, int zeilennummer, int spaltennummer) {
		super();
		this.spielbrett = spielbrett;
		this.zeilennummer = zeilennummer;
		this.spaltennummer = spaltennummer;
		initialize();
	}

	private void initialize() {
		this.setPreferredSize(new Dimension(100, 100));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (!gameOver) {
					spielbrett.naechsterZugAufFeld(zeilennummer, spaltennummer);
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).setStroke(smallStroke);
		g.drawRect(0, 0, getWidth(), getWidth());
		paintSymbol(false);
	}

	private void paintSymbol(boolean slow) {
		if (getSpieler().istKreis()) {
			drawCircle(slow);
			return;
		}
		if (getSpieler().istKreuz()) {
			drawCross(slow);
			return;
		}
	}

	private void drawCross(boolean slow) {
		int width = getWidth();
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		graphics.setStroke(bigStroke);
		int length = width - offset;
		if (!slow) {
			graphics.drawLine(offset, offset, length, length);
			graphics.drawLine(length, offset, offset, length);
		} else {
			for (int i = offset; i < length; i++) {
				graphics.drawLine(offset, offset, i, i);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = offset; i < length; i++) {
				graphics.drawLine(length, offset, width - i, i);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void drawCircle(boolean slow) {
		int width = getWidth();
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		graphics.setStroke(bigStroke);
		if (!slow) {
			graphics.drawArc(offset, offset, width - 2 * offset - 2, width - 2
					* offset - 2, 90, 360);
		} else {
			for (int i = 0; i < 361; i++) {
				graphics.drawArc(offset, offset, width - 2 * offset - 2, width
						- 2 * offset - 2, 90, i);
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private Spieler getSpieler() {
		return spielbrett.getSpieler(zeilennummer, spaltennummer);
	}

	public boolean isFor(int zeile, int spalte) {
		return zeilennummer == zeile && spaltennummer == spalte;
	}

	public void valueChanged() {
		paintSymbol(true);
	}

	public void gameOver() {
		gameOver = true;
	}

	public void setNeuesSpiel(Spielbrett spielbrett) {
		this.spielbrett = spielbrett;
		gameOver = false;
		repaint();
	}

}
