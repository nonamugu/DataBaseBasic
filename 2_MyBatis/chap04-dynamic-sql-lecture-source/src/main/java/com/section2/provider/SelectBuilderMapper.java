package com.section2.provider;

import com.common.MenuDTO;
import com.common.SearchCriteria;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SelectBuilderMapper {

    @Results(id="menuResultMap", value = {
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS"),
    })

    @SelectProvider(type=SelectBuilderProvider.class, method="selectAllMenu")
    List<MenuDTO> selectAllMenu();

    @ResultMap("menuResultMap")
    @SelectProvider(type=SelectBuilderProvider.class, method="searchMenuByCondition")
    List<MenuDTO> searchMenuByCondition(SearchCriteria searchCriteria);

}

