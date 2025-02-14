package kroryi.spring.mapper;

import kroryi.spring.dto.EmployeeDTO;
import kroryi.spring.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> getList();
    EmployeeDTO select(Long eno);
    void insert(EmployeeDTO employee);
    int update(EmployeeDTO employee);
    EmployeeDTO getEmployeeWithTitleWithDepartment(Long eno);

    List<EmployeeDTO> getEmployeeAllWithTitleWithDepartment();


}
