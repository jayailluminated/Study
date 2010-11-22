package dbunit;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Simple test using the WicketTester
 */
public class DBUnitTest {

	static IDatabaseConnection conn;
	static IDataSet data;
	private static IDataSet dataSet;

	@BeforeClass
	public static void setUpOnce() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException {
		conn = getConnection();
		data = getDataSet();


		DatabaseOperation.REFRESH.execute(conn, data);

	}


	private static IDatabaseConnection getConnection() throws ClassNotFoundException, SQLException, DatabaseUnitException {
		Class driverClass = Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");
		return new DatabaseConnection(connection);
	}

	public static IDataSet getDataSet() throws DataSetException, FileNotFoundException {
		System.setProperty("user.dir", System.getProperty("user.dir") + "/simple-unittest/src/test/resources/");
		String outputPath = System.getProperty("user.dir");
		return new FlatXmlDataSetBuilder().build(new FileInputStream(outputPath + "full.xml"));
	}

	@AfterClass
	public static void tearDownOnce() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	@Test
	public void testCompareDataSet() throws DatabaseUnitException, MalformedURLException, SQLException, ClassNotFoundException {

		// Fetch database data after executing your code
		IDataSet databaseDataSet = conn.createDataSet();
		ITable actualTable = databaseDataSet.getTable("member");


		// Load expected data from an XML dataset
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("expectedDataSet.xml"));
		ITable expectedTable = expectedDataSet.getTable("member");

		Assertion.assertEquals(expectedTable, actualTable);
	}

	@Test
	public void testCompareDataSetGetByQuery() throws SQLException, DatabaseUnitException, MalformedURLException {
		ITable actualTable = conn.createQueryTable("member", "select * from member");

		// Load expected data from an XML dataset
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("expectedDataSet.xml"));
		ITable expectedTable = expectedDataSet.getTable("member");

		Assertion.assertEquals(expectedTable, actualTable);
	}
}
