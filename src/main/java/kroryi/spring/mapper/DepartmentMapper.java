package kroryi.spring.mapper;

import kroryi.spring.dto.DepartmentDTO;
import kroryi.spring.dto.TitleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    void insert(DepartmentDTO dto);
    DepartmentDTO get(Long code);
    int update(DepartmentDTO dto);
    int delete(Long code);
    List<DepartmentDTO> getAll();
}
