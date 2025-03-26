import java.util.Objects;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String cnh; 

    public Pessoa(String nome, String cpf, String cnh) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        if (cnh != null && !cnh.isEmpty() && !validarCNH(cnh)) {
            throw new IllegalArgumentException("CNH inválida!");
        }
        this.nome = nome;
        this.cpf = formatarCPF(cpf);
        this.cnh = cnh != null ? formatarCNH(cnh) : null; 
    }

    private boolean validarCPF(String cpf) {
        
        cpf = cpf.replaceAll("[.-]", "");
        return cpf.matches("\\d{11}");
    }

    private boolean validarCNH(String cnh) {
        
        cnh = cnh.replaceAll("-", "");
        return cnh.matches("\\d{9}");
    }

    private String formatarCPF(String cpf) {
        
        cpf = cpf.replaceAll("[.-]", "");
        return cpf;
    }

    private String formatarCNH(String cnh) {
        
        cnh = cnh.replaceAll("-", "");
        return cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnh() {
        return cnh;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + (cnh != null ? ", CNH: " + cnh : ", Sem CNH") + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}