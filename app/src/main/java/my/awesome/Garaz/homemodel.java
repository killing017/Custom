package my.awesome.Garaz;

public class homemodel {
    int draw_pic;
    String pic;
    String text;



    public homemodel(int draw_pic, String pic, String text) {
        this.draw_pic = draw_pic;
        this.pic = pic;
        this.text = text;
    }

    public int getDraw_pic() {
        return draw_pic;
    }

    public void setDraw_pic(int draw_pic) {
        this.draw_pic = draw_pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
