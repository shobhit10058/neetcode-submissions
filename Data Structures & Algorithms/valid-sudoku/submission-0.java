class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i += 1) {
            boolean[] visited = new boolean[10];
            Arrays.fill(visited, false);
            for (int j = 0; j < m; j += 1) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '0';
                if (visited[value]) {
                    return false;
                }
                visited[value] = true;
            }
        }

        
        for (int j = 0; j < m; j += 1) {
            boolean[] visited = new boolean[10];
            Arrays.fill(visited, false);
            for (int i = 0; i < n; i += 1) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '0';
                if (visited[value]) {
                    return false;
                }
                visited[value] = true;
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < m; j += 3) {
                boolean[] visited = new boolean[10];
                Arrays.fill(visited, false);
                for (int g = i; g < i + 3; g += 1) {
                    for (int h = j; h < j + 3; h += 1) {
                        if (board[g][h] == '.') {
                            continue;
                        }
                        int value = board[g][h] - '0';
                        if (visited[value]) {
                            return false;
                        }
                        visited[value] = true;
                    }
                }
            }
        }
        return true;
    }
}
