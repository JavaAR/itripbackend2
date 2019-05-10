package cn.itrip.common;
/**
 * HtmlEncode防js注入公共类
 * @author bdqn_hl
 * @date 2014-3-21
 */
public class HtmlEncode {
	public static String htmlEncode(String string) {
		if(null == string || "".equals(string))
			return null;
		else{
			String result = string;
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
			return (result.toString());
		}
	}
	public static String htmlDecode(String string) {
		if(null == string || "".equals(string))
			return null;
		else{
			String result = string;
			result = result.replaceAll("&amp;", "&");
			result = result.replaceAll("&lt;", "<");
			result = result.replaceAll("&gt;", ">");
			result = result.replaceAll("&quot;", "\"");
			return (result.toString());
		}
	}
	
	/*public static void main(String[] args) {
		System.out.println(HtmlEncode.htmlEncode("<script>alert(\"123\");</script>&nbsp;&nbsp;"));
		System.out.println(HtmlEncode.htmlDecode("&lt;script&gt;alert(&quot;123&quot;);&lt;/script&gt;&amp;nbsp;&amp;nbsp;"));
	}*/
}