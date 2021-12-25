import calculator.CalculatorHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTests {
    protected final String CALCULATOR_URL = "https://web2.0calc.com/";
    protected static final String DIGIT_ID_PREFIX = "Btn";
    protected static final String POWER_TWO_ID = "Button2X";
    protected static final String CALC_ID = "BtnCalc";
    protected static final String CONSENT = "Consent";
    protected static final String CLEAR_ID = "BtnClear";
    protected static final String EXTENSION_ID = "BtnOpD2";
    protected static final String RESULT_ID = "input";
    CalculatorHandler calculatorHandler = new CalculatorHandler();
    protected static int NUM_POW = 2;

    @DataProvider(name = "params")
    public static Object[][] ParamsForPower(){
        return new Object[][]{
                {1},
                {2},
                {3},
        };
    }

    @Test(priority=1)
    public void openBrowser()throws Exception{
        calculatorHandler.openBrowser(CALCULATOR_URL);
        calculatorHandler.clickButtonByText(CONSENT);
    }

    @Test(dataProvider = "params", priority=2)
    public void powerTwo(int powNum) throws Exception{
        String digitId = getDigitButtonId(powNum);
        calculatorHandler.clickButtonById(EXTENSION_ID);
        calculatorHandler.clickButtonById(digitId);
        calculatorHandler.clickButtonById(POWER_TWO_ID);
        calculatorHandler.clickButtonById(CALC_ID);
        String expectedResult = String.valueOf((int)Math.pow(NUM_POW, powNum));
        timeout(2);
        calculatorHandler.validateResult(expectedResult,RESULT_ID);
        calculatorHandler.addOperationToHistory(NUM_POW + "^" + powNum + " = " + expectedResult);
        calculatorHandler.clickButtonById(CLEAR_ID);
    }

    public void timeout(int sec){
        try {
            Thread.sleep(sec * 1000);
        }catch (Exception e){
            System.out.println("Failed during timeout execution: " + e.getMessage());
        }
    }

    @Test(priority=3)
    public void closeBrowser(){
        calculatorHandler.printHistory();
        calculatorHandler.closeBrowser();
    }

    public String getDigitButtonId(int digit){
        return DIGIT_ID_PREFIX + digit;
    }
}
