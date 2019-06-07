package com.kuldiegor.StringUtils;

public class StringUtils {
    public static String parse(String text,String begin,String end,Cursor cursor){
        int first = cursor.mValue;
        if (begin!=null && !begin.isEmpty()) {
            first = text.indexOf(begin, cursor.mValue);
            if (first==-1){
                return null;
            }
            first +=begin.length();
        }

        int last = text.length();
        if (end!=null && !end.isEmpty()){
            last=text.indexOf(end,first);
        }
        if (last==-1){
            return null;
        }
        cursor.mValue = last;
        return text.substring(first,last);
    }

    public static String parse(String text,String begin,String end){
        return parse(text,begin,end,new Cursor());

    }

    public static String smartParse(String text,String begin,String end,String repeatBegin,Cursor cursor){
       return smartParse(text,begin,end,repeatBegin,false,cursor);
    }

    public static String smartParse(String text,String begin,String end,String repeatBegin){
        return smartParse(text,begin,end,repeatBegin,false,new Cursor());
    }

    public static String smartParse(String text,String begin,String end,String repeatBegin,boolean isXml,Cursor cursor){
        int first = cursor.mValue;
        if (begin!=null && !begin.isEmpty()) {
            first = text.indexOf(begin, cursor.mValue);
            if (first==-1){
                return null;
            }
            first +=begin.length();
        }
        int last = text.length();
        if (end!=null && !end.isEmpty()) {
            last = text.indexOf(end, first);
            if (last==-1){
                return null;
            }
            int indRB = text.indexOf(repeatBegin, first);
            while (indRB >= 0 && indRB < last) {
                if (isXml){
                        int closeTagInd = text.indexOf(">",indRB);
                        if (text.charAt(closeTagInd-1)!='/'){
                            last = text.indexOf(end, last + 1);
                        }
                } else {
                    last = text.indexOf(end, last + 1);
                }
                indRB = text.indexOf(repeatBegin, indRB+1);
            }
        }
        if (last==-1){
            return null;
        }
        cursor.mValue = last;
        return text.substring(first,last);
    }

    public static String smartParse(String text,String begin,String end,String repeatBegin,boolean isXml){
        return smartParse(text,begin,end,repeatBegin,isXml,new Cursor());
    }
}
