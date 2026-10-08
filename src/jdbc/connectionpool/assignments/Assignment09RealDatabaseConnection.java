package jdbc.connectionpool.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Assignment09RealDatabaseConnection {
    public static void main(String[] args) throws SQLException, IOException {
        Properties configuration = loadConfiguration();
        String jdbcUrl = requiredSetting(configuration, "JDBC_URL");
        String username = requiredSetting(configuration, "DB_USERNAME");
        String password = setting(configuration, "DB_PASSWORD", "");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to: " + connection.getMetaData().getDatabaseProductName());
            createBankTables(connection);
            insertSampleBankData(connection);
            displayAccounts(connection);
        }
    }

    private static void createBankTables(Connection connection) throws SQLException {
        String[] tableDefinitions = {
                "CREATE TABLE IF NOT EXISTS bank_customers ("
                        + "customer_id INT PRIMARY KEY, "
                        + "full_name VARCHAR(100) NOT NULL, "
                        + "email VARCHAR(150) NOT NULL UNIQUE, "
                        + "phone VARCHAR(20) NOT NULL"
                        + ")",
                "CREATE TABLE IF NOT EXISTS bank_accounts ("
                        + "account_id VARCHAR(20) PRIMARY KEY, "
                        + "customer_id INT NOT NULL, "
                        + "account_type VARCHAR(20) NOT NULL, "
                        + "balance DECIMAL(12, 2) NOT NULL, "
                        + "opened_on DATE NOT NULL, "
                        + "CONSTRAINT fk_bank_accounts_customer "
                        + "FOREIGN KEY (customer_id) REFERENCES bank_customers(customer_id), "
                        + "CONSTRAINT chk_bank_accounts_balance CHECK (balance >= 0)"
                        + ")",
        };
        try (Statement statement = connection.createStatement()) {
            for (String definition : tableDefinitions) {
                statement.executeUpdate(definition);
            }
            System.out.println("Bank tables are ready: bank_customers and bank_accounts.");
        }
    }

    private static void insertSampleBankData(Connection connection) throws SQLException {
        boolean originalAutoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try {
            insertCustomers(connection);
            insertAccounts(connection);
            connection.commit();
            System.out.println("Sample bank data inserted or updated successfully.");
        } catch (SQLException exception) {
            connection.rollback();
            throw exception;
        } finally {
            connection.setAutoCommit(originalAutoCommit);
        }
    }

    private static void insertCustomers(Connection connection) throws SQLException {
        String sql = "INSERT INTO bank_customers (customer_id, full_name, email, phone) "
                + "VALUES (?, ?, ?, ?) AS new "
                + "ON DUPLICATE KEY UPDATE full_name = new.full_name, "
                + "email = new.email, phone = new.phone";
        String[][] customers = {
                {"1", "Darshan", "darshan@example.test", "555-0101"},
                {"2", "Harshitha", "harshitha@example.test", "555-0102"},
                {"3", "Rahul", "rahul@example.test", "555-0103"},
                {"4", "Priya", "priya@example.test", "555-0104"},
                {"5", "Sai", "sai@example.test", "555-0105"},
                {"6", "Suresh", "suresh@example.test", "555-0106"},
                {"7", "Ananya", "ananya@example.test", "555-0107"},
                {"8", "Arjun", "arjun@example.test", "555-0108"},
                {"9", "Aadhya", "aadhya@example.test", "555-0109"},
                {"10", "Rohan", "rohan@example.test", "555-0110"},
                {"11", "Kavya", "kavya@example.test", "555-0111"},
                {"12", "Vikram", "vikram@example.test", "555-0112"},
                {"13", "Neha", "neha@example.test", "555-0113"},
                {"14", "Aditya", "aditya@example.test", "555-0114"},
                {"15", "Meera", "meera@example.test", "555-0115"},
                {"16", "Karthik", "karthik@example.test", "555-0116"},
                {"17", "Isha", "isha@example.test", "555-0117"},
                {"18", "Sanjay", "sanjay@example.test", "555-0118"},
                {"19", "Pooja", "pooja@example.test", "555-0119"},
                {"20", "Nikhil", "nikhil@example.test", "555-0120"}
        };

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (String[] customer : customers) {
                statement.setInt(1, Integer.parseInt(customer[0]));
                statement.setString(2, customer[1]);
                statement.setString(3, customer[2]);
                statement.setString(4, customer[3]);
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    private static void insertAccounts(Connection connection) throws SQLException {
        String sql = "INSERT INTO bank_accounts "
                + "(account_id, customer_id, account_type, balance, opened_on) "
                + "VALUES (?, ?, ?, ?, ?) AS new "
                + "ON DUPLICATE KEY UPDATE customer_id = new.customer_id, "
                + "account_type = new.account_type, balance = new.balance, opened_on = new.opened_on";
        String[][] accounts = {
                {"ACC1001", "1", "SAVINGS", "42500.00", "2023-04-15"},
                {"ACC1002", "2", "CURRENT", "120000.00", "2022-11-03"},
                {"ACC1003", "3", "SAVINGS", "68500.00", "2023-01-20"},
                {"ACC1004", "4", "SAVINGS", "93200.00", "2021-08-11"},
                {"ACC1005", "5", "CURRENT", "51000.00", "2024-02-05"},
                {"ACC1006", "6", "SAVINGS", "77500.00", "2020-06-18"},
                {"ACC1007", "7", "SAVINGS", "118000.00", "2022-03-22"},
                {"ACC1008", "8", "CURRENT", "64000.00", "2021-12-09"},
                {"ACC1009", "9", "SAVINGS", "89500.00", "2024-05-13"},
                {"ACC1010", "10", "SAVINGS", "73000.00", "2023-09-27"},
                {"ACC1011", "11", "CURRENT", "156000.00", "2020-10-14"},
                {"ACC1012", "12", "SAVINGS", "102500.00", "2019-07-30"},
                {"ACC1013", "13", "SAVINGS", "58500.00", "2022-01-17"},
                {"ACC1014", "14", "CURRENT", "132000.00", "2021-04-06"},
                {"ACC1015", "15", "SAVINGS", "97000.00", "2023-11-19"},
                {"ACC1016", "16", "SAVINGS", "81500.00", "2020-02-24"},
                {"ACC1017", "17", "CURRENT", "69500.00", "2024-01-08"},
                {"ACC1018", "18", "SAVINGS", "143000.00", "2019-05-16"},
                {"ACC1019", "19", "SAVINGS", "90500.00", "2022-12-01"},
                {"ACC1020", "20", "CURRENT", "110000.00", "2023-07-12"}
        };

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (String[] account : accounts) {
                statement.setString(1, account[0]);
                statement.setInt(2, Integer.parseInt(account[1]));
                statement.setString(3, account[2]);
                statement.setBigDecimal(4, new java.math.BigDecimal(account[3]));
                statement.setDate(5, java.sql.Date.valueOf(account[4]));
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    private static void displayAccounts(Connection connection) throws SQLException {
        String sql = "SELECT a.account_id, c.full_name, a.account_type, a.balance, a.opened_on "
                + "FROM bank_accounts a "
                + "JOIN bank_customers c ON c.customer_id = a.customer_id "
                + "ORDER BY a.account_id";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Bank accounts:");
            while (resultSet.next()) {
                System.out.printf("%s | %s | %s | balance %s | opened %s%n",
                        resultSet.getString("account_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("account_type"),
                        "INR " + resultSet.getBigDecimal("balance"),
                        resultSet.getDate("opened_on"));
            }
        }
    }

    private static Properties loadConfiguration() throws IOException {
        Properties configuration = new Properties();
        Path envFile = Paths.get(".env");

        if (Files.exists(envFile)) {
            try (Reader reader = Files.newBufferedReader(envFile, StandardCharsets.UTF_8)) {
                configuration.load(reader);
            }
        }

        return configuration;
    }

    private static String requiredSetting(Properties configuration, String name) {
        String value = setting(configuration, name, null);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Set " + name + " in the project-root .env file or as an environment variable.");
        }
        return value;
    }

    private static String setting(Properties configuration, String name, String defaultValue) {
        String environmentValue = System.getenv(name);
        if (environmentValue != null) {
            return environmentValue;
        }
        return configuration.getProperty(name, defaultValue);
    }
}
