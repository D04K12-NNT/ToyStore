package application;

import model.MyStore;
import model.Store;
import model.Toy;
import util.DBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

final class Application {

	private final static int THEM_SAN_PHAM = 1;
	private final static int TIM_KIEM_THEO_MA = 2;
	private final static int SAP_XEP_THEO_GIA_TANG_DAN = 3;
	private final static int SAN_PHAM_HET_HAN = 4;
	private final static int THOAT = 5;

	public static void main(String[] args) {
		Store myStore = new MyStore("MyStore");
		Scanner in = new Scanner(System.in);
		int option = -1;
		while (option != THOAT) {
			try {
				System.out.println("----------------Toy Store----------------");
				System.out.println("1. Thêm sản phẩm");
				System.out.println("2. Tìm kiếm sản phẩm");
				System.out.println("3. Sắp xếp theo giá tăng dần");
				System.out.println("4. Lấy ra các sản phẩm đã quá hạn 1 năm");
				System.out.println("5. Thoát");
				System.out.println();
				System.out.print("Nhập lựa chọn: ");

				option = Integer.parseInt(in.nextLine());

				switch (option) {

				case THEM_SAN_PHAM:
					// Nhập thông tin sản phẩm tại đây
					Toy t1 = new Toy();

					System.out.print("\t Mã sản phẩm: ");
					t1.setCode(in.nextLine());

					System.out.print("\t Tên sản phẩm: ");
					t1.setName(in.nextLine());

					System.out.print("\t Giá sản phẩm: ");
					t1.setPrice(Double.parseDouble(in.nextLine()));

					System.out.print("\t Mô tả: ");
					t1.setDescription(in.nextLine());

					System.out.print("\t Ngày nhập (DD-MM-YYYY): ");
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					Date parsed = format.parse(in.nextLine());
					t1.setReceiptDate(new java.sql.Date(parsed.getTime()));

					myStore.insertProduct(t1);

					break;

				case TIM_KIEM_THEO_MA:
					System.out.print("Nhập mã code sản phẩm: ");
					String keyword = in.nextLine();
					Toy t2 = myStore.searchProductByCode(keyword);
					System.out.println(t2);
					break;

				case SAP_XEP_THEO_GIA_TANG_DAN:
					List<Toy> list1 = myStore.orderByASC();
					for (Toy t3 : list1) {
						System.out.println(t3);
					}
					break;

				case SAN_PHAM_HET_HAN:
					List<Toy> list2 = myStore.listExpiration();
					for (Toy t4 : list2) {
						System.out.println(t4);
					}
					break;

				case THOAT:
					System.out.println("Thoát khỏi chương trình");
					break;

				default:
					System.out.println("Lựa chọn không hợp lệ");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			in.close();
			DBHelper.getDefaultInstance().getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
