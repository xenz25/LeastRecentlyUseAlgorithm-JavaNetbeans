package mainpack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import lrupack.LRUComputationDataHolder;
import lrupack.LeastRecentlyUsedAlgX;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> reference_List2 = new ArrayList<>();
		
		System.out.print("Enter reference string (separated by comma): ");
		String[] tokenStrings = new Scanner(System.in).next().split(",");
		for(String pageString : tokenStrings) {
			reference_List2.add(Integer.parseInt(pageString));
		}
		
		System.out.print("Enter number of page frame: ");
		int page_frame_count = Integer.parseInt(new Scanner(System.in).next());
		System.out.println();
		
		LeastRecentlyUsedAlgX.isDebuggingEnabled = false;
		LeastRecentlyUsedAlgX comp1 = new LeastRecentlyUsedAlgX(reference_List2, page_frame_count);
		comp1.startLRUCalculate();
		LRUComputationDataHolder dataHolder = comp1.getDataHolder();

	
		String dividerString = "+";

		dataHolder.getReference_list().forEach(x ->{
			System.out.print("-"+dividerString);
		});
		System.out.println("");
		int counter = 0;
		for (Map.Entry<Integer, ArrayList<Integer>> items : dataHolder.getRow_content().entrySet()) {
			//System.out.print(items.getKey() + " - ");
			//System.out.println(items.getValue().size());
			if(counter == dataHolder.getRow_content().size()-1) {
				break;
			}
			if(counter > 0) {
				int space_count =  dataHolder.getReference_list().size() - items.getValue().size();
				for(int i =0; i < space_count; i++) {
					System.out.print(" |");
				}
			}
			for (int i = 0; i < items.getValue().size(); i++) {
				if(items.getValue().get(i) < 0) {
					System.out.print(" ");
				} else {
					System.out.print(items.getValue().get(i));
				}
				System.out.print("|");
			}
			System.out.println("");
			counter++;
			dataHolder.getReference_list().forEach(x ->{
				System.out.print("-"+dividerString);
			});
			System.out.println("");
		}
		
		System.out.println("\nPage Fault: " + dataHolder.getPage_Fault_Count());

	}

}
