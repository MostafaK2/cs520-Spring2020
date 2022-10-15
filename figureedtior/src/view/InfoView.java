package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.FigureModel;
import controller.FigureController;


public class InfoView implements View
{
    JPanel infoPanel;
    JLabel infoLabel;
    JTextField infoField;


	// constructed that initializes the field valies
    public InfoView() {
		super();

		this.infoPanel = new JPanel(new GridLayout(1, 2));

		this.infoLabel = new JLabel();
		this.infoLabel.setText("Info:");
		this.infoPanel.add(this.infoLabel);

		this.infoField = new JTextField();
		this.infoField.setEditable(false);
		this.infoPanel.add(this.infoField);
    }

	// returns the infoPanel
    public JPanel getPanel() {
		return this.infoPanel;
    }

    public void addController(final FigureController controller) {
	//No-op
    }

	// sets the text field into the infoField text
    public void update(FigureModel model) {
		String infoMsg = "";
		if (model.isComplete() == false) {
			infoMsg = "This figure is not yet complete.";
		}

		this.infoField.setText(infoMsg);
    }
}
