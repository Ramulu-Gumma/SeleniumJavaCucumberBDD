package UnCheckedExceptionHandling;

class DefectTracker {
	int[] defects = {2, 5, 3}; // Defects in batches

	// Method to get defects for a batch
	public void getDefects(int batchIndex) {
		try {
			System.out.println("Batch " + (batchIndex + 1) + " Defects: " + defects[batchIndex]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("❌ Invalid batch index! " + e.getMessage());
		}
	}
}

// Main Class
public class JT_02_ArrayIndexOutOfBoundsException {
	public static void main(String[] args) {
		DefectTracker tracker = new DefectTracker();
		tracker.getDefects(1); // ✅ Valid index
		tracker.getDefects(5); // ❌ This will trigger ArrayIndexOutOfBoundsException
	}
}

