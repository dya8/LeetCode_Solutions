class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
         HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        // Iterate through each cell in the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                
                // Skip empty cells
                if (num == '.') {
                    continue;
                }
                
                // Calculate box index
                int boxIndex = (r / 3) * 3 + (c / 3);
                
                // Check if the number is already in the corresponding row, column, or box
                if (rows[r].contains(num) || cols[c].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }
                
                // Add the number to the corresponding row, column, and box sets
                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
            }
        }
        
        // If no duplicates found, the board is valid
        return true;
    }

    }
