package tilltactoe;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javaCode.ISpielbrett;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import scalaCode.Spieler;

public class UIField extends JPanel {

	private static final long serialVersionUID = 1L;

	private int offset = 15;
	private final int zeilennummer;
	private final int spaltennummer;
	private final ISpielbrett spielbrett;
	private final Action action;

	public UIField(ISpielbrett spielbrett, int zeilennummer, int spaltennummer, Action action) {
		super();
		this.spielbrett = spielbrett;
		this.zeilennummer = zeilennummer;
		this.spaltennummer = spaltennummer;
		this.action = action;
		initialize();
	}

	private void initialize() {
		this.setPreferredSize(new Dimension(100, 100));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				spielbrett.naechsterZugAufFeld(zeilennummer, spaltennummer);
				if (getSpieler().istNiemand()) {
					return;
				}
				paintSymbol(true);
				pruefeGewinner();
			}

		});
	}

	protected void pruefeGewinner() {
		Spieler gewinner = spielbrett.werHatGewonnen();
		if(gewinner.istNiemand()){
			if(spielbrett.sindAlleFelderBelegt()){
				JOptionPane.showMessageDialog(null, "Das Spiel ist unentschieden.");
				action.actionPerformed(null);
			}
		} else {
			JOptionPane.showMessageDialog(null, gewinner + " hat gewonnen!");
			action.actionPerformed(null);
		}		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BasicStroke basicStroke = new BasicStroke(2);
		((Graphics2D) g).setStroke(basicStroke);
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
		int sleepTime = slow ? 5 : 0;

		int width = getWidth();

		Graphics2D graphics = (Graphics2D) this.getGraphics();
		BasicStroke basicStroke = new BasicStroke(3);
		graphics.setStroke(basicStroke);
		for (int i = offset; i < width - offset; i++) {
			graphics.drawLine(offset, offset, i, i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = offset; i < width - offset; i++) {
			graphics.drawLine(width - offset, offset, width - i, i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void drawCircle(boolean slow) {
		int width = getWidth();
		int sleepTime = slow ? 2 : 0;

		Graphics2D graphics = (Graphics2D) this.getGraphics();
		BasicStroke basicStroke = new BasicStroke(3);
		graphics.setStroke(basicStroke);
		for (int i = 0; i < 361; i++) {
			graphics.drawArc(offset, offset, width - 2 * offset - 2, width - 2
					* offset - 2, 90, i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Spieler getSpieler() {
		return spielbrett.getSpieler(zeilennummer, spaltennummer);
	}

}
