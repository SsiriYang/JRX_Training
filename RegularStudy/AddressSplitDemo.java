package com.codeyang.jrxtraining.RegularStudy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 41765
 * @Creater 2020/5/21 21:11
 * Description
 * 使用正则表达式提取：国家，省份，城市，区，街道，门号
 * 中华人民共和国吉林省长春市二道区临河街万兴小区4栋2门
 */
public class AddressSplitDemo {
    public static void main(String[] args) {
        System.out.println(addressResolution("中华人民共和国吉林省长春市二道区临河街万兴小区4栋2门"));
    }
    /**
     * @Description //TODO
     * @Date 21:53 2020/5/21
     * @Param String 地址字符串，格式是国家，省份，城市，区，街道，门号
     * @return List<Map<String,String>> 保证插入有序
     **/
    public static List<Map<String,String>> addressResolution(String address){
        String regex="((?<country>[^国]+国)(?<province>[^省]*?省)(?<city>[^市]+市)(?<Area>[^区]+区)(?<street>[^街]+街)(?<DoorNumber>[^栋]+栋))";
        //Pattern，正则表达式的编译表示，操作字符序列的利器。
        //整个Pattern是一个树形结构(对应于表达式中的‘|’)，一般为链表结构，树(链表)的基本元素是Node结点，Node有各种各样的子结点，以满足不同的匹配模式。
        Matcher m= Pattern.compile(regex).matcher(address);
        String country=null, province=null,city=null,Area=null,street=null,DoorNumber=null;
        List<Map<String,String>> res=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            country=m.group("country");
            row.put("country", country==null?"":country.trim());
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            Area=m.group("Area");
            row.put("Area", Area==null?"":Area.trim());
            street=m.group("street");
            row.put("street", street==null?"":street.trim());
            DoorNumber=m.group("DoorNumber");
            row.put("DoorNumber", DoorNumber==null?"":DoorNumber);
            res.add(row);
        }
        return res;
    }
}
