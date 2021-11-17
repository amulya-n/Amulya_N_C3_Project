import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        boolean start , end ;
        LocalTime currentTime = getCurrentTime();
        start = currentTime.isAfter( openingTime );
        end = closingTime.isAfter( currentTime );

        if( start && end )
            return true ;
        else
            return false;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }
    //This function should return the total cost of the selected menu list by user
    // For this input will be the list on Menu items
    //return will be the total cost which is calculated by adding the prices of each menu Item

    //This function should return the total cost of the selected menu list by user
    // For this input will be the list on Menu items
    //return will be the total cost which is calculated by adding the prices of each menu Item

    public int returnOrderValue(String[] menuSelected){
        int totalCost = 0;
        Item selectedItem;

        for(String name: menuSelected) {
            selectedItem = findItemByName(name);
            if(selectedItem != null)
                totalCost = totalCost + selectedItem.getPrice();
        }
        return totalCost;
    }
    
    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
