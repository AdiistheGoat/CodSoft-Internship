import java.io.*;
import java.util.Scanner;

public class StudentManagementSystem {

    private static FileInputStream input;

    static {
        try {
            input = new FileInputStream("students.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static FileOutputStream output;

    static {
        try {
            output = new FileOutputStream("studentsUpdated.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static Scanner scnr = new Scanner(input);
    private static PrintWriter write = new PrintWriter(output);


    public static void add(Student student) {

        while(scnr.hasNextLine()){
            write.print(scnr.nextLine() + "\n");
        }

        String[] data = student.getScore();
        for (int i = 0; i < data.length; i++) {
            write.print(data[i] + " ");
        }
        write.print("\n");

        try{
            if(write!=null){
                write.close();
            }

            if(scnr!=null){
                scnr.close();
            }

            if(input!=null){
                input.close();
            }

            if(output!=null){
                output.close();
            }
        }

        catch(IOException e){
            System.out.println("The file could not be closed");
        }
    }


    public static boolean remove(String rollNo) {
        boolean found = false;

        while (scnr.hasNextLine()) {

            if(scnr.next().equals(rollNo)){
                scnr.nextLine();
                found = true;
            }

            else{
                write.print(scnr.nextLine() + "\n");
            }
        }

        try{
            if(write!=null){
                write.close();
            }

            if(output!=null){
                output.close();
            }

            if(input!=null){
                input.close();
            }

            if(output!=null){
                output.close();
            }
        }

        catch(IOException e){
            System.out.println("The file could not be closed");
        }
        return found;
    }



    public static boolean edit(String rollno,String grade,String section,String score){

        boolean found = false;
        while(scnr.hasNextLine()){

            String possibleNum = scnr.next();

            if(possibleNum.equals(rollno)){
                write.print(possibleNum + " ");
                write.print(scnr.next() + " ");
                write.print(scnr.next() + " ");
                write.print(grade + " ");
                write.print(section + " ");
                write.print(score + " ");
                write.print("\n");
                scnr.next();
                scnr.next();
                scnr.next();
                found = true;
            }

            else{
                write.print(possibleNum);
                write.print(scnr.nextLine() + "\n");
            }
        }


        try{
            if(write!=null){
                write.close();
            }

            if(output!=null){
                output.close();
            }

            if(input!=null){
                input.close();
            }

            if(output!=null){
                output.close();
            }
        }

        catch(IOException e){
            System.out.println("The file could not be closed");
        }


        return found;
    }



}

