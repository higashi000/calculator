package NumButton;

import javax.swing.JButton;
import NumButton.NumButton;

public class NumButton {
   public JButton btn;
   private String btnNum;

   public NumButton(int posX, int posY, String  num) {
      btn = new JButton(num);
      btnNum = num;
   }

   public String getNum() {
      return btnNum;
   }
}
