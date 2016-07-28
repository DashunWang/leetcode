public class Solution {
    public List<String> restoreIpAddresses(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] ip = new int[4];
        List<String> list = new ArrayList<>();
        restore(arr, 0, ip, 0, list);
        return list;
    }
    
    private void restore(char[] arr, int start, int[] ip, int idx, List<String> list) {
        int len = arr.length;
        if (len == start || idx == 4) {
            if (  len == start && ( idx == 4 || (idx == 3 && ip[idx] != 0) )   ) list.add(int2str(ip));
            return;
        }
        if (arr[start] == '0' && ip[idx]==0) {
            restore(arr, start+1, ip, idx+1, list);
        }
        else {
            if (ip[idx]*10+arr[start]-'0'<256) {
                ip[idx] = ip[idx]*10+arr[start]-'0';
                restore(arr, start+1, ip, idx, list);
                ip[idx] /= 10;
            }
            if (ip[idx] > 0) restore(arr, start, ip, idx+1, list);
        }
    }
    
    private String int2str(int[] ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(ip[i]);
            sb.append('.');
        }
        sb.append(ip[3]);
        return sb.toString();
    }
}


