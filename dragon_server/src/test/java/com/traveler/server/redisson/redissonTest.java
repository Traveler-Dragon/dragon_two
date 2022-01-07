package com.traveler.server.redisson;

import com.traveler.server.FamilyApplicationTests;
import com.traveler.server.service.TestService;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class redissonTest extends FamilyApplicationTests {

    @Autowired
    private TestService testService;

    @RepeatedTest(value = 50, name="完成度：{currentRepetition}/{totalRepetitions}")
    @Execution(ExecutionMode.CONCURRENT)
    public void asynUploadFile() {
        //174
        testService.redissonTest(UUID.randomUUID().toString());

    }
}
