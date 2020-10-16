
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
    
    /**
     * Create a Course and define the ID number and Title.
     */
    
    public Course(String courseID, String courseTitle)
    {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
    }
    
    public void print()
    {
        System.out.println("Course details: " + courseTitle + courseID);
    }
}

