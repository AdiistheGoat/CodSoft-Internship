import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


// do better styling
// to get put of any void method , do return;
// to dispose the frame with delay
// align text in the middle


public class Main implements ActionListener {

    // JTextField can be used to add , set or get some text.
    public static JFrame frame = new JFrame();
    private static JButton cal = new JButton("Submit");
    private static JTextField sub1 = new JTextField();
    private static JTextField sub2 = new JTextField();
    private static JTextField sub3 = new JTextField();
    private static JTextField sub4 = new JTextField();
    private static JTextField sub5 = new JTextField();
    private static JTextField sub6 = new JTextField();



    private static String isItValid(String[] arr) {

        String errors = "";

        int i = 0;
        int j = 0;
        ArrayList<Integer> valid = new ArrayList<>();


        while (i < arr.length){

            try {
                int num = Integer.parseInt(arr[i]);
                valid.add(i);
            }


            catch (NumberFormatException e) {

                if(arr[i].equals("")){
                    errors += "No score given for subject " + (i + 1) + "<br>";
                }

                else {
                    errors += "Score for subject " + (i + 1) + " is not a number<br>";
                }
            }


            i++;

        }

        for(j=0;j<valid.size();j++){

            int num = Integer.parseInt(arr[valid.get(j)]);
            if(num<0){
                errors += "Score for subject " + (valid.get(j)+1) + " are negative<br>";
            }

            else if(num>100){
                errors += "Score for subject " + (valid.get(j)+1) + " is more than 100<br>";
            }
        }

        return errors;

    }




    private double averagePercentage(String[] marks){
        String percentage = Double.toString((double)totalMarks(marks)/marks.length) ;
        int index = percentage.indexOf(".");
        return  Double.parseDouble(percentage.substring(0,index+2));
    }


    private int totalMarks(String[] marks){
        int sum = 0;
        for(String i : marks){
            sum += Math.abs(Integer.parseInt(i)); // mods the negative value
        }

        return sum;
    }

    private String grade(double percentage){

      if(percentage<=50){
          return "F";
      }

      else if(percentage<60){
          return "D";
      }

      else if (percentage<72){
          return "C";
      }

      else if(percentage<80){
          return "BC";
      }

      else if(percentage<88){
          return "B";
      }

      else if (percentage<93){
          return "AB";
      }


      else if(percentage<=100){
          return "A";
      }

      return "";

    }


    public static void main(String[] args)  {


        Main lol = new Main(); //creates a new frame object
        frame.setLayout(null); // sets content panel to absolute layout

        cal.setBounds(240, 370, 100, 50);
        cal.setBackground(new Color(30,60,70));
        cal.addActionListener(lol);



        JLabel l1 = new JLabel("Subject 1");
        JLabel l2 = new JLabel("Subject 2");
        JLabel l3 = new JLabel("Subject 3");
        JLabel l4 = new JLabel("Subject 4");
        JLabel l5 = new JLabel("Subject 5");
        JLabel l6 = new JLabel("Subject 6");
        // we can do l6.setText("Subject 6");

        // perfroms an action when we click on it


        sub1.setBounds(250, 50, 200, 25);
        sub2.setBounds(250, 100, 200, 25);
        sub3.setBounds(250, 150, 200, 25);
        sub4.setBounds(250, 200, 200, 25);
        sub5.setBounds(250, 250, 200, 25);
        sub6.setBounds(250, 300, 200 ,25);

        l1.setBounds(10, 50, 200, 25);
        l2.setBounds(10, 100, 200, 25);
        l3.setBounds(10, 150, 200, 25);
        l4.setBounds(10, 200, 200, 25);
        l5.setBounds(10, 250, 200, 25);
        l6.setBounds(10, 300, 200, 25);

        //l1.setForeground(new Color(0xFF7F50));
        l1.setForeground(new Color(255,127,80));
        l2.setForeground(new Color(255,127,80));
        l3.setForeground(new Color(255,127,80));
        l4.setForeground(new Color(255,127,80));
        l5.setForeground(new Color(255,127,80));
        l6.setForeground(new Color(255,127,80));

        l1.setFont(new Font("MV Boli",Font.PLAIN,20));
        l2.setFont(new Font("MV Boli",Font.PLAIN,20));
        l3.setFont(new Font("MV Boli",Font.PLAIN,20));
        l4.setFont(new Font("MV Boli",Font.PLAIN,20));
        l5.setFont(new Font("MV Boli",Font.PLAIN,20));
        l6.setFont(new Font("MV Boli",Font.PLAIN,20));




// text fields and labels are separate. you have to ensure correct positioning and size.
// x is x coordinate, y is y coordinate, height is height, width is width.


        frame.add(sub1);
        frame.add(sub2);
        frame.add(sub3);
        frame.add(sub4);
        frame.add(sub5);
        frame.add(sub6);

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);

        frame.add(cal);



        frame.setVisible(true);        // make frame visible
        frame.setSize(600, 880); // sets the x-dimension, y dimension
        frame.setTitle("Marks calculator");  // set the title
        frame.setResizable(true); // allows to resize or not
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exits out of application when cross is pressed.
        // frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //frame.getContentPane().setBackground(Color.green);//predefined colors
        frame.getContentPane().setBackground(new Color(117,255,255));


// the no fot ext that fits in label depends on width.

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cal){


            JLabel error = new JLabel();
            JLabel errors = new JLabel();

            JLabel grade = new JLabel();
            JLabel averagePercentage = new JLabel();
            JLabel totalMarks = new JLabel();

            JLabel grade1 = new JLabel();
            JLabel averagePercentage1 = new JLabel();
            JLabel totalMarks1 = new JLabel();

            totalMarks.setForeground(new Color(255,127,80));
            averagePercentage.setForeground(new Color(255,127,80));
            grade.setForeground(new Color(255,127,80));

            error.setBounds(180,650,300,40);
            error.setOpaque(true);
            errors.setBounds(180,700,300,100);
            errors.setOpaque(true);

            totalMarks.setBounds(10,450,100,50);
            averagePercentage.setBounds(10,500,100,50);
            grade.setBounds(10,550,100,50);


            totalMarks1.setBounds(200,450,100,50);
            averagePercentage1.setBounds(200,500,100,50);
            grade1.setBounds(200,550,100,50);


            totalMarks.setText("Total Marks: ");
            averagePercentage.setText("Average(%): ");
            grade.setText("Grade: ");

             String[] marks = new String[6];
             marks[0]  = sub1.getText();  // retrieves text from textfield
             marks[1]  = sub2.getText();
             marks[2]  = sub3.getText();
             marks[3]  = sub4.getText();
             marks[4]  = sub5.getText();
             marks[5]  = sub6.getText();



           if(!(isItValid(marks).equals(""))){
               error.setText("<html>Invalid values<br>The errors are listed out as following-:<html>");
               errors.setText("<html>" + isItValid(marks) + "<html>");
               frame.add(errors);
           }

           // for jFrame, remember it's a frame, so do <html> and then br for new line.
           // it automatically resizes in the given height, if not fit in the given width.


           else {
               error.setText("Valid values");

               grade1.setText(grade(averagePercentage(marks)));
               averagePercentage1.setText(Double.toString(averagePercentage(marks)));
               totalMarks1.setText(Integer.toString(totalMarks(marks)));


               frame.add(totalMarks);
               frame.add(averagePercentage);
               frame.add(grade);

               frame.add(grade1);
               frame.add(averagePercentage1);
               frame.add(totalMarks1);


           }
            frame.add(error);
        }

    }
    // this method will listen for events
}

// first you have to set text and then add. it adds the label with the current text