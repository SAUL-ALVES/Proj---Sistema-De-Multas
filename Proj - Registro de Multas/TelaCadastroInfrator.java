import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroInfrator {
    public TelaCadastroInfrator(List<Infrator> infratores) {
        JFrame frame = new JFrame("Cadastro de Infrator");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10)); 
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField cnhField = new JTextField();
        cnhField.setEnabled(false); 
        JButton salvarButton = criarBotao("Salvar", new Color(0, 123, 255));

        
        JPanel cnhPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel possuiCnhLabel = new JLabel("Possui CNH?");
        JButton simButton = criarBotao("Sim", new Color(40, 167, 69));
        JButton naoButton = criarBotao("Não", new Color(220, 53, 69));

        simButton.addActionListener(e -> {
            cnhField.setEnabled(true); 
            cnhField.setText(""); 
        });

        naoButton.addActionListener(e -> {
            cnhField.setEnabled(false); 
            cnhField.setText(""); 
        });

        cnhPanel.add(possuiCnhLabel);
        cnhPanel.add(simButton);
        cnhPanel.add(naoButton);

        frame.add(new JLabel("Nome:"));
        frame.add(nomeField);
        frame.add(new JLabel("CPF:"));
        frame.add(cpfField);
        frame.add(new JLabel("CNH:"));
        frame.add(cnhField);
        frame.add(cnhPanel);
        frame.add(new JLabel());
        frame.add(salvarButton);

        salvarButton.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String cnh = cnhField.getText().trim(); 

                if (nome.isEmpty() || cpf.isEmpty()) {
                    throw new IllegalArgumentException("Nome e CPF não podem estar vazios!");
                }

                
                for (Infrator infrator : infratores) {
                    if (infrator.getCpf().equals(cpf.replaceAll("[.-]", ""))) {
                        throw new IllegalArgumentException("CPF já cadastrado!");
                    }
                }

                
                if (!cnhField.isEnabled()) {
                    cnh = null;
                }

                infratores.add(new Infrator(nome, cpf, cnh));
                frame.dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 12));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return botao;
    }
}