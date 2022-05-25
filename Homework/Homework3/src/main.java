public class main {

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>(1);
		System.out.println(nums.size());
		nums.add(26459, 0);
		nums.add(534876, 1);
		nums.add(9999, 2);
		nums.add(706598, 3);
		nums.add(4658907, 0);
		System.out.println(nums.contains(26));
		System.out.println(nums.get(3));
		System.out.println(nums.size());
		System.out.println(nums.indexOf(9999)); 
		System.out.println(nums.isEmpty());
		nums.clear();
		System.out.println(nums.isEmpty());

	}

}
