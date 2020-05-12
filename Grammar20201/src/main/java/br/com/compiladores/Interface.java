package br.com.compiladores;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.parser.Element;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Interface extends JFrame {
	
	private static Grammar20201 parser = null;
	private static JTextArea textAreaINPUT;
	private static JTextArea lines;
	private JScrollPane jsp;
	private JPanel contentPane;
	private static JTextArea textAreaOUTPUT;



	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu compilationMenu = new JMenu("Compilation");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(compilationMenu);
		
		JMenuItem newAction = new JMenuItem("New");
		JMenuItem openAction = new JMenuItem("Open");
		JMenuItem saveAction = new JMenuItem("Save");
		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		
		JMenuItem cutAction = new JMenuItem("Cut");
		JMenuItem copyAction = new JMenuItem("Copy");
		JMenuItem pasteAction = new JMenuItem("Paste");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		JMenuItem compileAction = new JMenuItem("Compile");
		JMenuItem runAction = new JMenuItem("Run");
		compilationMenu.add(compileAction);
		compilationMenu.add(runAction);
		
		
		
		
		// INI customizacao do text area para mostrar linhas e atualizar o componente
		jsp = new JScrollPane();
		jsp.setBounds(5, 50, 870, 300);
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

	    JButton btnNew = new JButton(new ImageIcon("images/new.png"));
	    btnNew.setBounds(5, 5, 30, 30);
	    contentPane.add(btnNew);
	    
	    JButton btnOpen = new JButton(new ImageIcon("images/open.png"));
	    btnOpen.setBounds(38, 5, 30, 30);
	    contentPane.add(btnOpen);
	    
	    btnOpen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				File file = selectFile();
				if (file != null) {
					textAreaINPUT.setText(lerArquivo(file));
				}
			}
		});
	    
	    JButton btnSave = new JButton(new ImageIcon("images/save.png"));
	    btnSave.setBounds(71, 5, 30, 30);
	    contentPane.add(btnSave);
	    
	    JButton btnCut = new JButton(new ImageIcon("images/cut.png"));
	    btnCut.setBounds(110, 5, 30, 30);
	    contentPane.add(btnCut);
	    
	    JButton btnCopy = new JButton(new ImageIcon("images/copy.png"));
	    btnCopy.setBounds(143, 5, 30, 30);
	    contentPane.add(btnCopy);
	    
	    JButton btnPaste = new JButton(new ImageIcon("images/paste.png"));
	    btnPaste.setBounds(176, 5, 30, 30);
	    contentPane.add(btnPaste);
	    
	    JButton btnCompiler = new JButton(new ImageIcon("images/compiler.png"));
	    btnCompiler.setBounds(215, 5, 30, 30);
	    contentPane.add(btnCompiler);
	    
	    JButton btnRun = new JButton(new ImageIcon("images/run.png"));
	    btnRun.setBounds(248, 5, 30, 30);
	    contentPane.add(btnRun);
	    
	    
	    
	    btnCompiler.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sentence = textAreaINPUT.getText();
                // Put parens around sentence so that parser knows scope
//                sentence = "(" + sentence + ")";
                InputStream is = new ByteArrayInputStream(sentence.getBytes());
                if(parser == null) parser = new Grammar20201(is);
                else Grammar20201.ReInit(is);
                try
                {
                  switch (Grammar20201.one_line())
                  {
                    case 0 :   
//                    	for (int i = Grammar20201.resultado.size()-1; i >= 0; i--){
//                    		textAreaOUTPUT.setText(Grammar20201.resultado.get(i)+"\n"+textAreaOUTPUT.getText());
//						}
//                    	Grammar20201.resultado = new ArrayList<String>();
                    	textAreaOUTPUT.setText("expression parsed ok.");
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
	    
	    
//	    JButton btnLimpar = new JButton("LIMPAR");
//	    btnLimpar.setBounds(236, 18, 114, 23);
//	    contentPane.add(btnLimpar);
//	    btnLimpar.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				textAreaINPUT.setText("");
//				textAreaOUTPUT.setText("");
//				
//			}
//		});
	    
	    
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	
	}
	
	public File selectFile() {
		JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
            // read  and/or display the file somehow. ....
        } else {
            return null;
        }
	}
	
	public String lerArquivo(File file) {
		try {
	      FileReader arq = new FileReader(file);
	      BufferedReader lerArq = new BufferedReader(arq);
	 
	      String linha = lerArq.readLine(); // lê a primeira linha
	      while (lerArq.ready()) {
	        linha += "\n"+lerArq.readLine(); // lê da segunda até a última linha
	      }
	 
	      arq.close();
	      return linha;
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
		return "";
	}
}
