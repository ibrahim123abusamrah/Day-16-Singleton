
/*
 *
 *  Copyright (C) 2019.  PSEU - Palestine Polytechnic University - All Rights Reserved
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

/*
 * Created by Basel.Altamimi on 8/4/2019.
 */

package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
  private   int b1_hashcode ;
   private int b2_hashcode ;
private  boolean iscleack_b1 = false;
    private  boolean iscleack_b2 = false;
    public MainForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on JForm exit
        this.setTitle("Main Form");
        this.setSize(600, 200);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setVisible(true);

        JButton b1 = new JButton("Show Calender 1"); // Button 1 (Create Calender 1)
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                b1_hashcode = showNewCalender();
                iscleack_b1 = true;
                if (b1_hashcode != getB2_hashcode() && iscleack_b2)
                    JOptionPane.showMessageDialog(null,"HashCode of Calender1 doesn't equal Calender2 HashCode");

            }
        });

        JButton b2 = new JButton("Show Calender 2"); // Button 2 (Create Calender 2)
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                iscleack_b2 = true;
                b2_hashcode = showNewCalender();
                if (b2_hashcode != getB1_hashcode() && iscleack_b1)
                    JOptionPane.showMessageDialog(null,"HashCode of Calender1 doesn't equal Calender2 HashCode");
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(b1);
        panel.add(b2);

        this.add(panel);
    }

    /**
     * Create and show new calender object
     * Todo: This method logs the object HashCode in a text file, after refactoring the code; show warning message if the HashCode of Calender1 doesn't equal Calender2 HashCode
     */
    private int showNewCalender() {
        SwingCalendar sc = new SwingCalendar();
        sc.setVisible(true);
        Util.Logger.log("Object HC: " + sc.hashCode()); // Log Calender hash code
        return  sc.hashCode();
    }
public int getB1_hashcode(){

        return  b1_hashcode;

}
    public int getB2_hashcode(){

        return  b2_hashcode;

    }
}
