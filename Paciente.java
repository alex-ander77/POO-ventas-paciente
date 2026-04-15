public class Paciente {

    public String nombre;
    public String id;
    public String seguro;

    private int edad;
    private double costoConsulta;
    private int numeroConsultas;
    private int prioridad;
    public Paciente(String nombre, String id, String seguro, int edad, double costoConsulta, int numeroConsultas, int prioridad) {
        this.nombre = nombre;
        this.id = id;
        this.seguro = seguro;
        setEdad(edad);
        setCostoConsulta(costoConsulta);
        setNumeroConsultas(numeroConsultas);
        setPrioridad(prioridad);
    }

    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
    }

    public void setCostoConsulta(double costoConsulta) {
        if (costoConsulta > 0) this.costoConsulta = costoConsulta;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        if (numeroConsultas >= 0) this.numeroConsultas = numeroConsultas;
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 5) this.prioridad = prioridad;
    }

    public double calcularTotal() {
        return costoConsulta * numeroConsultas;
    }

    public double calcularDescuento() {
        double total = calcularTotal();

        if (seguro.equals("Basico")) return total * 0.10;
        if (seguro.equals("Premium")) return total * 0.20;
        return 0;
    }

    public double totalFinal() {
        return calcularTotal() - calcularDescuento();
    }

    public String clasificacion() {
        if (prioridad >= 4) return "Alta prioridad";
        else if (prioridad >= 2) return "Prioridad media";
        else return "Prioridad baja";
    }

    public String mensaje() {
        if (prioridad >= 4) return "Atención inmediata requerida";
        else if (prioridad >= 2) return "Seguimiento necesario";
        else return "Control regular";
    }

    public void mostrarReporte() {
        System.out.println("Paciente: " + nombre);
        System.out.println("Total: " + calcularTotal());
        System.out.println("Descuento: " + calcularDescuento());
        System.out.println("Pago final: " + totalFinal());
        System.out.println("Clasificación: " + clasificacion());
        System.out.println("Mensaje: " + mensaje());
    }
}