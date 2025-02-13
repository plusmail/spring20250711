package kroryi.spring.service;

import kroryi.spring.SampleDAO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleDAO sampleDAO;

}
