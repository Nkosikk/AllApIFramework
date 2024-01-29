package tests.Kapudi;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.success_status_COde;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.containsString;

@Test
@Feature("jndjjfdf")
@Story("jndjdhjffd")
public class Universities {

    @Description("As an api user i want to get state province")
    @Severity(SeverityLevel.CRITICAL)
    public void getStateProvince() {
        getSTateProvinceResponse().
                then().
                assertThat().
                statusCode(success_status_COde);
    }

    public void printStateProvince(){
        System.out.println(StateProvince);
    }

}
