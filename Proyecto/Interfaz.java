package Proyecto;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Interfaz extends JFrame implements InterfazUsuario {
    private JLabel usuarioLabel;
    private JLabel contraseñaLabel;
    private JLabel mensajeLabel;
    private JTextField usuarioField;
    private JPasswordField contraseñaField;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JLabel tituloIn;
    private int intentos = 3; 
    private final String[][] usuarios = { 
        //usuarios y contraseñas.
        {"Luis", "Luish"},
        {"Hernan", "Hernanl"},
        {"Ramirez", "Ramirezo"},
        {"Ortiz", "Ortizr"},
        {"L1", "h1"}
    };

    // Constructor de la clase Interfaz.
    public Interfaz(String titulo) {
        super(titulo); // Llama al constructor de JFrame con el título.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Configura la operación al cerrar.
        setLayout(new GridBagLayout()); // Usa GridBagLayout para la disposición
        //de componentes.
        getContentPane().setBackground(new Color(243, 229, 245)); 
        setSize(400, 300); 
        estructura(); // Llama al método estructura para configurar la interfaz.
        setVisible(true); 
    }

    // Método para organizar la estructura de la interfaz.
    private void estructura() {
        titulo(); // Añade el título.
        crearEtiquetas(); // Añade las etiquetas.
        crearCamposTexto(); // Añade los campos de texto.
        crearBotones(); // Añade los botones.
    }

    // Implementación del método titulo de la interfaz InterfazUsuario.
    @Override
    public void titulo() {
        tituloIn = new JLabel("INGRESO AL HORARIO"); 
        tituloIn.setFont(new Font("Times New Roman", Font.BOLD, 18)); 
        tituloIn.setForeground(Color.BLACK); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2; // Ancho del grid.
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes.
        add(tituloIn, gbc); 
    }

    // Implementación del método crearEtiquetas de la interfaz InterfazUsuario.
    @Override
    public void crearEtiquetas() {
        usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
        usuarioLabel.setForeground(Color.BLACK); 
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.WEST; // Alineación a la izquierda.
        gbc.insets = new Insets(5, 10, 5, 10); // Márgenes.
        add(usuarioLabel, gbc); 

        contraseñaLabel = new JLabel("Contraseña:"); 
        contraseñaLabel.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
        contraseñaLabel.setForeground(Color.BLACK); 
        gbc.gridy = 2; 
        add(contraseñaLabel, gbc); 

        mensajeLabel = new JLabel(""); 
        mensajeLabel.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
        mensajeLabel.setForeground(Color.RED); 
        gbc.gridy = 4; 
        gbc.gridwidth = 2; // Ancho del grid.
        add(mensajeLabel, gbc); 
    }

    //Implementación del método crearCamposTexto de la interfaz InterfazUsuario.
    @Override
    public void crearCamposTexto() {
        usuarioField = new JTextField(15); 
        usuarioField.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
        usuarioField.setBackground(new Color(227, 242, 253)); 
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.gridx = 1; 
        gbc.gridy = 1; 
        gbc.insets = new Insets(5, 10, 5, 10); 
        add(usuarioField, gbc); 

        contraseñaField = new JPasswordField(15); 
        contraseñaField.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
        contraseñaField.setBackground(new Color(227, 242, 253)); 
        gbc.gridy = 2; 
        add(contraseñaField, gbc); 
    }

    // Implementación del método crearBotones de la interfaz InterfazUsuario.
    @Override
    public void crearBotones() {
        aceptarButton = new JButton("Aceptar");
        aceptarButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        aceptarButton.setBackground(new Color(225, 245, 254)); 
        aceptarButton.addActionListener(e -> validarUsuario()); 
        // Añade un ActionListener al botón para validar usuario.
        GridBagConstraints gbc = new GridBagConstraints(); // Crea restricciones
        //para el layout.
        gbc.gridx = 0; // Posición X.
        gbc.gridy = 3; // Posición Y.
        gbc.insets = new Insets(5, 10, 5, 10); // Márgenes.
        add(aceptarButton, gbc); 

        cancelarButton = new JButton("Cancelar"); 
        cancelarButton.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
        cancelarButton.setBackground(new Color(225, 245, 254));
        cancelarButton.addActionListener(e -> dispose()); // Añade un 
        //ActionListener para cerrar la ventana.
        gbc.gridx = 1; 
        add(cancelarButton, gbc); 
    }

    // Implementación del método validarUsuario de la interfaz InterfazUsuario.
    @Override
    public void validarUsuario() {
        //obtiene el texto de usuario y contraseña ingresados
        String usuario = usuarioField.getText(); 
        String contraseña = new String(contraseñaField.getPassword()); 
        try {
            if (usuario.isEmpty()) {
                throw new IllegalArgumentException("El campo de usuario no "
                        + "puede estar vacío"); // Valida que el campo de 
                        //usuario no esté vacío.
            }
            if (contraseña.isEmpty()) {
                throw new NullPointerException("El campo de contraseña no puede"
                          + " estar vacío"); // Valida que el campo de contraseña 
                        //no esté vacío.
            }
            if (contraseña.length() < 3 || contraseña.length() > 9) {
                throw new StringIndexOutOfBoundsException("La contraseña debe "
                        + "tener entre 3 y 9 caracteres"); // Valida la longitud
                        //de la contraseña.
            }

            boolean usuarioEncontrado = false; // se iguala usuarioenontrado a
            //una variable falsa para verificar usuario y contraseña.
            for (String[] user : usuarios) {
                if (usuario.equals(user[0]) && contraseña.equals(user[1])) {
                //usuario y contraseña deben coincidir para cumplir esta 
                //condicion
                    new HorarioVentana(); // Abre una nueva ventana si los datos
                    //ingresados son correctas.
                    dispose(); // Cierra la ventana actual.
                    return; // Sale del método.
                }
                if (usuario.equals(user[0])) {
                    usuarioEncontrado = true; 
                    // Marca que el usuario fue encontrado.
                }
            }

            if (!usuarioEncontrado) {
                throw new ExcepcionUsuarioNoEncontrado("Usuario no encontrado"); 
                // Lanza una excepción si el usuario no fue encontrado.
            }

            intentos--; 
            if (intentos == 0) { //cuando intento sea igual a cero:
                JOptionPane.showMessageDialog(this, "Has excedido el número de "
                        + "intentos"); 
                System.exit(0); // Cierra la aplicación.
            } else {
                mostrarMensaje("Ingreso incorrecto. Intentos restantes: " + 
                        intentos);
                usuarioField.setText(""); // Limpia el campo de usuario.
                contraseñaField.setText(""); // Limpia el campo de contraseña.
            }
            
        } catch (IllegalArgumentException | NullPointerException | 
                StringIndexOutOfBoundsException | 
                ExcepcionUsuarioNoEncontrado e) {
            // IllegalArgumentException - cuando el campo de usuario está vacío.
            // NullPointerException - cuando el campo de contraseña está vacío.
            // StringIndexOutOfBoundsException - cuando la contraseña no tiene 
            //entre 3 y 9 caracteres.
            // ExcepcionUsuarioNoEncontrado - cuando el usuario no es encontrado
            //en la lista de usuarios.
            JOptionPane.showMessageDialog(this, "¡Ha surgido un error! " + 
                    e.getMessage()); 
            System.err.println("¡Ha surgido un error! " + e.getMessage());
        }
    }
    // Implementación del método mostrarMensaje de la interfaz InterfazUsuario.
    @Override
    public void mostrarMensaje(String mensaje) {
        mensajeLabel.setText(mensaje);
    }

    public static void main(String[] args) {
        new Interfaz("Interfaz de inicio"); //nueva instancia de la interfaz.
    }
}

// Definición de la clase ExcepcionUsuarioNoEncontrado que extiende Exception.
class ExcepcionUsuarioNoEncontrado extends Exception {
    public ExcepcionUsuarioNoEncontrado(String mensaje) {
        super(mensaje); // Llama al constructor de la superclase con el mensaje.
    }
}
