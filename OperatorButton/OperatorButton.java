package OperatorButton;

import javax.swing.JButton;
import java.awt.Font;

public class OperatorButton {
   public JButton btn;
   private String operator;

   public OperatorButton(int posX, int posY, String  operatorStr) {
      operator = operatorStr;
      btn = new JButton(operatorStr);
      btn.setFont(new Font("Cica", Font.PLAIN, 28));
   }

   public String getOperator() {
      return operator;
   }
}
