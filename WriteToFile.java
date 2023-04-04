/** Java program that connects to a SQLite database and interacts with it through a series of methods. The class "Database" contains methods for adding,
updating, finalizing and finding incomplete projects in the database.
The first method "addProject" takes in a "Project" object and inserts its information into the database table "projects".
It uses a prepared statement with placeholders represented by the question marks (?), which are later set to the values of the project's attributes (project name,
client name, fee, start date, and due date) using the setter methods of the Project object.
The second method "updateProject" also takes in a "Project" object and updates the information of the project in the database table "projects" with the new values of the project's attributes.
The third method "finalizeProject" takes in a "Project" object and updates the finalised column of that project to 1, which means that the project is now finalised. 
It also updates the completion_date and invoice_sent columns to the current date and 1 respectively. The method also checks if the customer still owes any amount and if so,
it should generate an invoice containing the customer's contact details and the total amount that the customer must still pay.
The fourth method "findIncompleteProjects" returns a list of all projects that have not been finalised yet.
It uses a SELECT statement to get all the data from the "projects" table where the finalised column is 0.
Overall, this code helps in maintaining the project data in a database and performing CRUD(create, read, update and delete) operations on it.
*/ 
import java.sql.*;

class Database {
private static final String url = "jdbc:sqlite:project_db.db";

public static void addProject(Project project) {
    String sql = "INSERT INTO projects(project_name, client_name, fee, start_date, due_date) VALUES(?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, project.getProjectName());
        pstmt.setString(2, project.getClientName());
        pstmt.setDouble(3, project.getFee());
        pstmt.setString(4, project.getStartDate());
        pstmt.setString(5, project.getDueDate());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public static void updateProject(Project project) {
    String sql = "UPDATE projects SET client_name = ?, fee = ?, start_date = ?, due_date = ? WHERE project_name = ?";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, project.getClientName());
        pstmt.setDouble(2, project.getFee());
        pstmt.setString(3, project.getStartDate());
        pstmt.setString(4, project.getDueDate());
        pstmt.setString(5, project.getProjectName());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public static void finalizeProject(Project project) {
    String sql = "UPDATE projects SET finalised = 1, completion_date = ?, invoice_sent = 1 WHERE project_name = ?";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        double amountDue = project.getFee() - project.getAmountPaid();
        if (amountDue > 0) {
            //generate invoice
            //invoice should contain the customer’s contact details and the total amount that the customer must still pay.
        }
        pstmt.setString(1, project.getCompletionDate());
        pstmt.setString(2, project.getProjectName());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public static List<Project> findIncompleteProjects() {
    List<Project> projects = new ArrayList<>();
    String sql = "SELECT * FROM projects WHERE finalised = 0";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next());
         }
        }
    }

           