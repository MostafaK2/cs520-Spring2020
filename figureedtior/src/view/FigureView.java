package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalIconFactory.PaletteCloseIcon;
import javax.swing.ImageIcon;

import model.FigureModel;
import controller.FigureController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class FigureView implements View, PropertyChangeListener
{
    JPanel figurePanel;
    JLabel imageView;
	// image
    JButton changeImageButton;
    JLabel captionView;
    JButton editCaptionButton;

	
	// initializes the JPanel with the grid layout and button
    public FigureView() {
		super();

		this.figurePanel = new JPanel(new GridLayout(2,1));

		JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.imageView = new JLabel();
		imagePanel.add(this.imageView);
		this.changeImageButton = new JButton("Change image...");
		this.changeImageButton.setSize(125, 75);
		imagePanel.add(this.changeImageButton);
		this.figurePanel.add(imagePanel);

		JPanel captionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.captionView = new JLabel();
		this.captionView.setSize(500, 75);
		captionPanel.add(this.captionView);	
		this.editCaptionButton = new JButton("Edit caption...");
		this.editCaptionButton.setSize(125, 75);
		captionPanel.add(this.editCaptionButton);
		this.figurePanel.add(captionPanel);
    }

	// gets the figurePanel created in the beggining
    public JPanel getPanel() {
		return this.figurePanel;
    }

	// adds the controlllers
    public void addController(final FigureController controller) {
		this.changeImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeImage();
			}
		});

		this.editCaptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.editCaption();
			}
		});
    }

	// updates the figure model with image and caption
    public void update(FigureModel model) {
		
		if (model.getImage() != null) {
			model.register(this, "image");
			this.imageView.setIcon(model.getImage());
		}
		if (model.getCaption() != null) {
			model.register(this, "caption");
			this.captionView.setText(model.getCaption());
		}
    }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println();
		
	}
}
