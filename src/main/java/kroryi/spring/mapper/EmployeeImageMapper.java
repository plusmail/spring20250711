package kroryi.spring.mapper;

import kroryi.spring.dto.EmployeeImageDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface EmployeeImageMapper {


    @Insert("INSERT INTO employee_image (image_data, image_name, image_type, employee_id) " +
            "VALUES (#{imageData}, #{imageName}, #{imageType}, #{employeeId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void uploadImage(EmployeeImageDTO imageDTO);

    @Select("SELECT id, image_data, image_name, image_type, employee_id FROM employee_image WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "image_data", property = "imageData"),
            @Result(column = "image_name", property = "imageName"),
            @Result(column = "image_type", property = "imageType"),
            @Result(column = "employee_id", property = "employeeId")
    })
    EmployeeImageDTO getImageById(@Param("id") int id);

    @Select("SELECT id, image_data, image_name, image_type, employee_id " +
            "FROM employee_image WHERE employee_id = #{employeeId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "image_data", property = "imageData"),
            @Result(column = "image_name", property = "imageName"),
            @Result(column = "image_type", property = "imageType"),
            @Result(column = "employee_id", property = "employeeId")
    })
    List<EmployeeImageDTO> getImageByEmployeeId(@Param("employeeId") int employeeId);



    int deleteImageByEmployeeId(int employeeId);

}
