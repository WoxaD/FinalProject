package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {

    private static final QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var statusOfCreditSQL = "SELECT status FROM credit_request_entity WHERE last_insert_id(id);";
        String result;
        try (
                var conn = getConn()
        ) {
            result = runner.query(conn, statusOfCreditSQL, new ScalarHandler<>());
        }
        return result;
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var statusOfPaymentSQL = "SELECT status FROM payment_entity WHERE last_insert_id(id);";
        String result;
        try (
                var conn = getConn()
        ) {
            result = runner.query(conn, statusOfPaymentSQL, new ScalarHandler<>());
        }
        return result;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConn();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM order_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
    }
}
