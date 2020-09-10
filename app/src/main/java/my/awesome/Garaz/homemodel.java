package my.awesome.Garaz;

public class homemodel {
    int draw_pic;
    String pic;
    String text;
     String id;



    public homemodel(int draw_pic, String pic, String text,String id) {
        this.draw_pic = draw_pic;
        this.pic = pic;
        this.text = text;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
