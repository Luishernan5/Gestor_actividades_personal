package Proyecto;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

// Clase principal que extiende de JFrame para crear la ventana
public class HorarioVentana extends JFrame {
    private static HorarioVentana ventanaPrincipal;
    private JButton[] diasButtons;
    private Horario[] horarios;
    private JPanel mainPanel;

    // Constructor de la clase
    public HorarioVentana() {
        setTitle("HORARIO DE LOS DIAS DE LA SEMANA");
        setSize(900, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal = this;  // Asigna la instancia actual a la variable 
                                  // estática para acceso global
        horarios = new Horario[7];
        String[] diasSemana = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", 
            "VIERNES", "SÁBADO", "DOMINGO"};
        for (int i = 0; i < 7; i++) {
            horarios[i] = new Horario(diasSemana[i]);
        }
        estructura();
        setVisible(true);
    }

    // Método para crear la estructura de la ventana
    public void estructura() {
        mainPanel = new JPanel(new GridLayout(3, 1));
        // Titulo
        JPanel tituloP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tituloP.setBackground(new Color(255, 243, 224));
        JLabel tituloD = new JLabel("DÍAS DE LA SEMANA", JLabel.CENTER);
        tituloD.setFont(new Font("Algerian", Font.BOLD, 35));
        tituloD.setForeground(new Color(255, 61, 0));
        tituloP.add(tituloD);
        mainPanel.add(tituloP);
        
        // Panel para los botones de los días de la semana
        JPanel diasP = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        diasP.setBackground(new Color(255, 243, 224));
        String[] diasSemana = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", 
            "VIERNES", "SÁBADO", "DOMINGO"};
        diasButtons = new JButton[diasSemana.length];
        for (int i = 0; i < diasSemana.length; i++) {
            int index = i;
            diasButtons[i] = new JButton(diasSemana[i]);
            diasButtons[i].addActionListener(e -> ingresoDeActividades(index));
            diasButtons[i].setFont(new Font("Times New Roman", Font.BOLD, 12));
            diasButtons[i].setPreferredSize(new Dimension(115, 60));
            diasButtons[i].setBackground(Color.YELLOW);
            diasButtons[i].setForeground(Color.BLACK);
            diasP.add(diasButtons[i]);
        }
        mainPanel.add(diasP);

        // Panel para los botones adicionales
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(255, 243, 224));

        JButton mostrarHorarioCompletoButton = new JButton("Mostrar Horario "
                + "Completo");
        mostrarHorarioCompletoButton.addActionListener(e -> 
                mostrarHorarioCompleto());
        mostrarHorarioCompletoButton.setPreferredSize(new Dimension(290, 30)); 
        mostrarHorarioCompletoButton.setBackground(new Color(255, 171, 231)); 
        mostrarHorarioCompletoButton.setForeground(Color.BLACK); 
        mostrarHorarioCompletoButton.setFont(new Font("Courier New", Font.
                PLAIN, 15)); 

        JButton seleccionarActividadesImportantesButton = new JButton
        ("Actividades Importantes");
        seleccionarActividadesImportantesButton.setPreferredSize(new Dimension
        (250, 30)); 
        seleccionarActividadesImportantesButton.setBackground(new Color(167,
                255, 235)); 
        seleccionarActividadesImportantesButton.setForeground(Color.BLACK); 
        seleccionarActividadesImportantesButton.setFont(new Font("Courier New",
                Font.PLAIN, 15)); 
        seleccionarActividadesImportantesButton.addActionListener(e -> 
                seleccionarActividadesImportantes());

        buttonsPanel.add(mostrarHorarioCompletoButton);
        buttonsPanel.add(seleccionarActividadesImportantesButton);

        mainPanel.add(buttonsPanel);

        add(mainPanel);
    }

    // Método para manejar el ingreso de actividades para un día específico
    private void ingresoDeActividades(int index) {
        dispose(); 
        JFrame imprimirFrame = new JFrame();
        imprimirFrame.setTitle("Ingresar Actividades - " + horarios[index].
                getDay());
        imprimirFrame.setSize(400, 600); 
        imprimirFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        imprimirFrame.setLocationRelativeTo(null); 

        // Panel para mostrar actividades por hora
        JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBackground(new Color(245, 127, 23));

        JLabel tituloH = new JLabel("HORARIO DEL " + horarios[index].getDay(),
                SwingConstants.CENTER);
        tituloH.setFont(new Font("Algerian", Font.PLAIN, 20));
        tituloH.setForeground(Color.BLACK); 

        // Panel para mostrar las actividades por hora con opciones de guardar
        JPanel imprimirActividadesPanel = new JPanel(new GridLayout(9, 1, 10, 
                10));
        imprimirActividadesPanel.setBackground(new Color(255, 243, 224));
        JTextArea[] actividadestexto = new JTextArea[9];
        String[] horas = {"5:00 a 7:00 am", "7:00 a 9:00 am", "9:00 a 11:00 am", 
            "11:00 a 1:00 pm", "1:00 a 3:00 pm", "3:00 a 5:00 pm", "5:00 a"
                + " 7:00 pm", 
            "7:00 a 9:00 pm", "9:00 a 11:00 pm"};
        for (int i = 0; i < 9; i++) {
            JPanel horasYactividadesP = new JPanel(new BorderLayout());
            horasYactividadesP.setBackground(new Color(255, 248, 225)); 
            JLabel HorasLabel = new JLabel(horas[i], SwingConstants.CENTER);
            HorasLabel.setPreferredSize(new Dimension(100, 20));
            horasYactividadesP.add(HorasLabel, BorderLayout.NORTH);
            actividadestexto[i] = new JTextArea(horarios[index].reractividades
        (i));
            actividadestexto[i].setPreferredSize(new Dimension(100, 60));
            actividadestexto[i].setBackground(new Color(255, 182, 193));
            actividadestexto[i].setFont(new Font("Times New Roman", Font.PLAIN,
                    16));
            horasYactividadesP.add(actividadestexto[i], BorderLayout.CENTER);
            imprimirActividadesPanel.add(horasYactividadesP);
        }

        // Botones para guardar, limpiar y regresar
        JButton guardarButton = new JButton("Guardar Datos");
        guardarButton.setBackground(new Color(167, 255, 235));
        guardarButton.setForeground(Color.BLACK); 
        guardarButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //excepciones personalizadas
                try {
                    guardarActividades(index, actividadestexto);
                } catch (VacioInvalidoException | TamañoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    System.out.println(ex.getMessage());
                }
            }
        });

        JButton limpiarDatosButton = new JButton("Limpiar Datos");
        limpiarDatosButton.setBackground(new Color(167, 255, 235)); 
        limpiarDatosButton.setForeground(Color.BLACK); 
        limpiarDatosButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        limpiarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarActividades();
                for (JTextArea textArea : actividadestexto){
                    textArea.setText("");
                }
            }
        });

        JButton regresarButton = new JButton("Regresar");
        regresarButton.setBackground(new Color(167, 255, 235));
        regresarButton.setForeground(Color.BLACK); 
        regresarButton.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        regresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirFrame.dispose(); 
                ventanaPrincipal.setVisible(true); 
            }
        });

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 
                10));
        botonesPanel.setBackground(new Color(255, 243, 224));
        botonesPanel.add(guardarButton);
        botonesPanel.add(limpiarDatosButton);
        botonesPanel.add(regresarButton);

        imprimirFrame.setLayout(new BorderLayout());
        imprimirFrame.add(tituloH, BorderLayout.NORTH);
        imprimirFrame.add(imprimirActividadesPanel, BorderLayout.CENTER);
        imprimirFrame.add(botonesPanel, BorderLayout.SOUTH);
        imprimirFrame.setVisible(true);
    }

    // Método para guardar las actividades ingresadas por el usuario
    private void guardarActividades(int index, JTextArea[] 
            actividadesTextAreas) throws VacioInvalidoException, 
            TamañoInvalidoException {
        horarios[index].limpiarActividades();
        for (int i = 0; i < actividadesTextAreas.length; i++) {
            String actividad = actividadesTextAreas[i].getText();
            //excepciones para ingreso de caracteres y actividades en blanco
            if (actividad.isEmpty()) {
                throw new VacioInvalidoException("Debe ingresar todas las "
                        + "actividad del dia");
            }
            if (actividad.length() < 1 || actividad.length() > 20) {
                throw new TamañoInvalidoException("La actividad"
                        + " ingresada debe tener entre 1 y 20 caracteres");
            }
            horarios[index].mostactividades(i, actividad);
        }
    }

    // Método para mostrar el horario completo
    private void mostrarHorarioCompleto() {
        dispose(); 
        JFrame displayFrame = new JFrame();
        displayFrame.setTitle("Horario Completo");
        displayFrame.setSize(1200, 600);
        displayFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        displayFrame.setLocationRelativeTo(null); 

        JPanel pantallaActividadesP = new JPanel(new GridLayout(1, 7, 10, 10));
        pantallaActividadesP.setBackground(new Color(243, 229, 246));//entre los
        //bordes
        String[] diasSemana = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", 
            "VIERNES", "SÁBADO", "DOMINGO"};
        for (int i = 0; i < 7; i++) {
            JPanel diaP = new JPanel(new BorderLayout());
            diaP.setBackground(new Color(206, 147, 216));//dias 
            JLabel dayLabel = new JLabel(diasSemana[i], SwingConstants.CENTER);
            dayLabel.setFont(new Font("Algerian", Font.PLAIN, 20));
            diaP.add(dayLabel, BorderLayout.NORTH);
            JPanel actividadesPanell = new JPanel(new GridLayout(9, 1, 10, 10));
            actividadesPanell.setBackground(new Color(243, 229, 246));//borde 
            //arriba
            String[] horas = {"5:00 a 7:00 am", "7:00 a 9:00 am", "9:00 a "
                    + "11:00 am", 
                "11:00 a 1:00 pm", "1:00 a 3:00 pm", "3:00 a 5:00 pm", "5:00"
                    + " a 7:00 pm", 
                "7:00 a 9:00 pm", "9:00 a 11:00 pm"};
            for (int j = 0; j < 9; j++) {
                JPanel horasyActividadesP = new JPanel(new BorderLayout());
                horasyActividadesP.setBackground(new Color(244, 255, 129));
                //horas
                JLabel timeLabel = new JLabel(horas[j], SwingConstants.CENTER);
                timeLabel.setPreferredSize(new Dimension(100, 20));
                horasyActividadesP.add(timeLabel, BorderLayout.NORTH);
                JTextArea actividadesTextArea = new JTextArea(horarios[i].
                        reractividades(j));
                actividadesTextArea.setEditable(false); 
                actividadesTextArea.setPreferredSize(new Dimension(100, 60));
                actividadesTextArea.setBackground(new Color(255, 204, 188));
                //actividades
                actividadesTextArea.setFont(new Font("Times New Roman", Font.
                        PLAIN, 16));
                if (horarios[i].esImportante(j)) {
                    actividadesTextArea.setBorder(BorderFactory.
                            createLineBorder(new Color(0, 96, 100)));//borde
                }
                horasyActividadesP.add(actividadesTextArea, BorderLayout.
                        CENTER);
                actividadesPanell.add(horasyActividadesP);
            }
            diaP.add(actividadesPanell, BorderLayout.CENTER);
            pantallaActividadesP.add(diaP);
        }

        // Botones para limpiar y regresar
        JButton limpiarDatosButton = new JButton("Limpiar Datos");
        limpiarDatosButton.setBackground(new Color(167, 255, 235));
        limpiarDatosButton.setForeground(Color.BLACK); 
        limpiarDatosButton.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        limpiarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarActividades();
                for (int i = 0; i < horarios.length; i++) {
                    JPanel dayPanel = (JPanel) pantallaActividadesP.
                            getComponent(i);
                    JPanel actividadPanel = (JPanel) dayPanel.getComponent(1);
                    Component[] components = actividadPanel.getComponents();
                    for (Component component : components) {
                        if (component instanceof JPanel) {
                            JTextArea actividadesTextArea = (JTextArea) 
                                    ((JPanel) 
                                    component).getComponent(1);
                            actividadesTextArea.setText("");
                        }
                    }
                }
            }
        });
        //boton regresar
        JButton regresoButton = new JButton("Regresar");
        regresoButton.setBackground(new Color(167, 255, 235)); 
        regresoButton.setForeground(Color.BLACK);
        regresoButton.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        regresoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFrame.dispose();
                ventanaPrincipal.setVisible(true); 
            }
        });

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 
                10));
        buttonsPanel.setBackground(new Color(243, 229, 246));//borde debajp
        buttonsPanel.add(limpiarDatosButton);
        buttonsPanel.add(regresoButton);

        displayFrame.setLayout(new BorderLayout());
        displayFrame.add(pantallaActividadesP, BorderLayout.CENTER);
        displayFrame.add(buttonsPanel, BorderLayout.SOUTH);
        displayFrame.setVisible(true);
    }

    // Método para seleccionar actividades importantes
    private void seleccionarActividadesImportantes() {
        JFrame seleccionFrame = new JFrame("Seleccionar Actividades "
                + "Importantes");
        seleccionFrame.setSize(400, 150);
        seleccionFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        //combo de actividades importantes
        JComboBox<String> comboBox = new JComboBox<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                comboBox.addItem(horarios[i].getDay() + " - " + horarios[i].
                        getHora(j));
            }
        }
        comboBox.setPreferredSize(new Dimension(250, 30));
        comboBox.setBackground(new Color(178, 223, 219)); 
        comboBox.setForeground(Color.BLACK); 
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        panel.add(comboBox, BorderLayout.NORTH);
        //boton seleccionar actividades importantes.
        JButton seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.setBackground(new Color(255, 182, 193)); 
        seleccionarButton.setForeground(Color.BLACK); 
        seleccionarButton.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        seleccionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                String[] parts = selectedItem.split(" - ");
                String dia = parts[0];
                String hora = parts[1];
                for (int i = 0; i < 7; i++) {
                    if (horarios[i].getDay().equals(dia)) {
                        for (int j = 0; j < 9; j++) {
                            if (horarios[i].getHora(j).equals(hora)) {
                                horarios[i].setImportante(j, true);
                                break;
                                // 1 Equals compara las cadenas de texto asegura 
                                //que el día seleccionado coincide con el día 
                                //del objeto
                                // 2 Equals asegura que la hora seleccionada 
                                //coincide con el intervalo de tiempo del objeto
                            }
                        }
                        break;
                    }
                }
                seleccionFrame.dispose(); 
            }
        });
        panel.add(seleccionarButton, BorderLayout.SOUTH);
        seleccionFrame.add(panel);
        seleccionFrame.setVisible(true);
    }
    // Método para limpiar todas las actividades
    private void limpiarActividades() {
        for (Horario horario : horarios) {
            horario.limpiarActividades();
        }
    }
}
// Excepción que se lanza si no se ingresa ninguna actividad
class VacioInvalidoException extends Exception {
    public VacioInvalidoException(String message) {
        super(message);
    }
}
// Excepción que se lanza si la longitud de la actividad es inválida
class TamañoInvalidoException extends Exception {
    public TamañoInvalidoException(String message) {
        super(message);
    }
}
