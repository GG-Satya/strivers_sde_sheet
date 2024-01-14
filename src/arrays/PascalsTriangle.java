package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		List<List<Integer>> ans = generate(4);
		for(List<Integer> list : ans) {
			for(int i : list) {
				System.out.print(i+"\t");
			}System.out.println();
		}
	}
	public static List<List<Integer>> generate(int numRows) { 
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(Arrays.asList(1)); // manual adding 1
		if(numRows == 1)return ans;
		for(int i=0; i<numRows-1; i++) {
			List<Integer> subList = new ArrayList<>();
			subList.add(1); // add 1 at begin

			var prev = ans.get(i);
			for(int j=0; j<i; j++) {
				subList.add(prev.get(j)+prev.get(j+1));
			}
				
			subList.add(1); // add 1 at end
			
			ans.add(subList);
		}
		return ans;
    }
}
