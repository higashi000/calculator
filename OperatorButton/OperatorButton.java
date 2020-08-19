package OperatorButton;

import javax.swing.JButton;

public class OperatorButton {
   public JButton btn;
   private String operator;

   public OperatorButton(int posX, int posY, String  operatorStr) {
      operator = operatorStr;
      btn = new JButton(operatorStr);
      btn.setBounds(posX, posY, 20, 20);
   }

   public String getOperator() {
      return operator;
   }
}
