import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] listStudents = new Student[0];
        while(true){
            System.out.println("**************BOOKS MANAGEMENT**************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Cập nhật thông tin sinh viên");
            System.out.println("4. Xóa thông tin sinh viên");
            System.out.println("5. Tìm sinh viên theo tên (tương đối)");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Danh sách sinh viên hiện có: \n");
                    for(Student student : listStudents){
                        student.displayData();
                    }
                    break;
                case 2:
                    System.out.print("Số lượng sinh viên muốn thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    Student[] newListST2 = new Student[listStudents.length +n];
                    for(int i = 0; i< listStudents.length; i++){
                        newListST2[i] = listStudents[i];
                    }
                    for(int i=0;i <n ;i++){
                        Student newStudent = new Student();
                        newStudent.inputData(sc);
                        newListST2[listStudents.length+i] = newStudent;
                    }
                    listStudents = newListST2;
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên muốn cập nhật thông tin: ");
                    String STChanged = sc.nextLine();
                    int changed = -1;
                    for(int i = 0; i< listStudents.length; i++){
                        if(listStudents[i].getId().equals(STChanged)){
                            System.out.println("Đã tìm thấy id của sinh viên");
                            changed = i;
                            break;
                        }
                    }
                    if(changed == -1){
                        System.out.println("Không tìm thấy sinh viên có id đã nhập");
                    }
                    int choice2 = -1;
                    while (choice2!=0){
                        System.out.println("Chọn thông tin muốn thay đổi:");
                        System.out.println("1. Tên sinh viên");
                        System.out.println("2. Tuổi sinh viên");
                        System.out.println("3. Chuyên ngành");
                        System.out.println("4. Hủy thay đổi");
                        System.out.print("Lựa chọn của bạn: ");
                        choice2 = Integer.parseInt(sc.nextLine());
                        switch(choice2){
                            case 1:
                                System.out.println("Nhập tên mới của sinh viên");
                                listStudents[changed].setName(sc.nextLine());
                                choice2 = 0;
                                break;
                            case 2:
                                System.out.println("Nhập tuổi mới của sinh viên");
                                listStudents[changed].setAge(Integer.parseInt(sc.nextLine()));
                                choice2 = 0;
                                break;
                            case 3:
                                System.out.println("Nhập chuyên ngành mới của sinh viên");
                                listStudents[changed].setMajor(sc.nextLine());
                                choice2 = 0;
                                break;
                            default:
                                choice2 = 0;
                                break;
                        }
                    }
                    break;
                case 4:
                    boolean found4 = false;
                    System.out.print("Nhập mã sinh viên muốn xóa: ");
                    String STDeleted = sc.nextLine();
                    int indexDeleted = -1;

                    for(int i = 0; i< listStudents.length; i++){
                        if(listStudents[i].getId().equals(STDeleted)){
                            System.out.println("Đã tìm thấy id của sách cần xóa");
                            indexDeleted = i;
                            found4 = true;
                            break;
                        }
                    }
                    if(!found4){
                        System.out.println("Không tìm thấy sách có id đã nhập");
                    }

                    int maxList4 = listStudents.length-1;
                    Student[] newListST4 = new Student[maxList4];

                    int d = 0;
                    for(int i = 0; i< listStudents.length; i++){
                        if(i == indexDeleted){
                            continue;
                        }
                        newListST4[d] = listStudents[i];
                        d++;
                    }
                    listStudents = newListST4;
                    break;
                case 5:
                    System.out.print("Nhập tên sinh viên muốn tìm: ");
                    String findName =  sc.nextLine().toLowerCase();

                    int f=0;
                    Student[] listFindStudents = new Student[listStudents.length];

                    for(Student student : listStudents){
                        if(student.getName().toLowerCase().contains(findName)){
                            listFindStudents[f] = student;
                            f++;
                        }
                    }

                    System.out.println("Danh sách sách có tên khớp từ khóa: ");
                    for(Student student : listFindStudents){
                        if(student == null) break;
                        student.displayData();
                    }
                    break;
                case 6: System.exit(0);
                default:
                    System.out.println("Vui lòng nhập số hợp lệ (1-6)");
                    break;
            }
        }

    }
}
