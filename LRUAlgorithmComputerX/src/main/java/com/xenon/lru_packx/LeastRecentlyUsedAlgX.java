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

/*This class automatically computes everything and stored the Data in a 
* Class called LRUComputationDataHolder 
* which has a methods to access results
 */
public class LeastRecentlyUsedAlgX extends MainLRUAttribs {

    private LRUComputationDataHolder dataHolder; // return a compiled class with all required computation
    public static final int PAGE_HIT_VALUE_ID = -1; // indicates that the value is also the same as previous in row
    public static boolean isDebuggingEnabled = false; //a boolean flag for debugging

    //constructor
    public LeastRecentlyUsedAlgX(ArrayList<Integer> reference_list, int page_frame_count) {
        super();
        this.reference_list = reference_list;
        this.page_frame_count = page_frame_count;
        initRowContent();
    }

    private Integer performBackLogScan(ArrayList<Integer> current_stack_list) {
        // returns the index of item to be removed on current_stack

        int detection_count = current_stack_list.size();
        int size_of_back_log = this.back_log_list.size();
        ArrayList<Integer> rankList = new ArrayList<>();

        for (int i = size_of_back_log - 1; i >= 0; i--) {
            Object currentObject = this.back_log_list.get(i);
            if (detection_count > 0) {
                if (current_stack_list.contains(currentObject)) {
                    rankList.add((Integer) currentObject); // add the detected item instantly
                    detection_count--; // less the detection count because an item has been detected already
                }
            } else {
                break;
            }
        }
        Object itemObject_to_remove = rankList.get(rankList.size() - 1);
        return current_stack_list.indexOf(itemObject_to_remove);
    }

    private void addItemToBackLog(Object item) {
        //handles everything when adding item in back log
        this.back_log_list.remove(item); // remove the current item if it exist in back log
        this.back_log_list.add((Integer) item); // add the current item to update current position;
    }

    private void addItemToCorrectRowContent(ArrayList<Integer> current_stack, int mode) {
        // get the correct row for the current item and add it to the array list
        // designated
        ArrayList<Integer> copy_loggerArrayList = new ArrayList<>();
        if (mode == 1) {
            // create a list of full page hit value id
            for (int i = 0; i < current_stack.size(); i++) {
                copy_loggerArrayList.add(LeastRecentlyUsedAlgX.PAGE_HIT_VALUE_ID);
            }
            current_stack = new ArrayList<>(copy_loggerArrayList);
        }
        for (int i = 0; i < current_stack.size(); i++) {
            this.row_content.get(i + 1).add(current_stack.get(i));
        }
    }

    private void addPageFaultNumbersToCorrectRowContent() {
        // add the page fault number at the ending row of JTable
        // add the page hit number at the ending row of JTable
        // run on every ending of computation
        ArrayList<Integer> reference_numbers_List = new ArrayList<>();

        for (int i = 1; i <= this.reference_list.size(); i++) {
            //creating a array of number accessing this via index gives us the correct number
            reference_numbers_List.add(i);
        }

        int counter = 1;
        for (Integer indexInteger : this.page_fault_index_list) {
            if (indexInteger == LeastRecentlyUsedAlgX.PAGE_HIT_VALUE_ID) {
                //this is a page hit
                this.page_fault_numbers_List.add(-1);
                this.page_hit_numbers_List.add(counter);
                //add the counter for row of page fault if page fault
                this.row_content.get(this.page_frame_count + 2).add(counter);
                //add the -1 for row of page hit if page fault
                this.row_content.get(this.page_frame_count + 1).add(-1);
            } else {
                this.page_fault_count++;
                //this is a page fault
                this.page_hit_numbers_List.add(-1);
                this.page_fault_numbers_List.add(counter);
                //add the counter for row of page fault if page fault
                this.row_content.get(this.page_frame_count + 1).add(counter);
                //add the -1 for row of page hit if page fault
                this.row_content.get(this.page_frame_count + 2).add(-1);
                counter++;
            }
        }
    }

    private void initRowContent() {
        for (int i = 1; i <= this.page_frame_count; i++) {
            this.row_content.put(i, new ArrayList<>());
        }
        this.row_content.put(this.page_frame_count + 1, new ArrayList<>()); // store all page fault number
        this.row_content.put(this.page_frame_count + 2, new ArrayList<>()); // store all page hit number
    }

    // the brain that do all calling and computation
    public void startLRUCalculate() {
        int current_page_fault = 1;
        // stores the currently stacked items
        ArrayList<Integer> current_stack_List = new ArrayList<>();
        // getting reference List size tells the DataAmount of iteration
        int iteration_count = this.reference_list.size();   

        for (int i = 0; i < iteration_count; i++) {
            // current item
            Object itemObject = this.reference_list.get(i);
            if (isDebuggingEnabled) {

                System.err.print(" {");
                current_stack_List.forEach(x_aiff -> {
                    System.err.print(x_aiff + ",");
                });
                System.err.print("} ");

                System.err.print("Current Back Log: ");
                System.err.print(" {");
                this.back_log_list.forEach(x_aiff2 -> {
                    System.err.print(x_aiff2 + ",");
                });
                System.err.print("} ");

                System.err.print("Current Item: " + (Integer) itemObject + " ");
            }

            // page hit detection
            if (!current_stack_List.isEmpty() && current_stack_List.contains((Integer) itemObject)) {
                this.page_hit_index_list.add(i); // add to page hit index
                this.page_fault_index_list.add(LeastRecentlyUsedAlgX.PAGE_HIT_VALUE_ID);
                if (isDebuggingEnabled) {
                    /*
					 * this.page_fault_index_list.forEach(x_aiff ->{ System.err.print(x_aiff); });
                     */
                    System.err.print("Page hit: " + i + " ");
                }
                addItemToBackLog(itemObject); // adding to back log
                addItemToCorrectRowContent(current_stack_List, 1);
                continue; // skip everything if page hit
            } else {
                // it is a page fault
                this.page_fault_index_list.add(current_page_fault);
                current_page_fault++;
                if (isDebuggingEnabled) {
                    /*
					 * this.page_fault_index_list.forEach(x_aiff ->{ System.err.print(x_aiff); });
                     */
                    System.err.print("Page fault: " + i + " ");
                }
                
                //pattern 2 - the current stack is not full
                if (current_stack_List.size() < this.page_frame_count) {
                    current_stack_List.add((Integer) itemObject);
                    addItemToCorrectRowContent(current_stack_List, 0);
                    addItemToBackLog(itemObject);
                    continue;
                }
            }

            // full
            if (i >= this.page_frame_count) {
                // perform back log scanning
                if (isDebuggingEnabled) {
                    if (isDebuggingEnabled) {
                        if (i == 6) {
                            System.err.print("Current stack at 6: ");
                            System.err.print(" {");
                            current_stack_List.forEach(x_aiff -> {
                                System.err.print(x_aiff + ",");
                            });
                            System.err.print("} ");
                        }
                    }
                }
                int index_to_remove = performBackLogScan(current_stack_List);
                int item = current_stack_List.get(index_to_remove);
                // add item to back log
                Object item_to_removeObject = item;

                this.back_log_list.remove(item_to_removeObject);
                addItemToBackLog(itemObject);

                // remove the item
                current_stack_List.remove(index_to_remove);
                // add new item to the index of nominated item for removal
                current_stack_List.add(index_to_remove, (Integer) itemObject);
                addItemToCorrectRowContent(current_stack_List, 0);
                if (i == 6) {
                    if (isDebuggingEnabled) {
                        System.err.print("Index to remove: " + index_to_remove);
                        System.err.print(" Current stack at 6 after scan: ");
                        System.err.print(" {");
                        current_stack_List.forEach(x_aiff -> {
                            System.err.print(x_aiff + ",");
                        });
                        System.err.print("} ");
                    }
                }
            }
            //current_stack_List.add((Integer) itemObject);
            //addItemToCorrectRowContent(current_stack_List, 0);
            //addItemToBackLog(itemObject);
        }
        addPageFaultNumbersToCorrectRowContent();
    }

    public LRUComputationDataHolder getDataHolder() {
        // must call calculate before this class
        // creating data holder
        dataHolder = new LRUComputationDataHolder(this.reference_list, this.page_frame_count, this.page_fault_count,
                this.page_fault_index_list, this.page_hit_index_list, this.row_content, this.back_log_list,
                this.page_hit_numbers_List, this.page_fault_numbers_List);
        return dataHolder;
    }

}
