package withIO;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.pigDecoder;
import core.pigEncoder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

public class pigTranslatorWithGUI extends JFrame {

	/**
	 * 
	 */
	private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private static final long serialVersionUID = -8006900031388563573L;
	private static JTextField textField;
	private static JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private static JTextArea textArea;
	private static JTextArea textArea_1;

	public static void main(String[] args) {
		pigTranslatorWithGUI frameTabel = new pigTranslatorWithGUI();
		frameTabel.setVisible(true);

	}

	public pigTranslatorWithGUI() {

		super();
		setTitle("Pig Language Translator");
		setSize(451, 302);
		setLocation(500, 280);

		JPanel panel = new JPanel();

		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[166px,grow][89px][166px,grow]", "[56px][199px,grow]"));

		button = new JButton("\u0E41\u0E1B\u0E25\u0E40\u0E1B\u0E47\u0E19\u0E20\u0E32\u0E29\u0E32\u0E2B\u0E21\u0E39");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				translateToPig();
			}
		});
		panel.add(button, "flowy,cell 0 0,alignx center,aligny center");

		textField = new JTextField();
		panel.add(textField, "cell 0 0,grow");
		textField.setColumns(10);
		JButton btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				translateToPig();
				translateToHuman();
				clipboard.setContents(new StringSelection(""), null);
			}
		});
		btnTranslate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				translateToPig();
			}
		});

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		panel.add(textArea, "cell 0 1,grow");
		panel.add(btnTranslate, "cell 1 1,growx,aligny top");

		button_1 = new JButton("\u0E41\u0E1B\u0E25\u0E40\u0E1B\u0E47\u0E19\u0E20\u0E32\u0E29\u0E32\u0E04\u0E19");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				translateToHuman();
			}
		});
		panel.add(button_1, "flowy,cell 2 0,alignx left,aligny center");

		textField_1 = new JTextField();
		panel.add(textField_1, "cell 2 0,grow");
		textField_1.setColumns(10);

		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		panel.add(textArea_1, "cell 2 1,grow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void translateToPig() {
		String human = textField.getText();
		String pig = pigEncoder.encode(human);
		textArea.setText(pig);
		clipboard.setContents(new StringSelection(pig), null);
	}

	public static void translateToHuman() {
		String pig = textField_1.getText();
		String human = pigDecoder.decode(pig);
		textArea_1.setText(human);
		clipboard.setContents(new StringSelection(human), null);
	}
}
