package task1;

public class task1 {

    public static int ipToInt(String ip) {
        String[] octets = ip.split("\\.");
        int intIp = 0;
        for (String octet : octets) {
            intIp = (intIp << 8) + Integer.parseInt(octet);
        }
        return intIp;
    }

    public static String intToIp(long intIp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.insert(0, (intIp & 255));
            if (i < 3) {
                sb.insert(0, ".");
            }
            intIp = intIp >> 8;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ipStr = "127.0.0.1";
        int ipInt = ipToInt(ipStr);
        System.out.println(ipInt); // 2130706433



        long intIp = 2149583360L;
        String ipStr2 = intToIp(intIp);
        System.out.println(ipStr2); // "128.32.10.0"

        intIp = 255;
        ipStr2 = intToIp(intIp);
        System.out.println(ipStr2); // "0.0.0.255"
    }

}
