

import java.util.Arrays;



public class Flood_Fill_Algorithm {
    public static void main(String[] args) {
        char[][] image = {
            {'B', 'B', 'W'},
            {'W', 'W', 'W'},
            {'W', 'W', 'W'},
            {'B', 'B', 'B'}
        };

        int sr = 2, sc = 2;
        char C = 'G';

        char[][] result = floodFill(image, sr, sc, C);

        // Print updated image
        for (char[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static char[][] floodFill(char[][] image, int sr, int sc, char newColor) {
        int rows = image.length;
        int cols = image[0].length;

        char originalColor = image[sr][sc];
        if (originalColor == newColor) return image; 

        dfs(image, sr, sc, originalColor, newColor, rows, cols);
        return image;
    }
    private static void dfs(char[][] image, int r, int c, char originalColor, char newColor, int rows, int cols) {
        
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != originalColor) {
            return;
        }

        
        image[r][c] = newColor;

        
        dfs(image, r + 1, c, originalColor, newColor, rows, cols); 
        dfs(image, r - 1, c, originalColor, newColor, rows, cols); 
        dfs(image, r, c + 1, originalColor, newColor, rows, cols); 
        dfs(image, r, c - 1, originalColor, newColor, rows, cols); 
    }
}
