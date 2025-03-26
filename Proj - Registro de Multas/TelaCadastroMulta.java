import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroMulta {
    public TelaCadastroMulta(List<Infrator> infratores, List<Multa> multas) {
        JFrame frame = new JFrame("Cadastro de Multa");
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(5, 2, 10, 10));
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JComboBox<Infrator> infratorBox = new JComboBox<>(infratores.toArray(new Infrator[0]));
        JTextField tipoField = new JTextField();
        JTextField dataField = new JTextField();
        JTextField valorField = new JTextField();
        JButton salvarButton = criarBotao("Salvar", new Color(40, 167, 69));

        frame.add(new JLabel("Infrator:"));
        frame.add(infratorBox);
        frame.add(new JLabel("Tipo de Infração:"));
        frame.add(tipoField);
        frame.add(new JLabel("Data:"));
        frame.add(dataField);
        frame.add(new JLabel("Valor:"));
        frame.add(valorField);
        frame.add(new JLabel());
        frame.add(salvarButton);

        salvarButton.addActionListener(e -> {
            try {
                Infrator infratorSelecionado = (Infrator) infratorBox.getSelectedItem();
                String tipo = tipoField.getText();
                String data = dataField.getText();
                String valorTexto = valorField.getText();

                if (tipo.isEmpty() || data.isEmpty() || valorTexto.isEmpty()) {
                    throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
                }

                double valor = Double.parseDouble(valorTexto);
                multas.add(new Multa(infratorSelecionado, tipo, data, valor));
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro: Valor inválido! Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
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