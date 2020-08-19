package NumButton;

import java.awt.Font;
import javax.swing.JButton;

public class NumButton {
   public JButton btn;
   private String btnNum;

   public NumButton(int posX, int posY, String  num) {
      btn = new JButton(num);
      btnNum = num;
      btn.setFont(new Font("Cica", Font.PLAIN, 28));
   }

   public String getNum() {
      return btnNum;
   }
}
