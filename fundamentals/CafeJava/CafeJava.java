public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.50;
        double dripCoffeePrice = 1.25;
        double lattePrice = 3.25;
        double cappuccinoPrice = 3.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println(displayTotalMessage + dripCoffeePrice + ", " + customer1);

        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(displayTotalMessage + (lattePrice * 2) + ", " + customer2);
        if(isReadyOrder2){
            System.out.println(customer2 + readyMessage);
        }
        else{
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice) + ", " + customer3);

    }
}
