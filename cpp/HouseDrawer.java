import java.io.*;
import java.util.*;

public class HouseDrawer {
    static class HouseSpec {
        int length;
        int height;
        char direction;
        int roofHeight;
        int totalHeight;
    }

    private static void drawHouse(char[][] canvas, HouseSpec h, int startCol, int H) {
        int floor = H - 1;
        boolean inverted = (h.direction == 'U' || h.direction == 'D');
        boolean swap = (h.direction == 'L' || h.direction == 'R');

        char lw = swap ? '&' : '@';
        char rw = swap ? '@' : '&';

        int bottom = floor;
        int top = floor - h.totalHeight + 1;

        if (!inverted) {
            for (int c = 0; c < h.length; c++) canvas[bottom][startCol + c] = '#';
            for (int r = 1; r < h.height; r++) {
                int row = bottom - r;
                canvas[row][startCol] = lw;
                canvas[row][startCol + h.length - 1] = rw;
            }
            int roofStart = bottom - h.height;
            for (int r = 0; r < h.roofHeight; r++) {
                int row = roofStart - r;
                canvas[row][startCol + r] = '/';
                canvas[row][startCol + h.length - 1 - r] = '\\';
            }
        } else {
            for (int c = 0; c < h.length; c++) canvas[top][startCol + c] = '#';
            for (int r = 1; r < h.height; r++) {
                int row = top + r;
                canvas[row][startCol] = lw;
                canvas[row][startCol + h.length - 1] = rw;
            }
            int roofStart = top + h.height;
            for (int r = 0; r < h.roofHeight; r++) {
                int row = roofStart + r;
                canvas[row][startCol + r] = '\\';
                canvas[row][startCol + h.length - 1 - r] = '/';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        String[] tokens = line.trim().split("\\s+");
        List<HouseSpec> list = new ArrayList<>();

        int maxH = 0, totalW = 0;

        for (String t : tokens) {
            int x = t.indexOf('x');
            if (x == -1) continue;

            HouseSpec h = new HouseSpec();
            h.length = Integer.parseInt(t.substring(0, x));

            int p = x + 1;
            while (p < t.length() && Character.isDigit(t.charAt(p))) p++;
            h.height = Integer.parseInt(t.substring(x + 1, p));
            h.direction = (p < t.length() ? t.charAt(p) : ' ');

            h.roofHeight = h.length / 2;
            h.totalHeight = h.height + h.roofHeight;

            maxH = Math.max(maxH, h.totalHeight);
            totalW += h.length;

            list.add(h);
        }

        char[][] canvas = new char[maxH][totalW];
        for (int i = 0; i < maxH; i++) Arrays.fill(canvas[i], ' ');

        int col = 0;
        for (HouseSpec h : list) {
            drawHouse(canvas, h, col, maxH);
            col += h.length;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxH; i++) sb.append(canvas[i]).append('\n');
        System.out.print(sb);
    }
}