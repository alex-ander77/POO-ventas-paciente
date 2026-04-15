public class Vendedor {

    public String nombre;
    public String area;

    private double montoVendido;
    private double porcentajeComision;
    private double cumplimientoMeta;

    public Vendedor(String nombre, String area, double montoVendido, double porcentajeComision, double cumplimientoMeta) {
        this.nombre = nombre;
        this.area = area;
        this.setMontoVendido(montoVendido);
        this.setPorcentajeComision(porcentajeComision);
        this.setCumplimientoMeta(cumplimientoMeta);
    }

    public double getMontoVendido() {
        return montoVendido;
    }

    public void setMontoVendido(double montoVendido) {
        if (montoVendido >= 0) {
            this.montoVendido = montoVendido;
        }
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        if (porcentajeComision >= 0) {
            this.porcentajeComision = porcentajeComision;
        }
    }

    public double getCumplimientoMeta() {
        return cumplimientoMeta;
    }

    public void setCumplimientoMeta(double cumplimientoMeta) {
        if (cumplimientoMeta >= 0 && cumplimientoMeta <= 100) {
            this.cumplimientoMeta = cumplimientoMeta;
        }
    }

    public double calcularComision() {
        return montoVendido * (porcentajeComision / 100);
    }

    public double calcularIngresoTotal() {
        return montoVendido + calcularComision();
    }

    public String estadoCumplimiento() {
        if (cumplimientoMeta >= 90) return "Excelente";
        else if (cumplimientoMeta >= 70) return "Aceptable";
        else return "Bajo";
    }

    public String mensajeFinal() {
        String estado = estadoCumplimiento();

        if (estado.equals("Excelente"))
            return "Vendedor con desempeño sobresaliente";
        else if (estado.equals("Aceptable"))
            return "Vendedor con desempeño aceptable";
        else
            return "Se requiere seguimiento comercial";
    }

    public void mostrarReporte() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Área: " + area);
        System.out.println("Comisión: " + calcularComision());
        System.out.println("Ingreso total: " + calcularIngresoTotal());
        System.out.println("Estado: " + estadoCumplimiento());
        System.out.println("Mensaje: " + mensajeFinal());
    }
}