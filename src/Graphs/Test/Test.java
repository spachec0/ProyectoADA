package Graphs.Test;

import Graphs.Algorithms.BarabasiAlbert;
import Graphs.Algorithms.ErdosRenyi;
import Graphs.Algorithms.Gilbert;
import Graphs.Algorithms.SimpleGeographical;

public class Test {

    public static void main(String[] args) {

        ErdosRenyi erdos = new ErdosRenyi(500, 750, true);
        Gilbert gilbert = new Gilbert(500, 0.05, true);
        SimpleGeographical gs = new SimpleGeographical(30, 0.5, false);
//        30 - 5, 100 - 20, 500 -25
        BarabasiAlbert ba = new BarabasiAlbert(500, 25, true);

    }

}
