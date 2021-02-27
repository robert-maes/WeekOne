package com.smoothstack.evaluation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

//todo: unsure
public class Singleton {

  private static Connection conn = null;
  private static Singleton instance = null;

  public static Singleton getInstance() {
    if (instance == null) {
      try {
        instance = new Singleton();
      } catch (SQLException e) {
        instance = null;
        return null;
      }
    }
    return instance;
  }

  private Singleton() throws SQLException {
    conn = DriverManager.getConnection("url of database");
  }

  public static void databaseQuery(BigDecimal input) throws SQLException {
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select id from table");
    BigInteger x;
    while (rs.next()) {
      x = input.multiply(BigDecimal.valueOf(rs.getInt(1))).toBigInteger();
    }
  }
}
