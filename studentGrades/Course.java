
/**
 * Class to define a specific course id and the title.
 *
 * @Charlie O'Sullivan
 * @1.0
 */
public class Course
{
    private String courseID;
    private String courseTitle;
    private int finalMark;
    private Grades finalGrade;   

    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;    

    /**
     * Create a Course and define the ID number and Title.
     */

    public Course(String courseID, String courseTitle)
    {
        this.courseID = courseID;
        this.courseTitle = courseTitle;

        module1 = new Module("Programming Concepts", "C0452");
        module2 = new Module("Application Programming", "CO453");
        module3 = new Module("Web Development", "CO456");
        module4 = new Module("Business Modelling", "CO457");
    }

    /**
     * 
     */
    public void addMark(int mark, int moduleNo)
    {
        if(moduleNo == 1)
        {
            module1.awardMark(mark);
        }

        else if(moduleNo == 2)
        {
            module2.awardMark(mark);
        }

        else if(moduleNo == 3)
        {
            module3.awardMark(mark);
        }

        else
        {
            module4.awardMark(mark);
       }           
    }

    public Grades convertToGrade(int mark)
    {
        if((mark >= 0) && (mark < 40))
        {
            return Grades.F;
        }

        else if((mark >= 40) && (mark <= 49))
        {
            return Grades.D;
        }
        else if((mark >= 50) && (mark <= 59))
        {
            return Grades.C;
        }        
        else if((mark >= 60) && (mark <= 69))
        {
            return Grades.B;
        }
        else if((mark >= 70) && (mark <= 100))
        {
            return Grades.A;
        }
        else
        {
            return Grades.X;
        }
    }

    public void print()
    {
        System.out.println("Course details: " + courseTitle + " " + courseID);
        module1.print();
        module2.print();
        module3.print();
        module4.print();
    }
}

