package net.harrysburrow.Security;

import javax.servlet.http.HttpServletRequest;

public class AntiBadRequest {

	// Key words that are forbidden from showing up in a request
	private static final String[] KEY_WORDS = {
		"drop","delete","add","select","*","and","or"
	};
	
	private static final String[] EXPLOITS = {
		"1=1","1=2"
	};
	
	/**
	 * Check if the current request is valid or legal
	 * @param request
	 * @return <code>true</code> if the request is legal
	 * 		   <code>false</code> if the request is illegal 
	 */
	public static boolean isLegalRequest(HttpServletRequest request){
		
		return !containKeyWords(request)&&!containExploits(request);
		
	}
	
	/**
	 * Check if the request contains mysql key words. If it does,
	 * the request is judged as dangerous and will be redirected
	 * to a different place.
	 * 
	 * @param request
	 * @return
	 */
	public static boolean containKeyWords(HttpServletRequest request){
		String args = request.getQueryString();
		if(args!=null){
			for(String key:KEY_WORDS){
				if(args.contains(key)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static boolean containExploits(HttpServletRequest request){
		String args = request.getQueryString();
		if(args!=null){
			for(String key:EXPLOITS){
				if(args.contains(key)){
					return true;
				}
			}
		}
		return false;
	}
	
}
