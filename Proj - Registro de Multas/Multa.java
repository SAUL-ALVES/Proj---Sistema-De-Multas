public class Multa implements Pagavel {
    private Infrator infrator;
    private String tipo;
    private String data;
    private double valor;
    private boolean pago; 

    public Multa(Infrator infrator, String tipo, String data, double valor) {
        if (!validarData(data)) {
            throw new IllegalArgumentException("Data inválida! Use o formato DD/MM/AAAA.");
        }
        this.infrator = infrator;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.pago = false; 
    }

    private boolean validarData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    @Override
    public double calcularValor() {
        return this.valor;
    }

    public Infrator getInfrator() {
        return infrator;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

   
    public String getTipo() {
        return tipo;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        String status = pago ? "Pago" : "Pendente";
        return "Tipo: " + tipo + ", Infrator: " + infrator + ", Data: " + data + ", Valor: R$" + valor + ", Status: " + status;
    }
}