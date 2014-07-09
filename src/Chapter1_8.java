public class Chapter1_8 {


		public static void main(String[] args) {
			String str1 = "waterbottle";
			String str2 = "erbottlewat";

			System.out.println(isRotation(str1, str2));

		}

		public static boolean isSubstring(String big, String small) {
			if (big.indexOf(small) >= 0) {
				return true;
			} else {
				return false;
			}
		}


	public static boolean isRotation(String str1, String str2) {
		int len = str1.length();
		if (len == str2.length() && len > 0) {
			String str1str1 = str1 + str1;
			
			return isSubstring(str1str1,str2);
		}
		return false;
	}
}
