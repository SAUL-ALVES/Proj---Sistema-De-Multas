import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class TelaConsultaMultas {
    public TelaConsultaMultas(List<Multa> multas) {
        JFrame frame = new JFrame("Consulta de Multas");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        
        JPanel pesquisaPanel = new JPanel(new BorderLayout());
        pesquisaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField campoPesquisa = new JTextField();
        
        
        JButton botaoPesquisa = new JButton(UIManager.getIcon("FileChooser.detailsViewIcon"));
        botaoPesquisa.setPreferredSize(new Dimension(30, 30));
        botaoPesquisa.setBorder(BorderFactory.createEmptyBorder());

        pesquisaPanel.add(campoPesquisa, BorderLayout.CENTER);
        pesquisaPanel.add(botaoPesquisa, BorderLayout.EAST);

        
        JPanel infratoresPanel = new JPanel();
        infratoresPanel.setLayout(new BoxLayout(infratoresPanel, BoxLayout.Y_AXIS));
        infratoresPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        Map<Infrator, List<Multa>> multasPorInfrator = new HashMap<>();
        for (Multa multa : multas) {
            multasPorInfrator.computeIfAbsent(multa.getInfrator(), k -> new ArrayList<>()).add(multa);
        }

        
        for (Infrator infrator : multasPorInfrator.keySet()) {
            JButton botaoInfrator = new JButton(infrator.getNome() + " - " + infrator.getCpf());
            botaoInfrator.setAlignmentX(Component.CENTER_ALIGNMENT);
            botaoInfrator.addActionListener(e -> exibirDetalhesInfrator(infrator, multasPorInfrator.get(infrator)));
            infratoresPanel.add(botaoInfrator);
            infratoresPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        }

        JScrollPane scrollPane = new JScrollPane(infratoresPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        
        botaoPesquisa.addActionListener(e -> {
            String termoPesquisa = campoPesquisa.getText().trim();
            infratoresPanel.removeAll(); 

            for (Infrator infrator : multasPorInfrator.keySet()) {
                if (infrator.getNome().contains(termoPesquisa) || infrator.getCpf().contains(termoPesquisa)) {
                    JButton botaoInfrator = new JButton(infrator.getNome() + " - " + infrator.getCpf());
                    botaoInfrator.setAlignmentX(Component.CENTER_ALIGNMENT);
                    botaoInfrator.addActionListener(ev -> exibirDetalhesInfrator(infrator, multasPorInfrator.get(infrator)));
                    infratoresPanel.add(botaoInfrator);
                    infratoresPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
                }
            }

            infratoresPanel.revalidate();
            infratoresPanel.repaint();
        });

        frame.add(pesquisaPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void exibirDetalhesInfrator(Infrator infrator, List<Multa> multas) {
        JFrame detalhesFrame = new JFrame("Detalhes do Infrator");
        detalhesFrame.setSize(500, 400); 
        detalhesFrame.setLayout(new BorderLayout());
        detalhesFrame.getContentPane().setBackground(new Color(240, 240, 240));
    
        JPanel detalhesPanel = new JPanel();
        detalhesPanel.setLayout(new BoxLayout(detalhesPanel, BoxLayout.Y_AXIS));
        detalhesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        
        JLabel nomeLabel = new JLabel("Nome: " + infrator.getNome());
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nomeLabel.setForeground(new Color(0, 51, 102)); 
        detalhesPanel.add(nomeLabel);
    
        JLabel cpfLabel = new JLabel("CPF: " + infrator.getCpf());
        cpfLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detalhesPanel.add(cpfLabel);
    
        JLabel cnhLabel = new JLabel("CNH: " + (infrator.getCnh() != null ? infrator.getCnh() : "Sem CNH"));
        cnhLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detalhesPanel.add(cnhLabel);
    
        detalhesPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
    
        
        JLabel multasLabel = new JLabel("Multas:");
        multasLabel.setFont(new Font("Arial", Font.BOLD, 16));
        multasLabel.setForeground(new Color(0, 51, 102)); 
        detalhesPanel.add(multasLabel);
    
        
        JPanel multasPanel = new JPanel();
        multasPanel.setLayout(new BoxLayout(multasPanel, BoxLayout.Y_AXIS));
        multasPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        for (Multa multa : multas) {
            JPanel multaPanel = new JPanel();
            multaPanel.setLayout(new BoxLayout(multaPanel, BoxLayout.Y_AXIS));
            multaPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 1)); 
            multaPanel.setBackground(new Color(255, 255, 255)); 
            multaPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
            JLabel tipoLabel = new JLabel("Tipo: " + multa.getTipo());
            tipoLabel.setFont(new Font("Arial", Font.BOLD, 14));
            tipoLabel.setForeground(new Color(0, 51, 102)); 
    
            JLabel dataLabel = new JLabel("Data: " + multa.getData());
            dataLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    
            JLabel valorLabel = new JLabel("Valor: R$" + multa.calcularValor());
            valorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    
            JLabel statusLabel = new JLabel("Status: " + (multa.isPago() ? "Pago" : "Pendente"));
            statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            statusLabel.setForeground(multa.isPago() ? new Color(40, 167, 69) : new Color(220, 53, 69)); 
    
            multaPanel.add(tipoLabel);
            multaPanel.add(dataLabel);
            multaPanel.add(valorLabel);
            multaPanel.add(statusLabel);
    
            multasPanel.add(multaPanel);
            multasPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        }
    
        JScrollPane scrollMultas = new JScrollPane(multasPanel);
        detalhesPanel.add(scrollMultas);
    
        JScrollPane scrollPane = new JScrollPane(detalhesPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detalhesFrame.add(scrollPane, BorderLayout.CENTER);
        detalhesFrame.setVisible(true);
    }
}