/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ground;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author simpumind
 */
public class ListModelExample extends JPanel {

  JList list;

  static DefaultListModel model;

  int counter = 15;
  static int n;

  public ListModelExample() {
    setLayout(new BorderLayout());
    model = new DefaultListModel();
    list = new JList(model);
    JScrollPane pane = new JScrollPane(list);
    JButton excercise1 = new JButton("Excercise 1");
    excercise1.setBounds(40, 30, 80, 25);
    JButton removeButton = new JButton("Excercise 3");
    removeButton.setBounds(40, 80, 80, 25);
    JButton excercise3 = new JButton("Excercise 2");
    excercise3.setBounds(40, 130, 80, 25);
    JButton excercise4 = new JButton("Excercise 4");
    excercise4.setBounds(40, 180, 80, 25);
   // for (int i = 0; i < 15; i++)
    //  model.addElement("Element " + i);
    
    excercise3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String alphabet = "abc";
                String elements = alphabet.substring(0, alphabet.length());
                perm1(elements); 
            }
        });
    
    excercise1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
              n =  model.size(); 
            }
        });
    add(pane, BorderLayout.NORTH);
    add(excercise1, BorderLayout.WEST);
    add(removeButton, BorderLayout.EAST);
    add(excercise3, BorderLayout.SOUTH);
    add(excercise4, BorderLayout.CENTER);
  }
  
   public  static void perm1(String s) {
        perm1("", s); 
    }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) model.addElement(prefix);
        else {
            for (int i = 0; i < N; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }

  public static void main(String s[]) {
    JFrame frame = new JFrame("Numbers of arrangement: " + n);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new ListModelExample());
    frame.setSize(460, 300);
    frame.setVisible(true);
  }
}