import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexChecker {

	public static List<String> checker(String theRegex, String str2Check) throws SQLException{
        
		 java.util.List < String > divider = new LinkedList< String >(); // to store the matched parts
		
		// search for the pattern in the input string
        Pattern checkRegex = Pattern.compile(theRegex , Pattern.CASE_INSENSITIVE);
        
        // This matcher used to find any match for the pattern in the input string
	    Matcher regexMatcher = checkRegex.matcher( str2Check );
	         
	    while ( regexMatcher.find() ){
	        	
	        	String s = regexMatcher.group();   
	        	divider.add(s);
	    }
	   
	    return divider;
	 }
	
	
}
