/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;
import java.util.*;

public class TwoSum {

    public int[] twoSumBruteForce(int[]nums,int target){
         for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    int[] a = {i,j};
                    return a;
                }  
            }
        }
        throw new IllegalArgumentException("No two #'s add to the target");
    }
     
    public int[] twoSumOptimal(int[]nums,int target){
        Hashtable<Integer,Integer> hTable = new Hashtable<Integer,Integer>(); 
        //Filling the hashtable
        for(int i = 0; i < nums.length ; i++)
            hTable.put(nums[i],i);
        for(int j = 0; j < nums.length ; j++){
            if(hTable.containsKey(target - nums[j]) && hTable.get(target - nums[j]) != j)
                return new int[] {j,hTable.get(target - nums[j])}; 
        }
        throw new IllegalArgumentException("No two #'s add to the target");
    }
    
  
    public static void main(String[]args){
        TwoSum t = new TwoSum();
        int[]arr = {4,7,15,44,56};
        int target = 59;
        //Brute force sol'n - O(n^2) Time Complexity, O(1) Space Complexity
        int[] b = t.twoSumBruteForce(arr,target);
        for(int i = 0; i < b.length ; i++){
            System.out.print(b[i] + " ");
        }     
        System.out.println();
        
        //Hashtable sol'n w/ 2 passes - O(n) Time Complexity, O(n) Space Complexity
        int[] a = t.twoSumOptimal(arr,target);
        for(int i = 0 ; i < a.length ; i++){
            System.out.print(a[i] + " "); 
        }
        
    }
}
