package my.awesome.Garaz;

public class custom24model {
    int Image;
    String Text;
    String Text2;
    String Text1;

    public custom24model(int image, String text, String text1,String text2) {

        Image = image;
        Text = text;
        Text2=text2;
        Text1 = text1;
    }

    public String getText2() {
        return Text2;
    }

    public void setText2(String text2) {
        Text2 = text2;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getText1() {
        return Text1;
    }

    public void setText1(String text1) {
        Text1 = text1;
    }
}
