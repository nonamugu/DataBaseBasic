package com.section2.provider;

import com.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {

    public String selectAllMenu() {
        return new SQL()
                .SELECT("MENU_CODE")
                .SELECT("MENU_NAME")
                .SELECT("MENU_PRICE")
                .SELECT("CATEGORY_CODE")
                .SELECT("ORDERABLE_STATUS")
                .FROM("TBL_MENU")
                .WHERE("ORDERABLE_STATUS = 'y'").toString();
    }

    public String searchMenuByCondition(SearchCriteria searchCriteria) {
        SQL sql = new SQL();
        sql.SELECT("A.MENU_CODE")
                .SELECT("A.MENU_NAME")
                .SELECT("A.MENU_PRICE")
                .SELECT("A.CATEGORY_CODE")
                .SELECT("A.ORDERABLE_STATUS")
                .FROM("TBL_MENU A");

        if("category".equals(searchCriteria.getCondition())) {
            sql.JOIN("TBL_CATEGORY B ON (A.CATEGORY_CODE = B.CATEGORY_CODE)")
                    .WHERE("A.ORDERABLE_STATUS = 'Y'")
                    .AND()
                    .WHERE("B.CATEGORY_NAME = #{ value }");
        } else if("name".equals(searchCriteria.getCondition())) {
            sql.WHERE("A.ORDERABLE_STATUS = 'Y'"
                            ,"A.MENU_NAME LIKE CONCAT('%', #{ value }, '%')");
        }

        return sql.toString();
    }

}
