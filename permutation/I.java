package permutation;

import java.util.ArrayList;

public class I {

	public static void main(String[] args) {
		I i = new I();
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> ll = i.permute(num);
		i.printList(ll);
	}

	private void printList(ArrayList<ArrayList<Integer>> _aa) {
		for(ArrayList<Integer> _a : _aa) {
			System.out.println("");
			for(Integer _i : _a) {
				System.out.print(_i + "  ");
			}
		}
	}	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int n = num.length;
		boolean[] visited = new boolean[n];

		permuteImp(res, tmp, num, visited);

		return res;
	}

	private void permuteImp(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> tmp, int[] num, boolean[] visited) {
		if (tmp.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				tmp.add(num[i]);
				visited[i] = true;
				permuteImp(res, tmp, num, visited);
				visited[i] = false;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
