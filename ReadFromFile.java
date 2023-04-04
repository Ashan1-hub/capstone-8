/**The provided code defines a Java class called "DatabaseHandler" that creates a connection to a MySQL database 
using the "DriverManager" class and the JDBC API. The connection is established using the host, port, database
name, username, and password provided.
It also has a method called 'addProject' that takes an instance of the 'Project' class as a parameter. 
This method uses a prepared statement to insert data into the 'projects' table in the database. 
The data to be inserted is obtained from the fields of the 'Project' class instance passed as a parameter.
It also defined class 'Project' which has private fields such as projectNumber, projectName, buildingType,
physicalAddress, erfNumber, totalFee, amountPaid, deadline, architect, contractor, customer, status,
which are all of different types like String, int, double, etc. It also has constructor and getters for all the fields.
The 'Person' class is not defined in the provided code, but it is referenced as the type for the 'architect', 'contractor',
 and 'customer' fields in the 'Project' class. It is assumed that it has similar fields and methods as 'Project'.
*/

import java.sql.*;

class DatabaseHandler {
    private Connection conn;

    public DatabaseHandler() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://host:port/dbname", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addProject(Project project) {
        // Insert the project information into the database
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO projects (projectNumber, projectName, buildingType, physicalAddress, erfNumber, totalFee, amountPaid, deadline, architectName, architectSurname, architectTele, architectEmail, architectAddress, contractorName, contractorSurname, contractorTele, contractorEmail, contractorAddress, customerName, customerSurname, customerTele, customerEmail, customerAddress, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, project.getProjectNumber());
            stmt.setString(2, project.getProjectName());
            stmt.setString(3, project.getBuildingType());
            stmt.setString(4, project.getPhysicalAddress());
            stmt.setInt(5, project.getErfNumber());
            stmt.setDouble(6, project.getTotalFee());
            stmt.setDouble(7, project.getAmountPaid());
            stmt.setString(8, project.getDeadline());
            stmt.setString(9, project.getArchitect().getName());
            stmt.setString(10, project.getArchitect().getSurname());
            stmt.setString(11, project.getArchitect().getTelephone());
            stmt.setString(12, project.getArchitect().getEmail());
            stmt.setString(13, project.getArchitect().getAddress());
            stmt.setString(14, project.getContractor().getName());
            stmt.setString(15, project.getContractor().getSurname());
            stmt.setString(16, project.getContractor().getTelephone());
            stmt.setString(17, project.getContractor().getEmail());
            stmt.setString(18, project.getContractor().getAddress());
            stmt.setString(19, project.getCustomer().getName());
            stmt.setString(20, project.getCustomer().getSurname());
            stmt.setString(21, project.getCustomer().getTelephone());
            stmt.setString(22, project.getCustomer().getEmail());
            stmt.setString(23, project.getCustomer().getAddress());
            stmt.setString(24, project.getStatus());
            stmt.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
            }
            }
            }
            
            class Project {
            private String projectNumber;
            private String projectName;
            private String buildingType;
            private String physicalAddress;
            private int erfNumber;
            double totalFee;
            double amountPaid;
            private String deadline;
            private Person architect;
            private Person contractor;
            private Person customer;
            private String status;
            
            
            public Project(String projectNumber, String projectName, String buildingType, String physicalAddress, int erfNumber, double totalFee, double amountPaid, String deadline, Person architect, Person contractor, Person customer, String status) {
                this.projectNumber = projectNumber;
                this.projectName = projectName;
                this.buildingType = buildingType;
                this.physicalAddress = physicalAddress;
                this.erfNumber = erfNumber;
                this.totalFee = totalFee;
                this.amountPaid = amountPaid;
                this.deadline = deadline;
                this.architect = architect;
                this.contractor = contractor;
                this.customer = customer;
                this.status = status;
            }
            
            public String getProjectNumber() {
                return projectNumber;
            }
            
            public String getProjectName() {
                return projectName;
            }
            
            public String getBuildingType() {
                return buildingType;
            }
            
            public String getPhysicalAddress() {
                return physicalAddress;
            }
            
            public int getErfNumber() {
                return erfNumber;
            }
            
            public double getTotalFee() {
                return totalFee;
            }
            
            public double getAmountPaid() {
                return amountPaid;
            }
            
            public String getDeadline() {
                return deadline;
            }
            
            public Person getArchitect() {
                return architect;
            }
            
            public Person getContractor() {
                return contractor;
            }
            
            public Person getCustomer() {
                return customer;
            }
            
            public String getStatus() {
                return status;
            }
            }
            
            class Person {
            private String name;
            private String surname;
            private String telephone;
            private String email;
            private String address;
            
        
            public Person(String name, String surname, String telephone, String email, String address) {
                this.name = name;
                this.surname = surname;
                this.telephone = telephone;
                this.email = email;
                this.address = address;
            }
            
            public String getName() {
                return name;
            }
            
            public String getSurname() {
                return surname;
            }
            
            public String getTelephone() {
                return telephone;
            }
            
            public String getEmail() {
                return email;
            }
            
            public String getAddress() {
                return address;
            }
            }
            
            
            
            





         
            
            
            