import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMain  {
    public static JLabel wrong = new JLabel();
    public static JLabel editStatement= new JLabel();
    public static JFrame frame = new JFrame();
    public static JLabel output = new JLabel();
    private static JButton submit = new JButton("Submit");
    private static JButton remove = new JButton("Remove");
    private static JButton edit = new JButton("Edit");
    private static JButton add = new JButton("Add");


    private static JLabel rollNo = new JLabel();
    private static JLabel firstName = new JLabel();
    private static JLabel lastName = new JLabel();
    private static JLabel grade = new JLabel();
    private static JLabel section = new JLabel();
    private static JLabel score = new JLabel();


    private static JTextField rollNoData = new JTextField();
    private static JTextField firstNameData = new JTextField();
    private static JTextField lastNameData = new JTextField();
    private static JTextField gradeData = new JTextField();
    private static JTextField sectionData = new JTextField();
    private static JTextField scoreData = new JTextField();
    private static String instruction = "";



    ActionListener first = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {


            if(e.getSource() == add){
                frame.add(rollNo);
                frame.add(firstName);
                frame.add(lastName);
                frame.add(grade);
                frame.add(section);
                frame.add(score);

                frame.add(rollNoData);
                frame.add(firstNameData);
                frame.add(lastNameData);
                frame.add(gradeData);
                frame.add(sectionData);
                frame.add(scoreData);

                frame.add(submit);

                instruction = "add";

            }



            else if(e.getSource()==edit){
                frame.add(rollNo);
                frame.add(grade);
                frame.add(section);
                frame.add(score);

                frame.add(rollNoData);
                frame.add(gradeData);
                frame.add(sectionData);
                frame.add(scoreData);

                frame.add(submit);
                frame.add(editStatement);

                instruction = "edit";

            }



            else if(e.getSource()== remove){
                frame.add(rollNo);
                frame.add(rollNoData);

                frame.add(submit);

                instruction = "remove";

            }


        }
    };


    ActionListener second =  new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==submit){

                if(instruction.equals("add")){

                    String number = rollNoData.getText().trim();
                    String Name1 = firstNameData.getText().trim();
                    String Name2 = lastNameData.getText().trim();
                    String grade = gradeData.getText().trim();
                    String section = sectionData.getText().trim();
                    String score = scoreData.getText().trim();

                    if ((ValidOrNot.isItValid(number,Name1,Name2,grade,section,score).equals(""))){
                        Student student = new Student(number,Name1,Name2,grade,section,score);
                        StudentManagementSystem.add(student);
                        output.setText("Student successfully added");
                        frame.add(output);
                    }

                    else{
                        wrong.setText("<html>" + ValidOrNot.isItValid(number,Name1,Name2,grade,section,score) + "<html>");
                        frame.add(wrong);
                    }
                }



                else if(instruction.equals("remove")) {

                    String number = rollNoData.getText().trim();

                    if ((ValidOrNot.isItValid(number).equals(""))) {

                        if (StudentManagementSystem.remove(number)) {
                            output.setText("Data successfully removed");
                        } else {
                            output.setText("Data removal was unsuccessfull");
                        }
                        frame.add(output);
                    }

                    else{
                        wrong.setText("<html>" + ValidOrNot.isItValid(number) + "html");
                        frame.add(wrong);
                    }
                }



                else if(instruction.equals("edit")) {

                    String number = rollNoData.getText().trim();
                    String grade = gradeData.getText().trim();
                    String section = sectionData.getText().trim();
                    String score = scoreData.getText().trim();

                    if ((ValidOrNot.isItValid(number, grade, section, score).equals(""))) {

                        if (StudentManagementSystem.edit(number, grade, section, score)) {
                            output.setText("Data successfully edited");
                        } else {
                            output.setText("Editing Data was unsuccessfull");
                        }
                        frame.add(output);
                    }

                    else{
                        wrong.setText("<html>" + ValidOrNot.isItValid(number, grade, section, score) + "<html>");
                        frame.add(wrong);
                    }
                }
            }
        }
    };



    public static void main(String[] args) {

        StudentMain lol = new StudentMain();

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(570, 880);
        frame.setTitle("Student Management System");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(117,255,255));

        remove.setBounds(430, 30, 100, 50);
        remove.setBackground(new Color(150,90,200));
        remove.addActionListener(lol.first);
        remove.setOpaque(true);

        edit.setBounds(240, 30, 100, 50);
        edit.setBackground(new Color(150,90,200));
        edit.addActionListener(lol.first);
        edit.setOpaque(true);

        add.setBounds(50, 30, 100, 50);
        add.setBackground(new Color(150,90,200));
        add.addActionListener(lol.first);
        add.setOpaque(true);

        submit.setBounds(200, 600, 100, 50);
        submit.setBackground(new Color(150, 90, 200));
        submit.addActionListener(lol.second);
        submit.setOpaque(true);

        frame.add(remove);
        frame.add(edit);
        frame.add(add);

        output.setBounds(170,700,230,30);
        output.setOpaque(true);

        rollNo.setText("Roll No: ");
        rollNo.setBounds(50,115,85,25);
        rollNo.setOpaque(true);

        firstName.setText("First Name: ");
        firstName.setBounds(50,195,85,25);
        firstName.setOpaque(true);

        lastName.setText("Last Name: ");
        lastName.setBounds(50,275,85,25);
        lastName.setOpaque(true);

        grade.setText("Grade: ");
        grade.setBounds(50,355,85,25);
        grade.setOpaque(true);

        section.setText("Section: ");
        section.setBounds(50,435,85,25);
        section.setOpaque(true);

        score.setText("Score: ");
        score.setBounds(50,515,85,25);
        score.setOpaque(true);

        editStatement.setText("You may edit the following data fields......");
        editStatement.setBounds(150,300,300,25);

        wrong.setBounds(150,700,200,120);
        wrong.setOpaque(true);

        rollNoData.setBounds(300,115,140,25);
        firstNameData.setBounds(300,195,140,25);
        lastNameData.setBounds(300,275,140,25);
        gradeData.setBounds(300,355,140,25);
        sectionData.setBounds(300,435,140,25);
        scoreData.setBounds(300,515,140,25);

    }
}
