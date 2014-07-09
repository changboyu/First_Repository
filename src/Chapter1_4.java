public class Chapter1_4 {
	public static void main(String args[]) {
		Chapter1_4 tst = new Chapter1_4();
		char[] ch = { 't', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ',
				' ', ' ', ' ', 'a', 'd' };
		int length = 9;
		tst.replaceSpaces(ch, length);

	}

	public void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + 2 * spaceCount;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength--;
			}
		}
		System.out.print(str);
	}
}
