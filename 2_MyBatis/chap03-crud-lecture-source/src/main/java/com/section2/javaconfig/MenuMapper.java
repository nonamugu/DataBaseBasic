package com.section2.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id="menuResultMap", value={
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS"),
    })

    @Select("SELECT \n" +
            "   MENU_CODE \n" +
            "   ,MENU_NAME \n" +
            "   ,MENU_PRICE \n" +
            "   ,CATEGORY_CODE \n" +
            "   ,ORDERABLE_STATUS \n" +
            "FROM TBL_MENU \n" +
            "WHERE ORDERABLE_STATUS = 'Y' \n" +
            "ORDER BY MENU_CODE"
    )
    List<MenuDTO> selectAllMenu();

    @Select("SELECT \n" +
            "   MENU_CODE \n" +
            "   ,MENU_NAME \n" +
            "   ,MENU_PRICE \n" +
            "   ,CATEGORY_CODE \n" +
            "   ,ORDERABLE_STATUS \n" +
            "FROM TBL_MENU \n" +
            "WHERE ORDERABLE_STATUS = 'y' \n" +
            "  AND MENU_CODE = #{ code }"
    )
    MenuDTO selectMenuByCode(int code);

    @Insert("INSERT \n" +
            "   INTO TBL_MENU \n" +
            "   ( \n" +
            "   MENU_NAME \n" +
            "   ,MENU_PRICE \n" +
            "   ,CATEGORY_CODE \n" +
            "   ,ORDERABLE_STATUS \n" +
            "   ) \n" +
            "   VALUES \n" +
            "   ( \n" +
            "       #{ name } \n" +
            "       #{ price } \n" +
            "       #{ categoryCode } \n" +
            "       'y' \n" +
            "   )"
    )
    int insertMenu(MenuDTO menu);


    @Update("UPDATE \n" +
            "   TBL_MENU \n" +
            "SET MENU_NAME = #{ name } \n" +
            "    ,MENU_PRICE = #{ price } \n" +
            "    ,CATEGORY_CODE = #{ categoryCode } \n" +
            "WHERE MENU_CODE = #{ code }"
    )
    int updateMenu(MenuDTO menu);

    @Delete("DELETE \n" +
            "   FROM TBL_MENU \n" +
            "WHERE MENU_CODE = #{ code }"
    )
    int deleteMenu(int code);
}
