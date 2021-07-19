package lrupack;

import java.util.ArrayList;
import java.util.HashMap;

abstract class MainLRUAttribs {
	ArrayList<Integer> reference_list = new ArrayList<>(); // stores all reference item
	int page_frame_count = 0;
	ArrayList<Integer> page_fault_index_list = new ArrayList<>(); // stores page fault number
	ArrayList<Integer> page_hit_index_list = new ArrayList<>(); // stores page hit number
	/*
	 * stores all JTable Row data for GUI Display K - row ID number V - row content
	 * - this will be converted to Object[] when inserted to JTable
	 */
	HashMap<Integer, ArrayList<Integer>> row_content = new HashMap<>();
	// private ArrayList<Integer> current_stack_list = new ArrayList<>(); //stores
	// currently active process for scanning
	ArrayList<Integer> back_log_list = new ArrayList<>(); // store all items that was previously scanned to Main Memory
	int page_fault_count = 0;
	ArrayList<Integer> page_fault_numbers_List = new ArrayList<>();
	ArrayList<Integer> page_hit_numbers_List = new ArrayList<>();
}