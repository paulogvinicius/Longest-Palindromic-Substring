public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Palíndromo com centro ímpar (ex: "aba")
            int len1 = expandAroundCenter(s, i, i);
            // Palíndromo com centro par (ex: "abba")
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // Atualiza os índices da maior substring encontrada
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expande para fora enquanto os caracteres forem iguais
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Retorna o comprimento do palíndromo encontrado
        return right - left - 1;
    }
}
