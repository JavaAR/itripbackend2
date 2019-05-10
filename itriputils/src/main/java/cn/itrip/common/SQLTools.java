package cn.itrip.common;
/**
 * mybatis 防sql注入类 SQLTools
 * @author bdqn_hl
 * @date 2013-3-19
 *
 */
public class SQLTools {
	/**
	 * mybatis模糊查询防止sql注入
	 * @param keyword
	 * @return
	 */
	public static String transfer(String keyword) { 
		
        if(keyword.contains("%") || keyword.contains("_")){  
        	//JDK1.6
            keyword = keyword.replaceAll("\\\\", "\\\\\\\\")  
                             .replaceAll("\\%", "\\\\%")  
                             .replaceAll("\\_", "\\\\_"); 
            
            /*//JDK1.6以上版本
            keyword = keyword.replaceAll("\\\\", "\\\\\\\\")
			            .replaceAll("\\%", "\\\\%")  
			            .replaceAll("\\_", "\\\\_"); 
            //*/
        } 
        return keyword; 
    } 
}
