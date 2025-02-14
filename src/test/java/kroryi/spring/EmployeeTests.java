package kroryi.spring;


import kroryi.spring.dto.DepartmentDTO;
import kroryi.spring.dto.EmployeeDTO;
import kroryi.spring.dto.TitleDTO;
import kroryi.spring.mapper.DepartmentMapper;
import kroryi.spring.mapper.EmployeeMapper;
import kroryi.spring.mapper.TitleMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class EmployeeTests {
    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void insert() {

        TitleDTO titleDTO = TitleDTO.builder()
                .name("상무")
                .build();

        titleMapper.insert(titleDTO);
    }

    @Test
    public void getTitleAll(){
        List<TitleDTO> titleDTOS = titleMapper.selectTitleAll();
        titleDTOS.forEach( titleDTO -> {
            System.out.println(titleDTO);
        });
    }

    @Test
    public void selectTitleByCode(){
        List<TitleDTO> titleDTOS = titleMapper.selectTitleByCode(1L);
        titleDTOS.forEach( titleDTO -> {
            System.out.println(titleDTO);
        });

    }

    @Test
    public void selectTitleByName(){
        List<TitleDTO> titleDTOS = titleMapper.selectTitleByName("사원");
        titleDTOS.forEach( titleDTO -> {
            System.out.println(titleDTO);
        });

    }



    @Test
    public void getDepartmentAll(){
        List<DepartmentDTO> departmentDTOS = departmentMapper.getAll();
        departmentDTOS.forEach( departmentDTO -> {
            System.out.println(departmentDTO);
        });
    }


    @Test
    public void getEmployeeAllWithTitleWithDepartment1(){

        List<EmployeeDTO> employeeDTOS =
                employeeMapper.getEmployeeAllWithTitleWithDepartment();
        employeeDTOS.forEach( employeeDTO -> {
            System.out.println(employeeDTO);
        });
    }




}
