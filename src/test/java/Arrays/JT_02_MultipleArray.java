package Arrays;

//Multi-Dimensional Array
//A multi-dimensional array in Java is an array of arrays. 
//It allows you to store data in a table-like structure, where each element can itself be an array.

public class JT_02_MultipleArray {
	
	 // 2D array representing machine statuses across 3 shifts
    // Rows = Machines, Columns = Shifts
    String[][] machineStatus = {
        {"Operational", "Down", "Operational"},   // CNC Machine
        {"Operational", "Operational", "Down"},   // Lathe Machine
        {"Down", "Operational", "Operational"},   // Drilling Machine
        {"Operational", "Operational", "Operational"} // Milling Machine
    };
    {
    
    // Print machine status for each shift
    for (int i = 0; i < machineStatus.length; i++) {
        System.out.println("Machine " + (i+1) + " Status:");
        for (int j = 0; j < machineStatus[i].length; j++) {
            System.out.println("Shift " + (j+1) + ": " + machineStatus[i][j]);
        }
    }
}
}


