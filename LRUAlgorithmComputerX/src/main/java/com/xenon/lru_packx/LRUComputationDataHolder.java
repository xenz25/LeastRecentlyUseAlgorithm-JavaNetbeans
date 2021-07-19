/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xenon.lru_packx;

/**
 *
 * @author xenxi
 */
import java.util.ArrayList;
import java.util.HashMap;

//This Class is the Batch Class on Notes
public class LRUComputationDataHolder extends MainLRUAttribs {

    /*
	 * @param ArrayList<Integer> reference_list
	 * 
	 * @param int page_frame_count
	 * 
	 * @param int page_fault_count = 0;
	 * 
	 * @param ArrayList<Integer> page_fault_index_list
	 * 
	 * @param ArrayList<Integer> page_hit_index_list
	 * 
	 * @param HashMap<Integer, ArrayList<Integer>> row_content
	 * 
	 * @param ArrayList<Integer> back_log_list
     */
    //constructor
    public LRUComputationDataHolder(ArrayList<Integer> reference_list, int page_frame_count, int page_fault_count,
            ArrayList<Integer> page_fault_index_list, ArrayList<Integer> page_hit_index_list,
            HashMap<Integer, ArrayList<Integer>> row_content, ArrayList<Integer> back_log_list,
            ArrayList<Integer> page_hit_numbers_List, ArrayList<Integer> page_fault_numbers_List) {
        super();
        this.reference_list = reference_list;
        this.page_frame_count = page_frame_count;
        this.page_fault_count = page_fault_count;
        this.page_fault_index_list = page_fault_index_list;
        this.page_hit_index_list = page_hit_index_list;
        this.row_content = row_content;
        this.back_log_list = back_log_list;
        this.page_hit_numbers_List = page_hit_numbers_List;
        this.page_fault_numbers_List = page_fault_numbers_List;
    }

    public ArrayList<Integer> getReference_list() {
        //returns the list of reference numbers
        return reference_list;
    }

    public int getPage_frame_count() {
        //returns the number of page frame used
        return page_frame_count;
    }

    public ArrayList<Integer> getPage_fault_index_list() {
        //returns the list of all page fault indexes
        return page_fault_index_list;
    }

    public ArrayList<Integer> getPage_hit_index_list() {
        //returns the list of all page hit indexes
        return page_hit_index_list;
    }

    public HashMap<Integer, ArrayList<Integer>> getRow_content() {
        //returns the current computation row contents
        return row_content;
    }

    public int getPage_Fault_Count() {
        //return the number of page fault
        return this.page_fault_count;
    }

    public ArrayList<Integer> getPage_hit_numbers_list() {
        //returns a list of all page hit numbering
        return this.page_hit_numbers_List;
    }

    public ArrayList<Integer> getPage_fault_numbers_list() {
        //returns a list of all page fault numbering
        return this.page_fault_numbers_List;
    }
}
