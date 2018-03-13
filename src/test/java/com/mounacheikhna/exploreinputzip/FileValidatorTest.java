package com.mounacheikhna.exploreinputzip;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class FileValidatorTest {

    private static final String TEST_RESOURCE_FOLDER = "src/test/resources/";
    private FileValidator fileValidator;

    @Before
    public void setUp() throws Exception {
        fileValidator = new FileValidator();
    }

    @Test
    public void testValidate() {
        fileValidator.validate(TEST_RESOURCE_FOLDER + "test.json");
    }
}
