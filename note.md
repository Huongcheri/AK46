# Selenium
``` java
C:\Users\Admin\Maven\AK46\src\test\java\theInternet\HyperLinkTest.java
//    driver.findElement(By.linkText("here")).click();
        driver.navigate().back();
```
Doan nay bo
``` java

driver.findElements(By.xpath("//table[@id ='table1']/tbody"))
                .stream()
                .forEach(webElement -> System.out.println(webElement.getText()));
        System.out.println("\n");
```
Doan code Person Table ban dau
``` java

        double[] dueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$","")))
                .toArray();

        double maxDueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$","")))
                .max()
                .getAsDouble();

        int indexOfMaxDue = 0;
        for(int i =0;i<dueValue.length;i++){
            if(dueValue[i]==maxDueValue){
                indexOfMaxDue = i+1;
            }
        }
        System.out.println(indexOfMaxDue);
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firsName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxDue,2))).getText(); // 2 -> cot firstName
        String lastName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxDue,1))).getText(); // 1 -> cot lastName
        Assert.assertEquals(String.format("%s %s",firsName,lastName),"Jason Doe");

```
Lan 2 nhung dang get sai so max chua hieu
``` java
 @Test
    void tc05(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> table1Person = new ArrayList<>();
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for (int i = 1; i <=totalRows ; i++) {
            String firstName = driver.findElement(By.xpath(String.format(cellLocator,i,2))).getText();
            String lastName = driver.findElement(By.xpath(String.format(cellLocator,i,1))).getText();
            String due = driver.findElement(By.xpath(String.format(cellLocator,i,4))).getText();
            table1Person.add(new Person(firstName,lastName,due));
            System.out.println(table1Person);
        }

        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
        System.out.println(maxDuePerson.getDue());
        Assert.assertEquals(maxDuePerson.getFirstName(),"Jason");
    }
```
