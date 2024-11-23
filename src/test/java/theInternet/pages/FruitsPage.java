package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

import static supports.Browser.getElement;
import static supports.Browser.visit;

public class FruitsPage {
   Select select;

   public void open(){
      visit("https://output.jsbin.com/osebed/2");
      select = new Select(getElement(By.id("fruits")));
   }

   public boolean isMultipleSelect(){
      return select.isMultiple();
   }

   public FruitsPage select(String option){
      select.selectByValue(option);
      return this;
   }

   public FruitsPage deselect(String option){
      select.deselectByValue(option);
      return this;
   }

   public boolean isOptionSelected(String option){
      String locator = String.format("//*[@id='fruits']/option[@value='%s']",option);
      return Browser.isSelected(By.xpath(locator));
   }
   public void deselectAll(){
      select.deselectAll();
   }


}
