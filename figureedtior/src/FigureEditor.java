import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;

import model.FigureModel;
import view.FigureView;
import view.InfoView;
import view.View;
import controller.FigureController;


public class FigureEditor
{
    private JFrame gui;


    public FigureEditor() {
	super();


	// sets a new JFrame with a dimension
	this.gui = new JFrame();
	this.gui.setTitle("Figure editor");
        this.gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gui.setSize(new Dimension(750, 500));
        this.gui.setResizable(true);
	this.gui.setLayout(new BorderLayout());

	FigureView figureView = new FigureView();
	this.gui.add(figureView.getPanel(), BorderLayout.CENTER);
	InfoView infoView = new InfoView();
	this.gui.add(infoView.getPanel(), BorderLayout.SOUTH);

	FigureModel model = new FigureModel();
	List<View> views = new ArrayList<View>();
	views.add(figureView);
	views.add(infoView);
	FigureController controller = new FigureController(this.gui, model, views);
    }

    public void show() {
	this.gui.show();
    }

    public static void main (String[] args) {
	FigureEditor editor = new FigureEditor();

	editor.show();
    }
}
