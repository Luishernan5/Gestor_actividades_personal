package Proyecto;
import javax.swing.JFrame;

public abstract class VentanaAbstracta extends JFrame {
    public VentanaAbstracta() {
        setTitle("Ventana Abstracta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        estructura();
        setVisible(true);
    }

    //METODOS ABSTRACTOS
    protected abstract void titulo();
    protected abstract void crearEtiquetas();
    protected abstract void crearCamposTexto();
    protected abstract void crearBotones();
    protected abstract void validarUsuario();
    protected abstract void mostrarMensaje(String mensaje);

    protected void estructura() {
        titulo();
        crearEtiquetas();
        crearCamposTexto();
        crearBotones();
        validarUsuario();
        mostrarMensaje("Mensaje predeterminado");
    }
}
