package kroryi.spring.mapper;

import kroryi.spring.dto.TitleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TitleMapper {
    void insert(TitleDTO titleDTO);
    TitleDTO getTitle(Long code);
    int updateTitle(TitleDTO titleDTO);
    int deleteTitle(Long code);
    List<TitleDTO> getTitleAll();
    List<TitleDTO> selectTitleAll();

    List<TitleDTO> selectTitleByCode(Long code);
    List<TitleDTO> selectTitleByName(String name);


    @Results(id = "TitleMap", value = {
            @Result(id = true, column = "code", property = "code"),
            @Result(column = "name", property = "name")
    })
    @Select("SELECT code, name FROM title WHERE fk_eno=#{fk_eno}")
    List<TitleDTO> getTitlesByEmployee(int fk_eno);
}
