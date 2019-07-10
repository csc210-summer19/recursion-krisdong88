/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Qichang Dong
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
	  if (n == k)
			return 1;
		else if (k == 0)
			return 1;
		else
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
	  if (n <=999)
			return "" + n;
		else {
			String str = "";
			if (n % 1000 < 10)
				str = "00";
			else if (n % 1000 < 100)
				str = "0";
			return intWithCommas(n / 1000) + "," + str + (n % 1000);
		}
	}
  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
	  if (index == len/2) {
			return;
	  }
	  int temp = x[index];
	  x[index] = x[len - 1 - index];
	  x[len - 1 - index] = temp;
	  reverseArray(x, index + 1,len);
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
		return arrayRange(a, 1, a[0], a[0]);
	}
		

	private int arrayRange(int[] nums, int numberofindex, int minimum, int maximum) {
		if (numberofindex == nums.length) {
			return maximum - minimum;
		}if (nums[numberofindex] > maximum) {
			maximum = nums[numberofindex];
		}if (nums[numberofindex] < minimum) {
			minimum = nums[numberofindex];
		}
		return arrayRange(nums, numberofindex + 1, minimum, maximum);
	}


  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
    return isSorted(nums, 0);
  }
  private boolean isSorted(int[] nums,int index) {
	  if(nums.length==0) {
		  return true;
	  }if(index==nums.length-1) {
          return true;
	  }if(nums[index]<=nums[index+1]) {
          return isSorted(nums, index+1);
	  }else {
          return false;
	  }
  }


  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
	  return found(search,strs,0);
  }
  private boolean found(String search,String[] strs,int index) {
	  if (strs.length==0) 
          return false; 
       if (strs[index].equals(search)) {
          return true;
       }if(strs.length!=index+1) {
    	   return found(search,strs,index+1);
       }
	return false;
  }
}
