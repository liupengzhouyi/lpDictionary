package lpDictionary;

import java.sql.*;

public class CreateDictionary  extends LinkDatabase{

    public CreateDictionary() {
        this.set_lpInstructions(sqlString);
    }

    @Override
    public void linkMySQlDatabase() {
        try {
            Class.forName(this.get_lpDataBaseDriver());

            this._lpDatabase_Link = DriverManager.getConnection(this.get_lpDataBaseAddress(),
                    this.get_lpUserName(), this.get_lpPassWord());

            Connection temp = this.get_lpDatabase_Link() ;

            this.set_lpDataBase_Stmt(this.get_lpDatabase_Link().createStatement());

            this.lpPalyMySQLInstructionsI();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CloseDatabase() {

        if (this.get_lpDatabaseResultSet() != null) {
            try {
                this.get_lpDatabaseResultSet().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ;
        }

        if ( this.get_lpDataBase_Stmt() != null) {
            try {
                this.get_lpDataBase_Stmt().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ;
        }
    }

    @Override
    public void lpPalyMySQLInstructionsI() {

        try {
            String sql = this.get_lpInstructions() ;

            this._lpDataBase_Stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lpPalyMySQLInstructionsII() {

    }

    public String get_lpInstructions() {
        return _lpInstructions;
    }

    public void set_lpInstructions(String _lpInstructions) {
        this._lpInstructions = _lpInstructions;
    }

    public String get_lpDataBaseDriver() {
        return _lpDataBaseDriver;
    }

    public void set_lpDataBaseDriver(String _lpDataBaseDriver) {
        this._lpDataBaseDriver = _lpDataBaseDriver;
    }

    public String get_lpDataBaseAddress() {
        return _lpDataBaseAddress;
    }

    public void set_lpDataBaseAddress(String _lpDataBaseAddress) {
        this._lpDataBaseAddress = _lpDataBaseAddress;
    }

    public Connection get_lpDatabase_Link() {
        return _lpDatabase_Link;
    }

    public void set_lpDatabase_Link(Connection _lpDatabase_Link) {
        this._lpDatabase_Link = _lpDatabase_Link;
    }

    public Statement get_lpDataBase_Stmt() {
        return _lpDataBase_Stmt;
    }

    public void set_lpDataBase_Stmt(Statement _lpDataBase_Stmt) {
        this._lpDataBase_Stmt = _lpDataBase_Stmt;
    }

    public ResultSet get_lpDatabaseResultSet() {
        return _lpDatabaseResultSet;
    }

    public void set_lpDatabaseResultSet(ResultSet _lpDatabaseResultSet) {
        this._lpDatabaseResultSet = _lpDatabaseResultSet;
    }

    private ResultSet _lpDatabaseResultSet ;
    private Statement _lpDataBase_Stmt;
    private String _lpInstructions ;
    private String _lpDataBaseDriver ;
    private String _lpDataBaseAddress ;
    private Connection _lpDatabase_Link;

    private String sqlString  = "CREATE TABLE liupeng_english_dictionary03("
            + "lp_word_id                   INT(10)         PRIMARY KEY     AUTO_INCREMENT, "
            + "lp_word_name                 VARCHAR(50)     NOT NULL, "
            + "lp_word_translation          VARCHAR(50)     NOT NULL"
            + ");";
}
