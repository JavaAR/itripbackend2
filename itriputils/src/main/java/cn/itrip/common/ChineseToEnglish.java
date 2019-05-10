package cn.itrip.common;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.log4j.Logger;

/**
 * 汉字转拼音的工具类
 */
public class ChineseToEnglish {

    static Logger logger=Logger.getLogger(ChineseToEnglish.class);

    public static String getPinYin(String word){
        char c=word.charAt(0);
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
        logger.info("word:"+word+" pingyin:"+pinyinArray[0].substring(0,pinyinArray[0].length()-1));
        return  pinyinArray[0].substring(0,pinyinArray[0].length()-1);
    }

    public static void main(String args[]){
        String result=getPinYin("北京");
    }
}