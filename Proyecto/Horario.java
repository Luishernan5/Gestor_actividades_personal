package Proyecto;

public class Horario {
    // Atributos privados para almacenar el día, las actividades y su 
    //importancia
    private String dias;
    private String[] actividades;
    private boolean[] importantes;

    public Horario(String day) {
        // 'this' se utiliza para referirse al atributo de la instancia actual
        this.dias = day;
        this.actividades = new String[9]; // Inicializa el array con 9 
        //elementos, inicialmente null
        this.importantes = new boolean[9]; // Inicializa el array con 9 
        //elementos, inicialmente false
    }

    // Método para obtener el día
    public String getDay() {
        // 'return' devuelve el valor del atributo 'dias'
        return dias;
    }

    public String getHora(int index) {
        // 'int index' es el índice que se utiliza para acceder a una posición 
        //específica en el array 'horas'
        String[] horas = {"5:00 a 7:00 am", "7:00 a 9:00 am", "9:00 a 11:00 am", 
            "11:00 a 1:00 pm", "1:00 a 3:00 pm", "3:00 a 5:00 pm", "5:00 a 7:00 pm", 
            "7:00 a 9:00 pm", "9:00 a 11:00 pm"};
        // 'return' devuelve el intervalo de tiempo correspondiente al índice dado
        return horas[index];
    }
    
    public void limpiarActividades() {
        // 'length' devuelve la longitud del array 'actividades'
        for (int i = 0; i < actividades.length; i++) {
            actividades[i] = null; // 'null' significa que no hay actividad 
            //asignada en esta posición
            importantes[i] = false; // 'false' indica que la actividad no es 
            //importante
        }
    }

    public String reractividades(int index) {
        // 'int index' es el índice que se utiliza para acceder a una posición 
        //específica en el array 'actividades'
        // 'return' devuelve la actividad en la posición dada del 
        //array 'actividades'
        return actividades[index];
    }

    public void mostactividades(int index, String activity) {
        // 'this' se utiliza para referirse al array 'actividades' de la 
        //instancia actual
        // 'int index' es el índice donde se establecerá la nueva actividad
        this.actividades[index] = activity;
    }

    public void setImportante(int index, boolean importante) {
        // 'this' se utiliza para referirse al array 'importantes' de 
        //la instancia actual
        // 'int index' es el índice donde se establecerá el valor de importancia
        this.importantes[index] = importante;
    }

    public boolean esImportante(int index) {
        // 'return' devuelve el valor booleano que indica si la actividad en el 
        //índice dado es importante
        return importantes[index];
    }
}
