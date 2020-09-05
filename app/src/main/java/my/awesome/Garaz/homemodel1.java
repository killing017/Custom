package my.awesome.Garaz;

public class homemodel1 {
    int draw_pic;
    String text;
    String text1;
    String text2;
    String text3;
    String text4;

    public homemodel1(int draw_pic, String text, String text1, String text2, String text3, String text4) {
        this.draw_pic = draw_pic;
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public int getDraw_pic() {
        return draw_pic;
    }

    public void setDraw_pic(int draw_pic) {
        this.draw_pic = draw_pic;
    }

    public  String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }
}
