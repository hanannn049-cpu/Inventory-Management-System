package inventoty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Scanner;
class Product{
	private String name;
	private double price;
	private int quantity;
	private double cost;
	private int salesCount;
	public Product(String name , double price ,int quantity , double cost  ) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.cost=cost;
		this.salesCount=0; 
	} 
	 public String getName() {
		 return name; 
	 }
	 public double getPrice() {
		 return price;
	 }
	 public int getQuantity() {
		 return quantity ;
	 }
	 public double getCost() {
		 return cost;
	 }
	 public int getSalesCount() {
		 return salesCount;
	 }
	 public void setName(String name) {
		 this.name=name;
	 }
	 public void setPrice(double price) {
		 this.price=price;
	 }
	 public void setQuantity(int quantity) {
		 this.quantity=quantity; 
	 }
	 public void setCost(double cost) {
		 this.cost=cost;
	 }
	 
	      	 
 public String toString() {
   return "Product Name:"+name+", Price:"+price+", Quantity:"+quantity+", Cost:"+cost+
		          ", Sold quantity:"+salesCount;
} 
 
 public void salesCounter(int quantity) {
	 this. salesCount += quantity;
} 	
 
public double calculateSales() {
	return salesCount * (price - cost);
}

}
 class User{
	 private String userName;
	 private String passWord;
	 public User(String userName , String passWord) {
		 this.userName=userName;
		 this.passWord=passWord;
	 }
	 
	 public String getUsreName() {
		 return userName;
	 }
	 public String getpassword() {
		 return passWord;
	 }
 }

  class prouductManagement{
 ArrayList<Product>lists = new ArrayList<>(); 
 ArrayList<String>sales  = new ArrayList<>();
	public void addProduct(Product p) {
		lists.add(p);
		System.out.println("The product has been added");
	}
	public void deleteProduct(String Pname) {
		for(int i=0 ; i<lists.size();i++) { 
			if(lists.get(i).getName().equals(Pname)){	  
			lists.remove(i);
			System.out.println("The product has been deleted"); 
			return;
		     }
		  }
		System.out.println("The product is not found");
	   }  
   public void recordsales(String Pname,int quan) {
	   for(int i=0 ; i<lists.size();i++) {
		   if(lists.get(i).getName().equals(Pname)) {
			   if(lists.get(i).getQuantity() >= quan) { 
				  lists.get(i).setQuantity(lists.get(i).getQuantity()-quan); 
				  lists.get(i).salesCounter(quan);
				  sales.add("Product: " + Pname + ", Quantity Sold: " + quan +", Date:" + new Date() );
				  System.out.println("Sale recorded");
				   
			   }else {
				   System.out.println("The quantity is not enough");
			   }
			   return;
		   }
	   }
	   System.out.println("The product is not found");
   }
   public void displaysales() {
	   System.out.println("Sales list:\n");
	   for(int i=0;i<sales.size();i++) {
		   System.out.println(sales.get(i));
	   }
   }
   public void calculateTotal() {
	   double total = 0.0;
	   for(int i=0;i<lists.size();i++) {
		   total += lists.get(i).calculateSales();
	   }
	   System.out.println("Total profit: "+total);
   }
   public void displayProduct() {
	   System.out.println("Products List:\n");
	  for(int i=0 ;i<lists.size();i++) {
		  System.out.println(lists.get(i));
		  }
	  }
   public void displayHighAndLowDemand() {
	   System.out.println("High Demand Products :");
	  for(int i=0 ;i<lists.size();i++) {
		  if(lists.get(i).getSalesCount() > lists.get(i).getQuantity()) {
		  System.out.println("Product: " + lists.get(i).getName()+", Sales: " +lists.get(i).getSalesCount());  
		  }  
	   }
	  System.out.println("\nLow Demand Products :");
	  for(int i=0 ;i<lists.size();i++) {
		  if(lists.get(i).getSalesCount() <= lists.get(i).getQuantity()) {
		  System.out.println("Product: "+ lists.get(i).getName() + ", Sales: "+ lists.get(i).getSalesCount());
		  }
	  }
   }
  public void updateProducts(String Pname) { 
	   Scanner input = new Scanner(System.in);  
	   boolean exit = false;
	   for (int i = 0; i < lists.size(); i++) { 
	       if (lists.get(i).getName().equals(Pname)) {
	           while (!exit) {
	               System.out.println("\n  Update Requests ");
	               System.out.println("1. Name");
	               System.out.println("2. Quantity");
	               System.out.println("3. Price");
	               System.out.println("4. Cost");
	               System.out.println("5. Exit");
	               System.out.print("Choose an option:");
	               int num = input.nextInt();
	               input.nextLine(); 
	                
	               switch (num) {
	                   case 1:
	                       System.out.print("The new name: ");
	                       String n = input.nextLine();
	                       lists.get(i).setName(n);
	                       break;
	                   case 2:
	                       System.out.print("The new quantity: ");
	                       int q = input.nextInt();
	                       lists.get(i).setQuantity(q);
	                       break;
	                   case 3:
	                       System.out.print("The new price: ");
	                       double p = input.nextDouble();
	                       lists.get(i).setPrice(p);
	                       break;
	                   case 4:
	                       System.out.print("The new cost: ");
	                       double c = input.nextDouble();
	                       lists.get(i).setCost(c);
	                       break;
	                       
	                   case 5:
	                       exit = true;
	                       break;
	                   default:
	                       System.out.println("please try again");
	               }
	               System.out.println("Updated successfully");
	           }
	       }
	   }
}
 
   public void search(String name) {
	for(int i=0 ; i<lists.size();i++) {
		if(lists.get(i).getName().equals(name)) {
			System.out.println("The product is available");
			return;
		} 
   }
   System.out.println("The product is not avilable");
   
     }
 }

  public class Inventory {
	    static HashMap<String, User> users = new HashMap<>();
	    static HashMap<String, prouductManagement> userInventory = new HashMap<>();
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        boolean exit = false;
	        boolean loggedIn = false;
	        prouductManagement ui = null;
	        while (!exit) {
	            while (!loggedIn) {
	                System.out.println("Welcome to Inventory Management System");
	                System.out.println("1. Login");
	                System.out.println("2. Sign Up");
	                System.out.print("Choose an option: ");
	                int c = input.nextInt();
	                input.nextLine();
	                switch (c) {
	                    case 1:
	                        System.out.print("Enter username: ");
	                        String username = input.nextLine();
	                        System.out.print("Enter password: ");
	                        String password = input.nextLine();
	                        if (users.containsKey(username) && users.get(username).getpassword().equals(password)) {
	                            loggedIn = true;
	                            ui = userInventory.get(username);
	                        } else {
	                            System.out.println("Wrong username or password.");
	                        }
	                        break;

	                    case 2:
	                        System.out.print("Enter new username: ");
	                        String newUsername = input.nextLine();
	                        System.out.print("Enter new password: ");
	                        String newPassword = input.nextLine();

	                        if (users.containsKey(newUsername)) {
	                            System.out.println("Username already exists.");
	                        } else {
	                            User newUser = new User(newUsername, newPassword);
	                            users.put(newUsername, newUser);
	                            prouductManagement newInventory = new prouductManagement(); 
	                            userInventory.put(newUsername, newInventory);
	                            System.out.println("Account created. Please login.");
	                        }
	                        break;

	                    default:
	                        System.out.println("Please try again.");
	                        break;
	                }
	            }

	            while (loggedIn) {
	                System.out.println("\nInventory Management System");
	                System.out.println("1. Add Product");
	                System.out.println("2. Delete Product");
	                System.out.println("3. Update Product");
	                System.out.println("4. Record Sale");
	                System.out.println("5. Sales List");
	                System.out.println("6. Products List");
	                System.out.println("7. High/Low Demand Product List");
	                System.out.println("8. Seaech");
	                System.out.println("9. Total Profit");
	                System.out.println("10. Logout");
	                System.out.print("Choose an option: ");
	                int num = input.nextInt();
	                input.nextLine();

	                switch (num) {
	                    case 1:
	                        System.out.print("Enter product name: ");
	                        String name = input.nextLine();
	                        System.out.print("Enter product price: ");
	                        double price = input.nextDouble();
	                        System.out.print("Enter product quantity: ");
	                        int quantity = input.nextInt();
	                        System.out.print("Enter product cost: ");
	                        double cost = input.nextDouble();

	                        Product p = new Product(name, price, quantity, cost);
	                        ui.addProduct(p); 
	                        break;

	                    case 2:
	                        System.out.print("Enter product name to delete: ");
	                        String deleteName = input.nextLine();
	                        ui.deleteProduct(deleteName); 
	                        break;

	                    case 3:
	                        System.out.print("Enter product name to update: ");
	                        String updateName = input.nextLine();
	                        ui.updateProducts(updateName);
	                        break;

	                    case 4:
	                        System.out.print("Enter product name to sell: ");
	                        String productName = input.nextLine();
	                        System.out.print("Enter quantity sold: ");
	                        int quantitySold = input.nextInt();
	                        ui.recordsales(productName, quantitySold);
	                        break;

	                    case 5:
	                        ui.displaysales(); 
	                        break;

	                    case 6:
	                        ui.displayProduct(); 
	                        break;

	                    case 7:
	                        ui.displayHighAndLowDemand(); 
	                        break;
	                    case 8:
	                    	System.out.print("Enter product name");
	                    	String pn = input.nextLine();
	                    	ui.search(pn);
	                    case 9:
	                        ui.calculateTotal(); 
	                        break;

	                    case 10:
	                        loggedIn = false;
	                        System.out.println("You have logged out.");
	                        break;

	                    default:
	                        System.out.println("Please try again.");
	                        break;
	                }
	            }
	        }

	        input.close();
	    }
	}

