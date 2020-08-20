package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerArquivoTexto;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

public class View extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		ControllerArquivoTexto controller = new ControllerArquivoTexto();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
	
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int desejo = JOptionPane.showConfirmDialog(null, "Deseja fechar o aplicativo?");
				System.out.println("clicou em " +desejo);
				if(desejo == 0){
					System.exit(0);
				}else{
					
				}
				
			}
		});
		menuBar.add(menuSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTextArea texto = new JTextArea();
		contentPane.add(texto);
		
		JMenuItem menuAbrir = new JMenuItem("Abrir");
		menuBar.add(menuAbrir);
		
		menuAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.setArquivo("Abrir");
				texto.setText(controller.ler());
			}
		});
		
		JMenuItem menuSalvar = new JMenuItem("Salvar");
		menuSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.setArquivo("Salvar");
				controller.setTexto(texto.getText());
				controller.escrever(false);
				
				JOptionPane.showMessageDialog(null,"Arquivo gravado com sucesso!",
											  "Sucesso!", 0);
				
			}
		});
		menuBar.add(menuSalvar);
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
