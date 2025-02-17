package MyTimeMyDate;

class MyTime {
    private int gio, phut, giay;

    public MyTime(int gio, int phut, int giay) {
        setThoiGian(gio, phut, giay);
    }

    public void setThoiGian(int gio, int phut, int giay) {
        if (gio < 0 || gio > 23 || phut < 0 || phut > 59 || giay < 0 || giay > 59) {
            throw new IllegalArgumentException("Giờ, phút hoặc giây không hợp lệ!");
        }
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    public int getGio() { return gio; }
    public int getPhut() { return phut; }
    public int getGiay() { return giay; }

    public void setGio(int gio) {
        if (gio < 0 || gio > 23) throw new IllegalArgumentException("Giờ không hợp lệ!");
        this.gio = gio;
    }
    public void setPhut(int phut) {
        if (phut < 0 || phut > 59) throw new IllegalArgumentException("Phút không hợp lệ!");
        this.phut = phut;
    }
    public void setGiay(int giay) {
        if (giay < 0 || giay > 59) throw new IllegalArgumentException("Giây không hợp lệ!");
        this.giay = giay;
    }

    public MyTime tangGiay() {
        giay++;
        if (giay == 60) {
            giay = 0;
            tangPhut();
        }
        return this;
    }

    public MyTime tangPhut() {
        phut++;
        if (phut == 60) {
            phut = 0;
            tangGio();
        }
        return this;
    }

    public MyTime tangGio() {
        gio = (gio + 1) % 24;
        return this;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", gio, phut, giay);
    }
}

class MyDate {
    private int nam, thang, ngay;
    private static final String[] THANGS = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
    private static final int[] NGAY_TRONG_THANG = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int nam, int thang, int ngay) {
        setNgay(nam, thang, ngay);
    }

    public void setNgay(int nam, int thang, int ngay) {
        if (!laNgayHopLe(nam, thang, ngay)) {
            throw new IllegalArgumentException("Năm, tháng hoặc ngày không hợp lệ!");
        }
        this.nam = nam;
        this.thang = thang;
        this.ngay = ngay;
    }

    public static boolean laNamNhuan(int nam) {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }

    public static boolean laNgayHopLe(int nam, int thang, int ngay) {
        if (nam < 1 || nam > 9999 || thang < 1 || thang > 12) return false;
        int maxNgay = NGAY_TRONG_THANG[thang - 1];
        if (thang == 2 && laNamNhuan(nam)) maxNgay = 29;
        return ngay >= 1 && ngay <= maxNgay;
    }

    public String toString() {
        return String.format("%s %02d, %04d", THANGS[thang - 1], ngay, nam);
    }
}

 class KiemThuNgayGio {
    public static void main(String[] args) {
        // Kiểm tra MyTime
        MyTime thoiGian = new MyTime(23, 59, 58);
        System.out.println("Thời gian hiện tại: " + thoiGian);
        thoiGian.tangGiay().tangGiay();
        System.out.println("Sau 2 giây: " + thoiGian);

        // Kiểm tra MyDate
        MyDate ngay = new MyDate(2024, 2, 28);
        System.out.println("Ngày hiện tại: " + ngay);
        ngay.setNgay(2024, 2, 29);
        System.out.println("Ngày năm nhuận: " + ngay);
    }
}
