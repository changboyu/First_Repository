public class Chapter1_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubstring(String str1, String str2) {
		return true;
	}

	public boolean isRotation(String str1, String str2) {
		int len = str1.length();
		if (len == str2.length() && len > 0) {
			String str1str1 = str1 + str1;
			return isSubstring(str2,str1str1);
		}
		return false;
	}
}
