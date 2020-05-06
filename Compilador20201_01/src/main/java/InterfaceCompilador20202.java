import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.parser.Element;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JToolBar;

public class InterfaceCompilador20202 extends JFrame {
	
	private static Gramatica20201 parser = null;
	private static JTextArea textAreaINPUT;
	private static JTextArea lines;
	private JScrollPane jsp;
	private JPanel contentPane;
	private static JTextArea textAreaOUTPUT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCompilador20202 frame = new InterfaceCompilador20202();
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
	public InterfaceCompilador20202() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 566);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("File");
		mntmNewMenuItem_1.setMaximumSize(new Dimension(100, 32767));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edit");
		mntmNewMenuItem.setMaximumSize(new Dimension(100, 32767));
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Complilation");
		mntmNewMenuItem_2.setMaximumSize(new Dimension(150, 32767));
		menuBar.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		// INI customizacao do text area para mostrar linhas e atualizar o componente
		jsp = new JScrollPane();
		jsp.setBounds(5, 28, 870, 300);
	    textAreaINPUT = new JTextArea();
	    lines = new JTextArea("1");
	    lines.setBackground(Color.LIGHT_GRAY);
	    lines.setEditable(false);
	    //  codigo para implementar numero de linhas no JTextArea
	    textAreaINPUT.getDocument().addDocumentListener(new DocumentListener() {
	    	public String getText() {
	            int caretPosition = textAreaINPUT.getDocument().getLength();
	            javax.swing.text.Element root = textAreaINPUT.getDocument().getDefaultRootElement();
	            String text = "1" + System.getProperty("line.separator");
	               for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
	                  text += i + System.getProperty("line.separator");
	               }
	            return text;
	         }
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				lines.setText(getText());
			}
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				lines.setText(getText());
			}
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				lines.setText(getText());
			}
		}); 
	    contentPane.setLayout(null);
	    jsp.setViewportView(textAreaINPUT);
	    jsp.setRowHeaderView(lines);
	    getContentPane().add(jsp);
	    
	    textAreaOUTPUT = new JTextArea();
	    textAreaOUTPUT.setEditable(false);
	    textAreaOUTPUT.setBounds(5, 373, 870, 138);
	    
	    JScrollPane sp = new JScrollPane(textAreaOUTPUT);
	    sp.setBounds(5, 373, 870, 138);
	    contentPane.add(sp);
	    
	    JButton btnCompilar = new JButton("COMPILAR");
	    btnCompilar.setBounds(5, 339, 114, 23);
	    contentPane.add(btnCompilar);
	    
	    btnCompilar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textAreaOUTPUT.setText("");
				// TODO Auto-generated method stub
				String sentence = textAreaINPUT.getText();
                // Put parens around sentence so that parser knows scope
                sentence = "(" + sentence + ")";
                InputStream is = new ByteArrayInputStream(sentence.getBytes());
                if(parser == null) parser = new Gramatica20201(is);
                else Gramatica20201.ReInit(is);
                try
                {
                  switch (Gramatica20201.start())
                  {
                    case 0 :   
                    	for (String token : Gramatica20201.resultado) {
                    		textAreaOUTPUT.setText(token+"\n"+textAreaOUTPUT.getText());
						}
                    	Gramatica20201.resultado = new ArrayList<String>();
                    	//textAreaOUTPUT.setText("expression parsed ok.");
                    break;
                    default :
                    break;
                  }
                }
                catch (Exception e1)
                {
                  textAreaOUTPUT.setText("error in expression.\n"+
                		  				e1.getMessage());
                }
                catch (Error e1)
                {
                 textAreaOUTPUT.setText("error in expression.\n"+
    		  						   e1.getMessage());
                }
                finally
                {
                  
                }
				
			}
		});
	    
	    
	    JButton btnLimpar = new JButton("LIMPAR");
	    btnLimpar.setBounds(126, 339, 114, 23);
	    contentPane.add(btnLimpar);
	    
	    JToolBar toolBar = new JToolBar();
	    toolBar.setBounds(5, 1, 869, 23);
	    contentPane.add(toolBar);
	    btnLimpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textAreaINPUT.setText("");
				textAreaOUTPUT.setText("");
				
			}
		});
	    
	    
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	
	}
}