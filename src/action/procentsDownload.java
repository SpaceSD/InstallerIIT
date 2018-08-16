package action;

public class procentsDownload {
    public static int procentDownload(double currentsize, double totalsize){

        int procents = (int)(currentsize * 100 / totalsize);
        return procents;

    }
}
