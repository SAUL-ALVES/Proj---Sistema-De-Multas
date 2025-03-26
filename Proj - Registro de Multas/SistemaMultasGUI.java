import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SistemaMultasGUI {
    private JFrame frame;
    private List<Infrator> infratores; 
    private List<Multa> multas;

    public SistemaMultasGUI() {
        infratores = new ArrayList<>();
        multas = new ArrayList<>();

        frame = new JFrame("Sistema de Multas");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 51, 102)); 
        headerPanel.setPreferredSize(new Dimension(frame.getWidth(), 80));
        JLabel titulo = new JLabel("Sistema de Multas");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        headerPanel.add(titulo);
        frame.add(headerPanel, BorderLayout.NORTH);

        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton cadastrarInfratorButton = criarBotao("Cadastrar Infrator", new Color(0, 123, 255));
        JButton cadastrarMultaButton = criarBotao("Cadastrar Multa", new Color(40, 167, 69));
        JButton consultarMultasButton = criarBotao("Consultar Multas", new Color(255, 193, 7));
        JButton fiscalButton = criarBotao("Área do Fiscal", new Color(220, 53, 69));

        cadastrarInfratorButton.addActionListener(e -> abrirTelaCadastroInfrator());
        cadastrarMultaButton.addActionListener(e -> abrirTelaCadastroMulta());
        consultarMultasButton.addActionListener(e -> abrirTelaConsultaMultas());
        fiscalButton.addActionListener(e -> abrirTelaFiscal());

        buttonPanel.add(cadastrarInfratorButton);
        buttonPanel.add(cadastrarMultaButton);
        buttonPanel.add(consultarMultasButton);
        buttonPanel.add(fiscalButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(0, 51, 102)); 
        footerPanel.setPreferredSize(new Dimension(frame.getWidth(), 50));
        JLabel rodape = new JLabel("© 2025 SisMult - Todos os direitos reservados");
        rodape.setFont(new Font("Arial", Font.PLAIN, 12));
        rodape.setForeground(Color.WHITE);
        footerPanel.add(rodape);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        return botao;
    }

    private void abrirTelaCadastroInfrator() {
        new TelaCadastroInfrator(infratores);
    }

    private void abrirTelaCadastroMulta() {
        new TelaCadastroMulta(infratores, multas);
    }

    private void abrirTelaConsultaMultas() {
        new TelaConsultaMultas(multas);
    }

    private void abrirTelaFiscal() {
        new TelaFiscal(infratores, multas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaMultasGUI());
    }
}