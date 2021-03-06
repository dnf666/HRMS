package com.mis.hrm.web.util;

import com.mis.hrm.book.po.Book;
import com.mis.hrm.project.po.Project;
import com.mis.hrm.util.ToMap;
import com.mis.hrm.util.exception.InfoNotFullyException;

import java.util.Map;

public class ControllerUtil {
    private ControllerUtil(){}

    public static Map<String, Object> getResult(BookUpdateMethod bookUpdateMethod, Book book){
        Map<String, Object> result;
        try {
            result = ToMap.toSuccessMap(bookUpdateMethod.getEffectCount(book));
        } catch (NullPointerException n){
            result = ToMap.toFalseMap(n.getMessage());
        } catch (InfoNotFullyException inf){
            result = ToMap.toFalseMap(inf.getMessage());
        } catch (Exception e){
            result = ToMap.toFalseMapByServerError();
        }
        return result;
    }

    public static Map<String, Object> getResult(ProjectUpdateMethod projectUpdateMethod, Project project){
        Map<String, Object> result;
        try {
            result = ToMap.toSuccessMap(projectUpdateMethod.getEffectCount(project));
        } catch (NullPointerException n){
            result = ToMap.toFalseMap(n.getMessage());
        } catch (InfoNotFullyException inf){
            result = ToMap.toFalseMap(inf.getMessage());
        } catch (Exception e){
            result = ToMap.toFalseMapByServerError();
        }
        return result;
    }
}
