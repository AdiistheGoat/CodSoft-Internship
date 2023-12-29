public class ValidOrNot {


    private static double test= 0;
    private static int test1 = 2;

    public static String isItValid(String number, String Name1, String Name2, String grade, String section, String score) {
        String errors = "";

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {

            if(number.equals("")){
                errors += "Roll no is not provided<br>";
            }

            else {
                errors += "Roll no is not a number<br>";
            }

        }

        if (Name1.equals("")) {
            errors += "No first name is provided<br>";
        }

        if (Name2.equals("")) {
            errors += "No last name is provided<br>";
        }

        try {
            test1 = Integer.parseInt(grade);
        } catch (NumberFormatException e) {

            if(grade.equals("")){
                errors += "Grade is not provided<br>";
            }

            else {
                errors += "Grade is not a number<br>";
            }
        }

        if((test1<0)||(test1>100)){
            errors+= "Grade is invalid<br>";
        }

        if(section.equals("")){
            errors += "No section is provided<br>";
        }

        else if(section.length()>1){
            errors += "Invalid Section";
        }


        try {
            test = Double.parseDouble(score);
        } catch (NumberFormatException e) {

            if(score.equals("")){
                errors += "Score is not provided<br>";
            }

            else {
                errors += "Score is not a number<br>";
            }
        }

        if((test<0)||(test>100)){
            errors+= "Score is invalid<br>";
        }

        return errors;
    }

    public static String isItValid(String number) {
        String errors = "";

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {

            if(number.equals("")){
                errors += "Roll no is not provided<br>";
            }

            else {
                errors += "Roll no is not a number<br>";
            }

        }
        return errors;
    }

    public static String isItValid(String number, String grade, String section, String score) {
        String errors = "";


        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {

            if(number.equals("")){
                errors += "Roll no is not provided<br>";
            }

            else {
                errors += "Roll no is not a number<br>";
            }

        }


        try {
            test1 = Integer.parseInt(grade);
        } catch (NumberFormatException e) {

            if(grade.equals("")){
                errors += "Grade is not provided<br>";
            }

            else {
                errors += "Grade is not a number<br>";
            }
        }

        if((test1<1)||(test1>12)){
            errors+= "Grade is invalid<br>";
        }



        if(section.equals("")){
            errors += "No section is provided<br>";
        }

        else if(section.length()>1){
            errors += "Invalid Section";
        }


        try {
            test = Double.parseDouble(score);
        } catch (NumberFormatException e) {

            if(score.equals("")){
                errors += "Score is not provided<br>";
            }

            else {
                errors += "Score is not a number<br>";
            }
        }

        if((test<0)||(test>100)){
            errors+= "Score is invalid<br>";
        }


        return errors;
    }


}
