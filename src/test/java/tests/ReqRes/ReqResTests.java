package tests.ReqRes;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.create_success_status_COde;
import static Common.RequestBuilder.createEmployeeResponse;
import static org.hamcrest.Matchers.containsString;

@Test
@Feature("Req Res")
@Story("Create Employee")
public class ReqResTests {

    @Description("As an api user i want to create a new employee")
    @Severity(SeverityLevel.CRITICAL)
    public void createEmployeeTests(){
        createEmployeeResponse().
                then().
                assertThat().
                statusCode(create_success_status_COde).
                body("name",containsString("Nkosi")).
                body("job",containsString("TeSter"));
    }
}
