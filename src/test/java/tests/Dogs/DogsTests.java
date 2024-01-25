package tests.Dogs;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.create_success_status_COde;
import static Common.CommonTestData.success_status_COde;
import static Common.RequestBuilder.createEmployeeResponse;
import static Common.RequestBuilder.getBreedListResponse;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

@Test
@Feature("Dogs")
@Story("Get list of breeds")
public class DogsTests {

    @Description("As an api user i want to get list of breeda")
    @Severity(SeverityLevel.CRITICAL)
    public void getListOfBreedsTests() {
        getBreedListResponse().
                then().
                assertThat().
                statusCode(success_status_COde).
                body(containsString("appenzeller"));
    }

}
