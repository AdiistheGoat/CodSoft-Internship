public class Student {
    private String firstName = "";
    private String lastName = "";
    private String rollNo = "";
    private String grade = "";

    private String section = "";

    private String score = "";


    public Student(String rollNo,String firstName,String lastName,String grade,String section,String score){
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.section = section;
        this.score = score;
    }

    public String[] getScore(){
        String[] data = new String[6];
        data[0] = rollNo;
        data[1] = firstName;
        data[2] = lastName;
        data[3] = grade;
        data[4] = section;
        data[5] = score;

        return data;
    }

}
