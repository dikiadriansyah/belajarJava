public class reversingStrings {
    public static void main(String[] args) {
        // Ada beberapa cara Anda dapat membalikkan string untuk membuatnya mundur

        // 1. StringBuilder/StringBuffer:
        // String perkenalan = "Hai Semua";
        // System.out.println(perkenalan);
        // output:
        // Hai Semua

        // StringBuilder sb = new StringBuilder(perkenalan);
        // perkenalan = sb.reverse().toString();
        // System.out.println(perkenalan);
        // output:
        // aumeS iaH

        // 2. char array:
        String salam = "Assalamualaikum";
        // System.out.println(salam);

        char[] arr = salam.toCharArray();
        for (int i = 0, mirroredIndex = arr.length - 1; i < mirroredIndex; i++, mirroredIndex--) {
            char t = arr[i];
            arr[i] = arr[mirroredIndex];
            arr[mirroredIndex] = t;
        }
        System.out.println(new String(arr));
        // output:
        // mukialaumalassA
    }
}
