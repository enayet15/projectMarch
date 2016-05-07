package news;

import base.CommonAPI;
import org.testng.annotations.Test;
import reader.ReadNewsData;

import java.util.List;

/**
 * Created by rrt on 5/7/2016.
 */
public class ActionItems extends CommonAPI{


    ReadNewsData readNewsData = new ReadNewsData();
    @Test
    public void searchNews() throws Exception{
        List<String> actionItems = readNewsData.getActionStepsDataFromDB("actionSteps","items");
        List<String> newsData = readNewsData.getNewsDataFromDB("cnnnewsvertical","NewsTitle");
        for(String ai:actionItems) {
            for(int i=0; i<newsData.size(); i++){
            chooseAction(ai, newsData.get(i));
                clearSearchField();
          }
        }
    }

    public void chooseAction(String action,String value)throws InterruptedException{
        switch(action){
            case "clickOnSearch": clickOnSearch();
                break;
            case "enterTextOnInputField": enterTextOnInputField(value);
                break;
            case "clearSearchField": clearSearchField();
                break;
            default:
                System.out.println("Invalid Action item");
                break;

        }
    }

    public void clickOnSearch()throws InterruptedException{
        clickByCss("#search-button");
        sleepFor(2);
    }

    public void enterTextOnInputField(String vale){
        typeByCss("#search-input-field", vale);
        takeEnterKeys("#search-input-field");
    }
    public void clearSearchField(){
        clearInputField("#searchInputTop");
    }

}
