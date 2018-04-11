package jdbc

import java.sql.DriverManager
import java.sql.Connection

/**
 * A Scala JDBC connection example by Alvin Alexander,
 * http://alvinalexander.com
 */
object ScalaJdbcConnectSelect {

  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
   // val url = "jdbc:mysql://hostname/database_name"
    val url = "jdbc:mysql://custsql-ipg115.eigbox.net/scalapractise"
    val username = "pkshrestha"
    val password = "khaikkhaik123"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT host, user FROM user")
      while ( resultSet.next() ) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")
        println("host, user = " + host + ", " + user)
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }

}
