package tickets;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ImportMovie {
	private String fileName;
	private static Connection dbmsConn = DBMSOperation.getDBConnection();
	
	public static void main(String[] args) {
		ImportMovie iMovie = new ImportMovie();
		iMovie.ImportDataToSql();
		iMovie.readData();
	}
	
	public ImportMovie() {
		fileName = "movie.txt";
	}

	public void readData() {
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
	}

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
							"insert into movie values(?,?,?,?,?,?,?,?,?)");
						sql.setInt(1, Integer.parseInt(strs[0]));
						sql.setString(2, strs[1]);
						sql.setString(3, strs[2]);
						sql.setInt(4, Integer.parseInt(strs[3]));
						sql.setDouble(5, Double.parseDouble(strs[4]));
						sql.setString(6, strs[5]);
						sql.setString(7, strs[6]);
						sql.setString(8, strs[7]);
						sql.setString(9, strs[8]);
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

