package Proyecto;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public abstract class InterfazAbstracta extends JFrame {
    protected JLabel usuarioLabel;
    protected JLabel contraseñaLabel;
    protected JLabel mensajeLabel;
    protected JTextField usuarioField;
    protected JPasswordField contraseñaField;
    protected JButton aceptarButton;
    protected JButton cancelarButton;
    protected JLabel tituloin;
    protected int intentos = 3;
    protected final String[][] usuarios = { 
        //usuarios y contraseñas.
        {"Luis", "Luish"},
        {"Hernan", "Hernanl"},
        {"Ramirez", "Ramirezo"},
        {"Ortiz", "Ortizr"}
    };
    
    public InterfazAbstracta(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(243, 229, 245));
        setSize(315, 225);
        estructura();
        setVisible(true);
    }
    
    protected abstract void titulo();
    protected abstract void crearEtiquetas();
    protected abstract void crearCamposTexto();
    protected abstract void crearBotones();
    protected abstract void validarUsuario();
    protected abstract void mostrarMensaje(String mensaje);
    private void estructura() {
        titulo();
        crearEtiquetas();
        crearCamposTexto();
        crearBotones();
    }
}
