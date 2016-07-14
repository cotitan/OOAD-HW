package tickets;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ImportTheater {
	private String fileName;
	private static Connection dbmsConn = DBMSOperation.getDBConnection();
	
	public static void main(String[] args) {
		ImportTheater iTheater = new ImportTheater();
		iTheater.ImportDataToSql();
		iTheater.readData();
	}
	
	public ImportTheater() {
		fileName = "附近的电影院.txt";
	}

	/*public void readData() {
		String query = "select movieName from movie where idx = 1";
		try {
			PreparedStatement sql = dbmsConn.prepareStatement(query);
			ResultSet res = sql.executeQuery();
			String movieName;
			while (res.next()) {
				movieName = res.getString("movieName");
				System.out.println(movieName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void ImportDataToSql() {
		try {
			File file = new File(fileName);
			if (file.isFile() && file.exists()) {
				InputStreamReader reader = new InputStreamReader(
					new FileInputStream(file), "UTF8");
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line;
				String[] strs;
				while ((line = bufferedReader.readLine()) != null) {
					strs = line.split("\t");
				 	try {
						PreparedStatement sql = dbmsConn.prepareStatement(
							"insert into movie values(?,?,?,?,?,?,?,?,?,?,?,?)");
						sql.setInt(1, Integer.parseInt(strs[0]));
						sql.setString(2, strs[1]);
						sql.setString(3, strs[2]);
						sql.setString(4, strs[3]);
						sql.setDouble(5, Double.parseDouble(strs[4]));
						sql.setDouble(6, Double.parseDouble(strs[5]));
						sql.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				reader.close();
			} else {
				System.out.println("file can't be found!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

