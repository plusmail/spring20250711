package kroryi.spring.mapper;

import kroryi.spring.dto.DepartmentDTO;
import kroryi.spring.dto.TitleDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {


    void insert(DepartmentDTO dto);

    DepartmentDTO get(Long code);

    int update(DepartmentDTO dto);

    int delete(Long code);


    @Results(id = "kroryi.spring.mapper.DepartmentMapper.ListMap", value = {
            @Result(id = true, column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            @Result(column = "floor", property = "floor")
    })


//    @Results({
//            @Result(id=true, column = "code", property = "code"),
//            @Result(column = "name", property = "name"),
//            @Result(column = "floor", property = "floor")
//    })
    @ResultMap("kroryi.spring.mapper.DepartmentMapper.ListMap")
    @Select("select code, name, floor from department")
    List<DepartmentDTO> getAll();

    @Select("select code, name, floor from department")
    @ResultMap("kroryi.spring.mapper.DepartmentMapper.ListMap")
    List<DepartmentDTO> getAll2();


    @Results(id = "DepartmentMap", value = {
            @Result(id = true, column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            @Result(column = "floor", property = "floor")
    })
    @Select("SELECT code, name,floor FROM department WHERE code = #{code}")
    List<DepartmentDTO> getDepartmentsByEmployee(Long code);

}
