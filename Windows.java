import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.white;

public class Windows extends JPanel implements ActionListener
{
    private static JTextField positionX;
    private static JTextField positionY;
    public JFrame canvasWindow;
    public void mainWindow()
    {
        canvasWindow = new JFrame("Canvas Window");
        canvasWindow.setSize(1000,800);
        canvasWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvasWindow.setLayout(null);
        canvasWindow.setResizable(false);
        canvasWindow.setLocationRelativeTo(null);
        canvasWindow.setBackground(white);
        canvasWindow.setVisible(true);


        JButton circleButton = new JButton("Draw circle");
        circleButton.setSize(200,60);
        circleButton.setFocusable(false);

        JSlider sizeSlider = new JSlider(0,400,200);
        sizeSlider.setFocusable(false);
        sizeSlider.setSize(400,50);

        JLabel sizeLabel = new JLabel("Size: " + sizeSlider.getValue());
        sizeLabel.setBounds(660,590,70,20);

        positionX = new JTextField(5);
        positionX.setSize(200,60);

        positionY = new JTextField(5);
        positionY.setSize(200,60);

        circleButton.setLocation(10,580);
        circleButton.addActionListener(this);

        sizeSlider.setLocation(250,580);
        sizeSlider.addChangeListener(e -> Move.shapes.setSize(sizeSlider.getValue()));
        sizeSlider.addChangeListener(e -> sizeLabel.setText("Size: " + sizeSlider.getValue()));

        positionX.setLocation(750, 520);
        positionY.setLocation(750, 620);

        canvasWindow.add(sizeLabel);
        canvasWindow.add(sizeSlider);
        canvasWindow.add(circleButton);
        canvasWindow.add(positionX);
        canvasWindow.add(positionY);
        canvasWindow.add(Move.label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String x = positionX.getText();
        String y = positionY.getText();
        double a = Double.parseDouble(x);
        double b = Double.parseDouble(y);
        Move.shapes.addCircle(a, b);
        canvasWindow.add(Move.shapes);
        repaint();
    }
}
