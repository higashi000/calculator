import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import NumButton.NumButton;
import OperatorButton.OperatorButton;

class Calculator extends JFrame implements ActionListener {
   String formula;
   JPanel p = new JPanel();
   NumButton btns[];
   OperatorButton opebtn[];
   JTextArea textarea;
   boolean addOperatorFlg;

   public static void main(String args[]){
      Calculator frame = new Calculator("Calculator");
      frame.setVisible(true);
   }

   Calculator(String title){
      formula = "";
      addOperatorFlg = false;

      setTitle(title);
      setBounds(100, 100, 600, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      p = new JPanel();
      p.setLayout(new GridLayout(4, 4));
      btns = new NumButton[10];
      opebtn = new OperatorButton[6];
      textarea = new JTextArea();
      textarea.setFont(new Font("Cica", Font.PLAIN, 60));


      int btnPosX[] = {0, 25, 50, 0, 25, 50, 0, 25, 50, 25};
      int btnPosY[] = {0, 25, 50, 0, 25, 50, 0, 25, 50, 25};
      String operators[] = {"÷", "×", "ー", "＋", "=", "c"};

      for (int i = 0; i < 10; i++) {
         btns[i] = new NumButton(btnPosX[i], btnPosY[i], String.valueOf(i));
         btns[i].btn.addActionListener(this);
         btns[i].btn.setBounds(btnPosX[i], btnPosY[i], 20, 20);
      }

      for (int i = 0; i < 6; i++) {
         opebtn[i] = new OperatorButton(0, 0, operators[i]);
         opebtn[i].btn.addActionListener(this);
      }

      p.add(btns[7].btn);
      p.add(btns[8].btn);
      p.add(btns[9].btn);
      p.add(opebtn[0].btn);
      p.add(btns[4].btn);
      p.add(btns[5].btn);
      p.add(btns[6].btn);
      p.add(opebtn[1].btn);
      p.add(btns[1].btn);
      p.add(btns[2].btn);
      p.add(btns[3].btn);
      p.add(opebtn[2].btn);
      p.add(btns[0].btn);
      p.add(opebtn[5].btn);
      p.add(opebtn[4].btn);
      p.add(opebtn[3].btn);

      getContentPane().add(p, BorderLayout.CENTER);
      getContentPane().add(textarea, BorderLayout.NORTH);
   }

   public void actionPerformed(ActionEvent e){
      for (var btn: btns) {
         if (e.getSource() == btn.btn) {
            formula += btn.getNum();
            textarea.setText(formula);
         }
      }

      if (e.getSource() == opebtn[0].btn && !addOperatorFlg) {
         formula += opebtn[0].getOperator();
         textarea.setText(formula);
         addOperatorFlg = true;
      } else if (e.getSource() == opebtn[1].btn && !addOperatorFlg) {
         formula += opebtn[1].getOperator();
         textarea.setText(formula);
         addOperatorFlg = true;
      } else if (e.getSource() == opebtn[2].btn && !addOperatorFlg) {
         formula += opebtn[2].getOperator();
         textarea.setText(formula);
         addOperatorFlg = true;
      } else if (e.getSource() == opebtn[3].btn && !addOperatorFlg) {
         formula += opebtn[3].getOperator();
         textarea.setText(formula);
         addOperatorFlg = true;
      } else if (e.getSource() == opebtn[4].btn) {
         formula = String.valueOf(Calc(formula));
         textarea.setText(formula);
         addOperatorFlg = false;
      } else if (e.getSource() == opebtn[5].btn) {
         formula = "";
         textarea.setText(formula);
         addOperatorFlg = false;
      }
   }

   public double Calc(String ope) {
      double res = 0;

      if (ope.indexOf("＋") != -1) {
         String nums[] = ope.split("＋", 0);

         res = Double.parseDouble(nums[0]) + Double.parseDouble(nums[1]);
      } else if (ope.indexOf("ー") != -1) {
         String nums[] = ope.split("ー", 0);

         res = Double.parseDouble(nums[0]) - Double.parseDouble(nums[1]);
      } else if (ope.indexOf("×") != -1) {
         String nums[] = ope.split("×", 0);

         res = Double.parseDouble(nums[0]) * Double.parseDouble(nums[1]);
      } else if (ope.indexOf("÷") != -1) {
         String nums[] = ope.split("÷", 0);

         res = Double.parseDouble(nums[0]) / Double.parseDouble(nums[1]);
      }

      return res;
   }

}
