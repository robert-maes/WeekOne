package com.smoothstack.evaluation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

/**
 * @author Rob Maes
 * Sun Feb 28 2021
 */
public class SampleSingleton { // remove static modifier from class definition here

  private static Connection conn = null;
  // make instance volatile for thread safety
  private static volatile SampleSingleton instance = null;

  public static SampleSingleton getInstance() {
    // if the instance is null, create one, otherwise return existing instance
    if (instance == null) {
      // synchronize for thread safety
      synchronized (SampleSingleton.class) {
        // check again now that the thread is locked
        if (instance == null) {
          // handle SQLException from initializing conn
          try {
            instance = new SampleSingleton();
          } catch (SQLException e) {
            instance = null;
            return null;
          }
        }
      }
    }
    return instance;
  }

  // create private constructor to prevent creating objects elsewhere
  private SampleSingleton() throws SQLException {
    // initialize the conn once to prevent redundant objects
    conn = DriverManager.getConnection("url of database");
  }

  // throw SQLException, it is better handled in the calling code
  public static void databaseQuery(BigDecimal input) throws SQLException {
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select id from table");
    // change x from int to BigInt
    BigInteger x;
    while (rs.next()) {
      // change math to support BigInt and BigDecimal, should not convert from BigDecimal to double
      x = input.multiply(BigDecimal.valueOf(rs.getInt(1))).toBigInteger();
    }
  }
}
