
package informeguia3;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class animacion extends JFrame {

    private BufferedImage spritesheet;
    private Image[] frames;
    private int frameWidth = 112;
    private int frameHeight = 156;
    private int currentFrame = 0;
    private JLabel label;
    private Timer timer;
    private int delay = 1000; // tiempo de retraso inicial en milisegundos
    private int x = 0;
    private int y = 0;

    public animacion() {
        super("Animación con Spritesheet");
        cargarImagen();
        crearGUI();
        crearTimer();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarImagen() {
        try {
            spritesheet = ImageIO.read(new File("animacion.png"));
            frames = new Image[6];
            frames[0] = spritesheet.getSubimage(0, 0, frameWidth, frameHeight);
            frames[1] = spritesheet.getSubimage(frameWidth, 0, frameWidth, frameHeight);
            frames[2] = spritesheet.getSubimage(frameWidth*2, 0, frameWidth, frameHeight);
            frames[3] = spritesheet.getSubimage(frameWidth*3, 0, frameWidth, frameHeight);
            frames[4] = spritesheet.getSubimage(frameWidth*4, 0, frameWidth, frameHeight);
            frames[5] = spritesheet.getSubimage(frameWidth*5, 0, frameWidth, frameHeight);
        } catch (IOException a) {
          
        }
    }

    private void crearGUI() {
        JPanel panel = new JPanel(new BorderLayout());
        label = new JLabel(new ImageIcon(frames[currentFrame]));
        label.setBounds(x, y, frameWidth, frameHeight);
       panel.add(label, BorderLayout.CENTER);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 5);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent vel) {
                int value = ((JSlider) vel.getSource()).getValue();
                delay = 1000 / value; // ajustar el tiempo de retraso en función del valor del deslizador
                timer.setDelay(delay); // actualizar el temporizador con el nuevo tiempo de retraso
            }
        });
        panel.add(slider,BorderLayout.SOUTH);
        add(panel);
    }

    private void crearTimer() {
        timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentFrame = (currentFrame + 1) % frames.length;
                label.setIcon(new ImageIcon(frames[currentFrame]));
                x += 5; // aumentar la posición x en 5 unidades en cada iteración para mover la animación hacia la derecha
                label.setBounds(x, y, frameWidth, frameHeight); // actualizar la posición del JLabel
            }
        });
        timer.start();
    }

   

}
