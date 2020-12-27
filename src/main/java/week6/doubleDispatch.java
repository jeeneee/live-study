package week6;

import java.util.Arrays;
import java.util.List;

public class doubleDispatch {
    interface Post { void postOn(SNS sns); }
    static class Text implements Post {
        public void postOn(SNS sns) { sns.post(this); }
    }
    static class Picture implements Post {
        public void postOn(SNS sns) { sns.post(this); }
    }

    interface SNS {
        void post(Text post);
        void post(Picture post);
    }
    static class Facebook implements SNS {
        public void post(Text post) { System.out.println("text -> facebook"); }
        public void post(Picture post) { System.out.println("picture -> facebook");}
    }
    static class Twitter implements SNS {
        public void post(Text post) { System.out.println("text -> twitter"); }
        public void post(Picture post) { System.out.println("picture -> twitter"); }
    }

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter());
        posts.forEach(p->sns.forEach(p::postOn));
    }
}
