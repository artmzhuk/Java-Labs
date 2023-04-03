import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PictureForm {
    private JPanel mainPanel;
    private JSpinner spinnerA;
    private JSpinner spinnerB;
    private JSpinner spinnerAngle;
    private CanvasPanel canvasPanel1;

    public PictureForm() {
        spinnerA.setValue(100);
        spinnerB.setValue(100);
        spinnerAngle.setValue(0);

        spinnerA.addChangeListener (new ChangeListener( ) {
            public void stateChanged (ChangeEvent e) {
                int radius = (int)spinnerA.getValue( );
                canvasPanel1.setRadiusA(radius);
            }
        } );
        spinnerB.addChangeListener (new ChangeListener( ) {
            public void stateChanged (ChangeEvent e) {
                int radius = (int)spinnerB.getValue( );
                canvasPanel1.setRadiusB(radius);
            }
        } );
        spinnerAngle.addChangeListener (new ChangeListener( ) {
            public void stateChanged (ChangeEvent e) {
                int angle = (int)spinnerAngle.getValue( );
                canvasPanel1.setAngle(angle);
            }
        } );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Эллипс");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        canvasPanel1 = new CanvasPanel();// TODO: place custom component creation code here
    }
}

