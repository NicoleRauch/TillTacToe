import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GrafikKaestchen extends JButton {

	private static final long serialVersionUID = 1L;

	private final Spielbrett spielbrett;
	private final int zeilennummer;
	private final int spaltennummer;
	
	private ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			spielbrett.naechsterZugAufFeld(zeilennummer, spaltennummer);
			Spieler gewinner = spielbrett.werHatGewonnen();
			if(gewinner == Spieler.LEER){
				
			} else {
				JOptionPane.showMessageDialog(null, gewinner + " hat gewonnen!");
			}
		}
	};

	public GrafikKaestchen(Spielbrett spielbrett, int zeilennummer,
			int spaltennummer) {
		this.spielbrett = spielbrett;
		this.zeilennummer = zeilennummer;
		this.spaltennummer = spaltennummer;

		this.addActionListener(listener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setText(spielbrett.getSpieler(zeilennummer, spaltennummer)
				.toString());
	}

}