public class Chapter1_5 {

	public static void main(String[] args) {
		Chapter1_5 test = new Chapter1_5();
		String str = "abcdddasfewaefddddafcccccaeeeeewwwwwwaaaabbbbbbbbbbbbbjjiel";
		System.out.println((str.length() <= test.countCompress(str)) ? str
				: test.compress(str));

	}

	public int countCompress(String oris) {
		if (oris == null || oris.isEmpty())
			return 0;
		char last = oris.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < oris.length(); i++) {
			if (oris.charAt(i) == last) {
				count++;
			} else {
				last = oris.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

	public String compress(String oris) {
		char[] str = oris.toCharArray();
		StringBuffer result = new StringBuffer();
		int i, j, count;
		for (i = 0; i < str.length;) {
			count = 1;
			result.append(str[i]);
			for (j = i + 1; j < str.length; j++) {
				if (str[i] != str[j]) {
					break;
				}
				count++;
			}
			i = j;
			result.append(count);

		}
		return result.toString();
		// return (result.toString().length() <= oris.length()) ? result
		// .toString() : oris;
	}
}
