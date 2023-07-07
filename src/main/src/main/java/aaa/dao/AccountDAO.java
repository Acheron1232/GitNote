package aaa.dao;



import aaa.entity.Account;
import aaa.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
    private static final AccountDAO INSTANCE = new AccountDAO();
    private static final String DELETE_SQL = """
            delete from my_application.public.account where id = ? ;""";
    private static final String SAVE_SQL = """
            insert into my_application.public.account ( name , date_registration) values (?,?); """;

    private AccountDAO() {
    }

    public static AccountDAO getInstance() {
        return INSTANCE;
    }

    public boolean delete(Integer id) {
        try (var open = ConnectionUtil.open();
             var statement = open.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void save(Account account) {
        try (var open = ConnectionUtil.open();
             var statement = open.prepareStatement(SAVE_SQL)) {
                statement.setString(1,account.getName());
                statement.setDate(2, account.getDate_registration());
                statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
