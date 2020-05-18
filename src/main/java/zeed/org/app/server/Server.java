package zeed.org.app.server;
//import org.jp

import org.jpos.q2.Q2;

public class Server {

    public static void main (String[] args) {
        Q2 q2 = new Q2("q2/deploy");
        q2.start();
    }


}
