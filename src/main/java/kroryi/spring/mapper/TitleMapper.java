package kroryi.spring.mapper;

import kroryi.spring.dto.TitleDTO;
import org.apache.ibatis.annotations.Mapper;
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
}
