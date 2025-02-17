package kroryi.spring.mapper;

import kroryi.spring.dto.EmployeeImageDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface EmployeeImageMapper {


    @Insert("INSERT INTO employee_image (image_data, image_name, image_type, employee_id) " +
            "VALUES (#{imageData}, #{imageName}, #{imageType}, #{employeeId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void uploadImage(EmployeeImageDTO imageDTO);

    EmployeeImageDTO getImageByEmployeeId(int employeeId);

    int deleteImageByEmployeeId(int employeeId);

}
