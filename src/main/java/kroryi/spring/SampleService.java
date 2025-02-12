package kroryi.spring;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@ToString
@Service
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class SampleService {

    private final SampleDAO sampleDAO;

}
