package my.awesome.Garaz;

public class carmodel {
    int Image;
    String Text;
    String Text1;

    public carmodel(int image, String text, String text1) {
        Image = image;
        Text = text;
        Text1 = text1;
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
