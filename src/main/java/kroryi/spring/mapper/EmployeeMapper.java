package kroryi.spring.mapper;

import kroryi.spring.dto.EmployeeDTO;
import kroryi.spring.dto.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> getList();
    EmployeeDTO select(Long eno);
    void insert(EmployeeDTO employee);
    int update(EmployeeDTO employee);
    EmployeeDTO getEmployeeWithTitleWithDepartment(Long eno);

    List<EmployeeDTO> getEmployeeAllWithTitleWithDepartment1();


    // 단점은 : 소스에 쿼리문이 내장이 되어 있어서 컴파일 된 후 수정이 어렵다.
    @Results(id = "kroryi.spring.mapper.EmployeeMapper.ListMap", value = {
            @Result(id = true, column = "eno", property = "eno"),
            @Result(column = "ename", property = "ename"),
            @Result(column = "salary", property = "salary"),
            @Result(column = "joinDate", property = "joinDate"),

            // Department 관계 매핑 (1:1)
            @Result(property = "fk_department", column = "department_code",
                    one = @One(select = "kroryi.spring.mapper.DepartmentMapper.getDepartmentsByEmployee")),

            // Title 관계 매핑 (1:N)
            @Result(property = "fk_title", column = "title_code",
                    many = @Many(select = "kroryi.spring.mapper.TitleMapper.getTitlesByEmployee"))
    })
    @Select("        select e.eno ,\n" +
            "               e.ename,\n" +
            "               e.salary,\n" +
            "               e.gender,\n" +
            "               e.joinDate,\n" +
            "               d.code  as department_code,\n" +
            "               d.name  as department_name,\n" +
            "               d.floor as department_floor,\n" +
            "               t.code  as title_code,\n" +
            "               t.name  as title_name\n" +
            "        from employee e\n" +
            "                 left join department d on e.fk_department = d.code\n" +
            "                 left join title t on e.fk_title = t.fk_eno")
    List<EmployeeDTO> getEmployeeAllWithTitleWithDepartment2();


}
