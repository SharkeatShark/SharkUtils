package com.shark.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *键盘排序 3位
 *
 * @date 2019-04-03 16:21:08
 */
public class CheckPwdUtil implements Serializable {
	public static char[][] keyCode = { { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' },
			{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
			{ 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';' },
			{ 'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/' } };
	public static boolean checkPwd(String str) {
		// String str = "";
		char[] c = str.toCharArray();
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		// List<String> xline = new ArrayList<String>();
		// List<String> yline = new ArrayList<String>();
		for (int i = 0; i < c.length; i++) {
			char temp = c[i];
			toHere: for (int j = 0; j < keyCode.length; j++) {
				for (int k = 0; k < keyCode[j].length; k++) {
					if (temp == keyCode[j][k]) {
						x.add(j);
						y.add(k);
						break toHere;
					}
				}
			}
		}
		boolean flag = false;
		for (int i = 0; i < x.size() - 2; i++) {
			// x b
			if (x.get(i) == x.get(i + 1) && x.get(i + 1) == x.get(i + 2)) {// 三者在同一y行上
				if (y.get(i) > y.get(i + 2)) {
					if (y.get(i) - 1 == y.get(i + 1) && y.get(i) - 2 == y.get(i + 2)) {
						flag = true;
						break;
					}
				} else {
					if (y.get(i) + 1 == y.get(i + 1) && y.get(i) + 2 == y.get(i + 2)) {
						flag = true;
						break;
					}
				}

			} else if (x.get(i) != x.get(i + 1) && x.get(i + 1) != x.get(i + 2) && x.get(i) != x.get(i + 2)) {// 三者均不在同一行上
				if (x.get(i) > x.get(i + 2)) {
					// System.out.println(">>>>>>");
					if ((x.get(i) - 1 == x.get(i + 1) && x.get(i) - 2 == x.get(i + 2))) {
						int aa = 0;
						// 列顺序 qaz
						String ss = columnOrderThree(keyCode, x, y, i);
						// 三个密码
						// System.out.println(c.length-2);
						for (int k = 0; k < c.length - 2; k++) {
							String d = str.substring(k, k + 3);

							if (d.equals(ss)) {
								flag = true;
								aa = 1;
								System.out.println(d + "++++" + ss.trim() + "===" + d.equals(ss.trim()));
								return true;
							}
						}
						if (aa == 0) {
							String ss2 = columnOrderFour(keyCode, x, y, i);
							for (int k = 0; k < c.length - 2; k++) {
								String d = str.substring(k, k + 3);

								if (d.equals(ss2)) {
									flag = true;
									aa = 1;
									System.out.println(d + "++++" + ss2.trim() + "===" + d.equals(ss2.trim()));
									return true;
								}
							}
						}
					}
				} else {
					if (x.get(i) + 1 == x.get(i + 1) && x.get(i) + 2 == x.get(i + 2)) {
						// System.out.println(x.get(i)+":"+Arrays.toString(keyCode[x.get(i)]));
						int aa = 0;
						// 列顺序 qaz
						String ss = columnOrder(keyCode, x, y, i);
						// 三个密码
						// System.out.println(c.length-2);
						for (int k = 0; k < c.length - 2; k++) {
							String d = str.substring(k, k + 3);

							if (d.equals(ss)) {
								flag = true;
								aa = 1;
								System.out.println(d + "++++" + ss.trim() + "===" + d.equals(ss.trim()));
								return true;
							}
						}

						if (aa == 0) {
							String ss2 = columnOrderTwo(keyCode, x, y, i);
							for (int k = 0; k < c.length - 2; k++) {
								String d = str.substring(k, k + 3);

								if (d.equals(ss2)) {
									flag = true;
									aa = 1;
									System.out.println(d + "++++" + ss2.trim() + "===" + d.equals(ss2.trim()));
									return true;
								}
							}
						}
					}
				}

			}

		}

		return flag;

	}

	private static String columnOrderFour(char[][] keyCode, List<Integer> x, List<Integer> y, int i) {
		String xline = Arrays.toString(keyCode[x.get(i)]);
		String[] xi = xline.replace("[", "").replace("]", "").split(",");
		// 第一行 第二个位置。
		// xi[y.get(i)]
		// 找第二行 第二个位置是否跟密码对应
		String xline2 = Arrays.toString(keyCode[x.get(i) - 1]);
		String[] xi2 = xline2.replace("[", "").replace("]", "").split(",");
		// xi2[y.get(i)]
		// 找第三行 第三个位置是否跟密码对应
		String xline3 = Arrays.toString(keyCode[x.get(i) - 2]);
		String[] xi3 = xline3.replace("[", "").replace("]", "").split(",");
		// xi3[y.get(i)];
		// System.out.println(y.get(i)+1);
		// System.out.println("位置4："+xi[y.get(i)]+"=1:::"+xi2[y.get(i)+1>=10?9:y.get(i)+1]+"=2::"+xi3[y.get(i)+2>=10?9:y.get(i)+2]+"=3");

		String ss = xi[y.get(i)] + xi2[y.get(i) + 1 >= 10 ? 9 : y.get(i) + 1]
				+ xi3[y.get(i) + 2 >= 10 ? 9 : y.get(i) + 2];
		return ss.replace(" ", "");
	}

	private static String columnOrderThree(char[][] keyCode, List<Integer> x, List<Integer> y, int i) {
		String xline = Arrays.toString(keyCode[x.get(i)]);
		String[] xi = xline.replace("[", "").replace("]", "").split(",");
		// 第一行 第二个位置。
		// xi[y.get(i)]
		// 找第二行 第二个位置是否跟密码对应
		String xline2 = Arrays.toString(keyCode[x.get(i) - 1]);
		String[] xi2 = xline2.replace("[", "").replace("]", "").split(",");
		// xi2[y.get(i)]
		// 找第三行 第三个位置是否跟密码对应
		String xline3 = Arrays.toString(keyCode[x.get(i) - 2]);
		String[] xi3 = xline3.replace("[", "").replace("]", "").split(",");
		// xi3[y.get(i)];
		// System.out.println("位置3："+xi[y.get(i)]+"=1:::"+xi2[y.get(i)]+"=2::"+xi3[y.get(i)]+"=3");
		String ss = xi[y.get(i)] + xi2[y.get(i)] + xi3[y.get(i)];
		return ss.replace(" ", "");
	}

	private static String columnOrderTwo(char[][] keyCode, List<Integer> x, List<Integer> y, int i) {
		String xline = Arrays.toString(keyCode[x.get(i)]);
		String[] xi = xline.replace("[", "").replace("]", "").split(",");
		// 第一行 第二个位置。
		// xi[y.get(i)]
		// 找第二行 第二个位置是否跟密码对应
		String xline2 = Arrays.toString(keyCode[x.get(i) + 1]);
		String[] xi2 = xline2.replace("[", "").replace("]", "").split(",");
		// xi2[y.get(i)]
		// 找第三行 第三个位置是否跟密码对应
		String xline3 = Arrays.toString(keyCode[x.get(i) + 2]);
		String[] xi3 = xline3.replace("[", "").replace("]", "").split(",");
		// xi3[y.get(i)];
		// System.out.println("位置2："+xi[y.get(i)]+"=1:::"+xi2[y.get(i)-1<=0?0:y.get(i)-1]+"=2::"+xi3[y.get(i)-2<=0?0:y.get(i)-2]+"=3");

		String ss = xi[y.get(i)] + xi2[y.get(i) - 1 <= 0 ? 0 : y.get(i) - 1]
				+ xi3[y.get(i) - 2 <= 0 ? 0 : y.get(i) - 2];
		return ss.replace(" ", "");
	}

	private static String columnOrder(char[][] keyCode, List<Integer> x, List<Integer> y, int i) {
		String xline = Arrays.toString(keyCode[x.get(i)]);
		String[] xi = xline.replace("[", "").replace("]", "").split(",");
		// 第一行 第二个位置。
		// xi[y.get(i)]
		// 找第二行 第二个位置是否跟密码对应
		String xline2 = Arrays.toString(keyCode[x.get(i) + 1]);
		String[] xi2 = xline2.replace("[", "").replace("]", "").split(",");
		// xi2[y.get(i)]
		// 找第三行 第二个位置是否跟密码对应
		String xline3 = Arrays.toString(keyCode[x.get(i) + 2]);
		String[] xi3 = xline3.replace("[", "").replace("]", "").split(",");
		// xi3[y.get(i)];
		// System.out.println("位置1："+xi[y.get(i)]+"=1:::"+xi2[y.get(i)]+"=2::"+xi3[y.get(i)]+"=3");

		String ss = xi[y.get(i)] + xi2[y.get(i)] + xi3[y.get(i)];
		return ss.replace(" ", "");
	}

}
