package clinic.classes;

import java.sql.*;

public class DatabaseHandler
{
    private static Connection dbConnection;
    public static boolean getDbConnection(String login, String password) throws SQLException
    {
        dbConnection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/clinic?serverTimezone=UTC", login, password);
        System.out.println("Connected to the database.");
        return true;
    }

    public static void close() throws SQLException
    {
        dbConnection.close();
        System.out.println("Disconnected from the database.");
    }

    public static void patientToDb(String name, String sex, int hemoglobin)
    {
        try
        {
            PreparedStatement addPatient =
                    dbConnection.prepareStatement("INSERT INTO `clinic`.`patients` (`name`, `sex`, `hemoglobin`) VALUES (?, ?, ?)");
            addPatient.setString(1, name);
            addPatient.setString(2, sex);
            addPatient.setInt(3, hemoglobin);
            addPatient.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void diagnosesToDb(String therapistDia, String oculistDia, String surgeonDia, String labDia)
    {
        try
        {
            PreparedStatement addDiagnoses =
                    dbConnection.prepareStatement("INSERT INTO `clinic`.`diagnoses` (`therapist_diagnosis`, `oculist_diagnosis`, `surgeon_diagnosis`, `lab_diagnosis`) VALUES (?, ?, ?, ?)");
            addDiagnoses.setString(1, therapistDia);
            addDiagnoses.setString(2, oculistDia);
            addDiagnoses.setString(3, surgeonDia);
            addDiagnoses.setString(4, labDia);
            addDiagnoses.executeUpdate();

            PreparedStatement addDiagId =
                    dbConnection.prepareStatement("UPDATE patients SET patients.diagnosis_id = patients.id");
            addDiagId.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static int countDiagnosis(String doctor, String diagnosis)
    {
        int count = 0;
        try
        {
            PreparedStatement stmt =
                    dbConnection.prepareStatement("SELECT COUNT(d.id) FROM diagnoses AS d " +
                            "WHERE " + doctor + " = ?");
            stmt.setString(1, diagnosis);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return count;
    }

    public static int countCondStats(String doctor, String diagnosis, String patientSex)
    {
        int count = 0;
        try
        {
            PreparedStatement stmt =
                    dbConnection.prepareStatement("SELECT COUNT(p.name) FROM patients AS p JOIN diagnoses AS d on p.diagnosis_id = d.id " +
                            "WHERE " + doctor + " = ? AND sex = ?");
            stmt.setString(1, diagnosis);
            stmt.setString(2, patientSex);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return count;
    }
}