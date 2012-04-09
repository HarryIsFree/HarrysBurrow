package net.harrysburrow.DAO;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import net.harrysburrow.Bean.Blog;

public class BurrowDAO {

	private java.sql.Connection connection;
	
	private static final String DB_URL     = "jdbc:mysql://204.12.204.103:3306/myburrow?user=root&password=qet123ZXC";
	
	// The table burrow_log and its collumes.
	private static final String TABLE_LOG    		= "burrow_log";
	//private static final String TABLE_LOG_ID 		= "id";
	private static final String TABLE_LOG_IP 		= "ip";
	private static final String TABLE_LOG_REQUEST	= "request";
	private static final String TABLE_LOG_TIME		= "rtime";
	private static final String TABLE_LOG_HOST      = "rhost";
	
	// The table burrow_stats and its collumns
	private static final String TABLE_STATS 		= "burrow_stats";
	private static final String TABLE_STATS_ID 		= "id";
	private static final String TABLE_STATS_VIEWS 	= "views";
	
	private static final String INSERT_LOG = "INSERT INTO " + TABLE_LOG + " ( " 
															+ TABLE_LOG_IP + " , " 
															+ TABLE_LOG_REQUEST + " , "
															+ TABLE_LOG_TIME + " , "
															+ TABLE_LOG_HOST + " ) VALUES (?,?,?,?)";
	
	private static final String GET_VIEW   = "SELECT " + TABLE_STATS_VIEWS + " FROM " + TABLE_STATS + " WHERE " + TABLE_STATS_ID + " = 1";
	private static final String ADD_VIEW   = "UPDATE " + TABLE_STATS + " SET " + TABLE_STATS_VIEWS + " = ? WHERE " + TABLE_STATS_ID + " = 1";
	
	private static final String TABLE_BLOG 				= "burrow_blog";
	private static final String TABLE_BLOG_ID			= "id";
	private static final String TABLE_BLOG_TITLE		= "title";
	private static final String TABLE_BLOG_CONTENT		= "content";
	private static final String TABLE_BLOG_TIME			= "ptime";
	private static final String TABLE_BLOG_DIGEST		= "digest";
	private static final String GET_BLOGS			= "SELECT * FROM " + TABLE_BLOG;
	//private static final String GET_BLOG			= "SELECT * FROM " + TABLE_BLOG + " WHERE " 
	
	
	public BurrowDAO(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(DB_URL);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Create a log for a request, log the time, content and ip of the request.
	 * @param request The HttpServletRequest sent by user
	 */
	public void log(HttpServletRequest request){
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_LOG);
			ps.setString(1, request.getRemoteAddr());
			ps.setString(2, request.getRequestURI()+request.getQueryString());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setString(4, request.getRemoteHost());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Add a page view to the database
	 */
	public void addView(){
		try {
			PreparedStatement ps = connection.prepareStatement(GET_VIEW);
			ResultSet rs = ps.executeQuery();
			int views = 0;
			if(rs.next()){
				views = rs.getInt(1);
			}
			ps = connection.prepareStatement(ADD_VIEW);
			ps.setInt(1, views+1);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Blog> getBlogs(){
		
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_BLOGS);
			while(rs.next()){
				Blog b = new Blog();
				b.setID(rs.getInt(TABLE_BLOG_ID));
				b.setTitle(rs.getString(TABLE_BLOG_TITLE));
				b.setContent(rs.getString(TABLE_BLOG_CONTENT));
				b.setDate(rs.getDate(TABLE_BLOG_TIME));
				b.setDigest(rs.getString(TABLE_BLOG_DIGEST));
				blogs.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return blogs;
		
	}
}
