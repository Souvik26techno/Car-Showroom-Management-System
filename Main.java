import java.util.Scanner;
import java.util.UUID;

interface Utility{
    public void setDetails();
    public void getDetails();
}

class Showroom implements Utility{
    String showroomName;
    String showroomAddress;
    int totalEmpoyees;
    int totalCars;
    String managerName;

    @Override
    public void setDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================== *** Enter showroom Details *** ===========================");
        System.out.println();
        System.out.print("Enter Showroom Name: ");
        showroomName = sc.nextLine();
        System.out.print("Enter Showroom Address: ");
        showroomAddress = sc.nextLine();
        System.out.print("Enter total no of Employees : ");
        totalEmpoyees = sc.nextInt();
        System.out.print("Enter total no of Cars: ");
        totalCars = sc.nextInt();
        // some occur happened while taking String input after Integer input
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter Manager Name: ");
        managerName = sc.nextLine();
    }
    @Override
    public void getDetails() {
        System.out.println();
        System.out.println("Showroom Name: "+ showroomName);
        System.out.println("Showroom Address: "+showroomAddress);
        System.out.println("Manager Name: "+managerName);
        System.out.println("Total Employees: "+totalEmpoyees);
        System.out.println("Total Cars: "+totalCars);
    }
}

class Car extends Showroom{
    String carName;
    String carColor;
    String carFuelType;
    int carPrice;
    String carType;
    String carTransmission;

    @Override
    public void setDetails() { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("========================== *** Enter Car Details *** ===========================");
        System.out.println();
        System.out.print("Enter Car Name: ");
        carName = sc.nextLine();
        System.out.print("Enter Car Color: ");
        carColor = sc.nextLine();
        System.out.print("Enter Fuel type: ");
        carFuelType = sc.nextLine();
        System.out.print("Enter Car Price: ");
        carPrice = sc.nextInt();
        // some occur happened while taking String input after Integer input
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter Car type: ");
        carType = sc.nextLine();
        System.out.print("Enter Car transmission: ");
        carTransmission = sc.nextLine();
    }
    @Override
    public void getDetails() {
        System.out.println(); 
        System.out.println("Car Name: "+ carName);
        System.out.println("Car Color: "+carColor);
        System.out.println("Fuel Type: "+carFuelType);
        System.out.println("Car Price: "+carPrice);
        System.out.println("Car Type: "+carType);  
        System.out.println("Car Transmission: "+carTransmission); 
    }
}

class Employee extends Showroom{
    String employeeId;
    String employeeName;
    String employeeDepartment;
    int age;

    @Override
    public void setDetails() {
        Scanner sc = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        employeeId = id.toString();
        System.out.println("========================== *** Enter Employee Details *** ==========================="); 
        System.out.println();
        System.out.print("Enter Employee Name: ");
        employeeName = sc.nextLine();
        System.out.print("Enter Employee Age: ");
        age = sc.nextInt();
        // some occur happened while taking String input after Integer input
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter Showroom Name: ");
        showroomName = sc.nextLine();
        System.out.print("Enter Employee Department: ");
        employeeDepartment = sc.nextLine();
    }
    @Override
    public void getDetails() {
        System.out.println();
        System.out.println("Employee ID: "+employeeId);
        System.out.println("Employee Name: "+employeeName);
        System.out.println("Employee Department: "+employeeDepartment);
        System.out.println("Employee Age: "+age);
        System.out.println("Showroom Name: "+ showroomName);
    }
}

public class Main {
    public static void menu(){
        System.out.println();
        System.out.println("================= *** Welcome to Car Showroom Management System *** =================");
        System.out.println();
        System.out.println("============================= *** Enter Your Choice *** =============================");
        System.out.println();
        System.out.println("1. Add Showroom \t\t\t    2. Add Car \t\t\t\t   3. Add Employee");
        System.out.println();
        System.out.println("4. Show Showroom Details \t\t   5. Show Car Details \t\t   6. Show Employee Details");
        System.out.println();
        System.out.println("============================== *** Enter 0 to Exit *** ===============================");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Showroom showroom[] = new Showroom[10];
        Car car[] = new Car[10];
        Employee employee[] = new Employee[10];
        int showroomCount = 0;
        int carCount = 0;
        int employeeCount = 0;
        int choice = 100;

        while(choice != 0){
            menu();
            choice = sc.nextInt();
            while(choice!= 9 && choice != 0){
                switch(choice){
                    case 1:
                        showroom[showroomCount] = new Showroom();
                        showroom[showroomCount].setDetails();
                        showroomCount++;
                        System.out.println();
                        System.out.println("1. Add new Showroom");
                        System.out.println("9. Back to main menu");
                        System.out.println();
                        choice = sc.nextInt();
                        break;
                    case 2:
                        car[carCount] = new Car();
                        car[carCount].setDetails();
                        carCount++;
                        System.out.println();
                        System.out.println("2. Add new Car");
                        System.out.println("9. Back to main menu");
                        choice = sc.nextInt();
                        break;
                    case 3:
                        employee[employeeCount] = new Employee();
                        employee[employeeCount].setDetails();
                        employeeCount++;
                        System.out.println();
                        System.out.println("3. Add new Employee");
                        System.out.println("9. Back to main menu");
                        choice = sc.nextInt();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("============================= *** Showroom Details *** ==============================");
                        for (int i = 0; i < showroomCount; i++) {
                            showroom[i].getDetails();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9. Back to main menu");
                        System.out.println("0. exit");
                        choice = sc.nextInt();
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("================================ *** Car Details *** =================================");
                        for (int i = 0; i < carCount; i++) {
                            car[i].getDetails();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9. Back to main menu");
                        System.out.println("0. exit");
                        choice = sc.nextInt();
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("============================= *** Employee Details *** ==============================");
                        for (int i = 0; i < employeeCount; i++) {
                            employee[i].getDetails();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9. Back to main menu");
                        System.out.println("0. exit");
                        choice = sc.nextInt();
                        break;
                    default:
                        System.out.println("Invalid choice. ");
                }
            }
        }
    }
}
