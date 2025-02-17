public class MyIntStack {
   private int[] contents;
   private int tos;  // Dinh cua stack

   // Constructor
   public MyIntStack(int capacity) {
      contents = new int[capacity];
      tos = -1;
   }

   // Them mot phan tu vao stack
   public boolean push(int element) {
      if (isFull()) {
         // Stack da day, tang dung luong cua stack
         increaseCapacity();
      }
      
      contents[++tos] = element;
      return true;  // Thao tac thanh cong
   }

   // Lay mot phan tu ra khoi stack
   public int pop() {
      if (isEmpty()) {
         throw new IllegalStateException("Stack dang rong");
      }
      return contents[tos--];
   }

   // Xem phan tu o dinh stack ma khong lay ra
   public int peek() {
      if (isEmpty()) {
         throw new IllegalStateException("Stack dang rong");
      }
      return contents[tos];
   }

   // Kiem tra xem stack co rong khong
   public boolean isEmpty() {
      return tos < 0;
   }

   // Kiem tra xem stack co day khong
   public boolean isFull() {
      return tos == contents.length - 1;
   }

   // Tang dung luong cua stack khi no day
   private void increaseCapacity() {
      int newCapacity = contents.length * 2;  // Gap doi dung luong
      int[] newContents = new int[newCapacity];
      System.arraycopy(contents, 0, newContents, 0, contents.length);
      contents = newContents;
   }
   
   // Phuong thuc main de kiem tra lop MyIntStack
   public static void main(String[] args) {
      MyIntStack stack = new MyIntStack(3);  // Khoi tao stack voi kich thuoc 3

      System.out.println("Them cac phan tu vao stack:");
      stack.push(10);
      stack.push(20);
      stack.push(30);
      System.out.println("Stack da day: " + stack.isFull()); // Nen la true
      stack.push(40); // Se kich hoat tang dung luong
      System.out.println("Stack da day sau khi thay doi dung luong: " + stack.isFull()); // Nen la false
      
      System.out.println("Lay cac phan tu ra khoi stack:");
      System.out.println("Lay ra: " + stack.pop()); // Nen lay ra 40
      System.out.println("Lay ra: " + stack.pop()); // Nen lay ra 30
      System.out.println("Lay ra: " + stack.pop()); // Nen lay ra 20
      System.out.println("Lay ra: " + stack.pop()); // Nen lay ra 10
   }
}
