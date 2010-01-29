import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseExportSample {


	public static void main(String[] args) throws Exception {
		// database connection
		Class driverClass = Class.forName("org.postgresql.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		System.setProperty("user.dir", System.getProperty("user.dir")+"/simple-unittest/src/test/resources/");
		String outputPath = System.getProperty("user.dir");
		System.out.println("Write File here : "+ outputPath );

		// partial database export
		QueryDataSet partialDataSet = new QueryDataSet(connection);
		partialDataSet.addTable("member");
		FlatXmlDataSet.write(partialDataSet, new FileOutputStream(outputPath+"export.xml"));

		// full database export
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream(outputPath+"full.xml"));

		// dependent tables database export: export table X and all tables that
		// have a PK which is a FK on X, in the right order for insertion
		String[] depTableNames = TablesDependencyHelper.getAllDependentTables(connection, "member");
		IDataSet depDataset = connection.createDataSet(depTableNames);
		FlatXmlDataSet.write(depDataset, new FileOutputStream(outputPath+"dependents.xml"));

	}
}
     