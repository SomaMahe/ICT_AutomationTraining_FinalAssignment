
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderClass {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod (Method m){

        Object[][] searchProducts = null;
        if (m.getName().equalsIgnoreCase("verifyAvailableProductSearch")){

            return new Object[][]{{"Shoes"}};


        } else if(m.getName().equalsIgnoreCase("verifyUnavailableProductSearch")){


            return new Object[][]{{"XYZ"}};

        }

        return null;

    }
}



