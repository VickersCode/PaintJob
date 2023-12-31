import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

/**
 * Excercise from Starting Out With Java 5th Edition Ch5 Q4
 * 
 * Program cacluates total cost to paint a house.
 * Per every 115 square feet of wall space:
 *  - One gallon of paint
 *  - 8 hours of labor
 * 
 * $18 per hour of labor
 * 
 * User will enter the number of rooms, square footage of each room, 
 * and price per gallon of paint
 * 
 * Methods return:
 *  - Gallons required
 *  - Hours of labor
 *  - Cost of paint
 *  - Labor Charges
 *  - Total cost
 */

public class PaintJob {
    public static void main(String[] args) {
        float LABOR_CHARGES = 18;


        // Gather number of rooms 
        String input = JOptionPane.showInputDialog("Enter the number of rooms:");
        int rooms = Integer.parseInt(input);

        // Gather price per gallon of paint
        input = JOptionPane.showInputDialog("Enter the price per gallon of paint:");
        float paintPrice = Float.parseFloat(input);

        // Call method to determine total square feet
        int squareFeet = totalSquareFeet(rooms);
        // Call method to determine total gallons
        float gallons = numGallons(squareFeet);
        // Total hours of labor
        float laborHours = hoursLabor(squareFeet);

        // Find the cost of the paint
        float costPaint = costPaint(gallons, paintPrice);
        // Find the cost of labor
        float costLabor = costLabor(laborHours, LABOR_CHARGES);

        float total = costPaint + costLabor;

        JOptionPane.showMessageDialog(null, "The total cost of the job is " + 
                                      (NumberFormat.getCurrencyInstance(Locale.US).format(total)) + ".");
    }

    /**
     * Method returns total cost of labor
     * 
     * @param laborHours hours required to finish job
     * @param LABOR_CHARGES hourly charge for labor
     * @return total cost of labor
     */
    public static float costLabor(float laborHours, float LABOR_CHARGES) {
        float total = laborHours * LABOR_CHARGES;
        
        return total;
    }


    /**
     * Method returns the total cost of paint
     * 
     * @param gallons gallons of paint needed
     * @param paintPrice price per gallon
     * @return total cost of paint
     */
    public static float costPaint(float gallons, float paintPrice) {
        float total;
        total = gallons * paintPrice;
        
        return total;
    }

    /**
     * Method calculates total amount of hours to paint the home
     * 
     * @param squareFeet total number of square feet
     * @return the amount of hours of labor to finish the home
     */
    public static float hoursLabor(int squareFeet) {
        float HOURS = 8;
        float total = squareFeet / HOURS;
        return total;
    }

    /**
     * Method loops through each room the homeowner 
     * has listed and asks the square footage of each
     * 
     * @param rooms number of rooms in the home
     * @return total = total number of square feet
     */
    public static int totalSquareFeet(int rooms) {
        int total = 0;
        for (int i = 1; i <= rooms; i++) {
            String input = JOptionPane.showInputDialog("Enter the square footage to be painted in room " + i + ":");
            int squareFeet = Integer.parseInt(input);
            total += squareFeet;
        }
        return total;
    }

    /**
     * Method takes the total square feet and calculates 
     * number of gallons of paint needed. 
     * ONE_GALLON is a constant which states how many square
     * feet one gallon of paint covers.
     * 
     * @param squareFeet total number of square feet,
     *        determined by the totalSquareFeet() Method
     * @return the total number of gallons needed
     */
    public static float numGallons(int squareFeet) {
        float ONE_GALLON = 115;
        float total = squareFeet / ONE_GALLON;
        return total;
    }
}
